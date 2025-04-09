package cn.bugstack.middleware.hystrix.valve;

import cn.bugstack.middleware.hystrix.annotation.DoHystrix;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public interface IValveService {

    Object access(ProceedingJoinPoint jp, Method method, DoHystrix doHystrix, Object[] args) throws Throwable;

}
