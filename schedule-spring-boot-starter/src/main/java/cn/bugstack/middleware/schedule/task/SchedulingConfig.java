package cn.bugstack.middleware.schedule.task;

import cn.bugstack.middleware.schedule.common.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration("bugstack-middlware-schedule-schedulingConfig")
public class SchedulingConfig {

    @Bean("bugstack-middlware-schedule-taskScheduler")
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(Constants.Global.schedulePoolSize);
        taskScheduler.setRemoveOnCancelPolicy(true);
        taskScheduler.setThreadNamePrefix("BugstackMiddlewareScheduleThreadPool-");
        return taskScheduler;
    }

}
