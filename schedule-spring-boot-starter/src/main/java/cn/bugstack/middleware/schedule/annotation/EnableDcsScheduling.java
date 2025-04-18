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

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Import({ DcsSchedulingConfiguration.class })
@ImportAutoConfiguration({ SchedulingConfig.class, CronTaskRegister.class, DoJoinPoint.class })
@ComponentScan("cn.bugstack.middleware.*")
public @interface EnableDcsScheduling {
}
