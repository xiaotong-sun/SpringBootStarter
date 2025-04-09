package cn.bugstack.middleware.rpc.reflect;

import cn.bugstack.middleware.rpc.network.msg.Request;
import cn.bugstack.middleware.rpc.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 博  客：http://bugstack.cn
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * create by 小傅哥
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, Request request) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(request);
        ClassLoader classLoader = ClassLoaderUtils.getCurrentClassLoader();
        T result = (T) Proxy.newProxyInstance(classLoader, new Class[]{interfaceClass}, handler);
        return result;
    }

}
