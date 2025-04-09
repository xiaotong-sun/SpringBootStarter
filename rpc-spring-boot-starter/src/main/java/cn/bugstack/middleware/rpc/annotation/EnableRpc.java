package cn.bugstack.middleware.rpc.annotation;

import cn.bugstack.middleware.rpc.config.ServerAutoConfiguration;
import cn.bugstack.middleware.rpc.config.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({ServerAutoConfiguration.class})
@EnableConfigurationProperties(ServerProperties.class)
@ComponentScan("cn.bugstack.middleware.*")
public @interface EnableRpc {

}
