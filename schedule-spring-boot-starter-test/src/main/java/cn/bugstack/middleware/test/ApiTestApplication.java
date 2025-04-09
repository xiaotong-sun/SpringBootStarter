package cn.bugstack.middleware.test;

import cn.bugstack.middleware.schedule.annotation.EnableDcsScheduling;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDcsScheduling
public class ApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }

}
