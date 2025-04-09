package cn.bugstack.middleware.methodext.annotation;

import java.lang.annotation.*;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoMethodExt {

    String method() default "";
    String returnJson() default "";

}
