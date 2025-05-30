package cn.bugstack.middleware.db.router.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface DBRouter {

    String key() default "";

}
