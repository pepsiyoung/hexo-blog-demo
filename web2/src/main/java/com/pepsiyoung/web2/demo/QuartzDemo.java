package com.pepsiyoung.web2.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
@Profile("discard")
public class QuartzDemo implements SchedulingConfigurer {

    String indSchedulerJobTime = "*/2 * * * * ?";
    Integer count = 0;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(() -> {
            // 执行任务逻辑
            System.out.println(LocalDateTime.now() + "执行时间  ：" + indSchedulerJobTime);
            if (count > 4) {
                System.out.println("改为每5秒执行一次");
                indSchedulerJobTime = "*/5 * * * * ?";
            }
            count++;
        }, triggerContext -> {
            // 任务触发，可修改任务的执行周期
            CronTrigger trigger = new CronTrigger(indSchedulerJobTime);
            return trigger.nextExecutionTime(triggerContext);
        });
    }
}
