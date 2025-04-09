package cn.bugstack.middleware.rpc.config.spring.bean;

import cn.bugstack.middleware.rpc.config.ConsumerConfig;
import cn.bugstack.middleware.rpc.domain.RpcProviderConfig;
import cn.bugstack.middleware.rpc.network.client.ClientSocket;
import cn.bugstack.middleware.rpc.network.msg.Request;
import cn.bugstack.middleware.rpc.reflect.JDKProxy;
import cn.bugstack.middleware.rpc.registry.RedisRegistryCenter;
import cn.bugstack.middleware.rpc.util.ClassLoaderUtils;
import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.FactoryBean;

public class ConsumerBean<T> extends ConsumerConfig implements FactoryBean {

    private ChannelFuture channelFuture;

    private RpcProviderConfig rpcProviderConfig;

    @Override
    public Object getObject() throws Exception {

        //从redis获取链接
        if (null == rpcProviderConfig) {
            String infoStr = RedisRegistryCenter.obtainProvider(nozzle, alias);
            rpcProviderConfig = JSON.parseObject(infoStr, RpcProviderConfig.class);
        }
        assert null != rpcProviderConfig;

        //获取通信channel
        if (null == channelFuture) {
            ClientSocket clientSocket = new ClientSocket(rpcProviderConfig.getHost(), rpcProviderConfig.getPort());
            new Thread(clientSocket).start();
            for (int i = 0; i < 100; i++) {
                if (null != channelFuture) break;
                Thread.sleep(500);
                channelFuture = clientSocket.getFuture();
            }
        }
        
        Request request = new Request();
        request.setChannel(channelFuture.channel());
        request.setNozzle(nozzle);
        request.setRef(rpcProviderConfig.getRef());
        request.setAlias(alias);
        return (T) JDKProxy.getProxy(ClassLoaderUtils.forName(nozzle), request);
    }

    @Override
    public Class<?> getObjectType() {
        try {
            return ClassLoaderUtils.forName(nozzle);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
