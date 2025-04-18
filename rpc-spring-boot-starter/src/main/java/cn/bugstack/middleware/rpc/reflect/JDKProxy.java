package cn.bugstack.middleware.rpc.reflect;

import cn.bugstack.middleware.rpc.network.msg.Request;
import cn.bugstack.middleware.rpc.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, Request request) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(request);
        ClassLoader classLoader = ClassLoaderUtils.getCurrentClassLoader();
        T result = (T) Proxy.newProxyInstance(classLoader, new Class[] { interfaceClass }, handler);
        return result;
    }

}
