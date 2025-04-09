package cn.bugstack.middleware.rpc.config.spring.bean;

import com.alibaba.fastjson.JSON;
import cn.bugstack.middleware.rpc.config.ProviderConfig;
import cn.bugstack.middleware.rpc.domain.LocalServerInfo;
import cn.bugstack.middleware.rpc.domain.RpcProviderConfig;
import cn.bugstack.middleware.rpc.registry.RedisRegistryCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ProviderBean extends ProviderConfig implements ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(ProviderBean.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        RpcProviderConfig rpcProviderConfig = new RpcProviderConfig();
        rpcProviderConfig.setNozzle(nozzle);
        rpcProviderConfig.setRef(ref);
        rpcProviderConfig.setAlias(alias);
        rpcProviderConfig.setHost(LocalServerInfo.LOCAL_HOST);
        rpcProviderConfig.setPort(LocalServerInfo.LOCAL_PORT);

        //注册生产者
        long count = RedisRegistryCenter.registryProvider(nozzle, alias, JSON.toJSONString(rpcProviderConfig));

        logger.info("注册生产者：{} {} {}", nozzle, alias, count);
    }

}
