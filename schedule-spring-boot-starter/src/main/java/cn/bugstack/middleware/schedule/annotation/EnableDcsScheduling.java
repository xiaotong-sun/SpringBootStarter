package cn.bugstack.middleware.schedule.annotation;

import cn.bugstack.middleware.schedule.DoJoinPoint;
import cn.bugstack.middleware.schedule.config.DcsSchedulingConfiguration;
import cn.bugstack.middleware.schedule.task.CronTaskRegister;
import cn.bugstack.middleware.schedule.task.SchedulingConfig;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 博  客：http://bugstack.cn
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * create by 小傅哥
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DcsSchedulingConfiguration.class})
@ImportAutoConfiguration({SchedulingConfig.class, CronTaskRegister.class, DoJoinPoint.class})
@ComponentScan("cn.bugstack.middleware.*")
public @interface EnableDcsScheduling {
}
