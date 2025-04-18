package cn.bugstack.middleware.ratelimiter.valve.impl;

import cn.bugstack.middleware.ratelimiter.Constants;
import cn.bugstack.middleware.ratelimiter.annotation.DoRateLimiter;
import cn.bugstack.middleware.ratelimiter.valve.IValveService;
import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

public class RateLimiterValve implements IValveService {

    @Override
    public Object access(ProceedingJoinPoint jp, Method method, DoRateLimiter doRateLimiter, Object[] args)
            throws Throwable {
        // 判断是否开启
        if (0 == doRateLimiter.permitsPerSecond())
            return jp.proceed();

        String clazzName = jp.getTarget().getClass().getName();
        String methodName = method.getName();

        String key = clazzName + "." + methodName;

        if (null == Constants.rateLimiterMap.get(key)) {
            Constants.rateLimiterMap.put(key, RateLimiter.create(doRateLimiter.permitsPerSecond()));
        }

        RateLimiter rateLimiter = Constants.rateLimiterMap.get(key);
        if (rateLimiter.tryAcquire()) {
            return jp.proceed();
        }

        return JSON.parseObject(doRateLimiter.returnJson(), method.getReturnType());
    }

}
