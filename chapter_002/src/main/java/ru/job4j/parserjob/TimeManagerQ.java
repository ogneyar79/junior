package ru.job4j.parserjob;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;

public class TimeManagerQ {

    Class<? extends Job> execute;

    public void task() throws SchedulerException {


        SchedulerFactory schedulerFactory = new StdSchedulerFactory();     // Запускаем Schedule Factory

        Scheduler scheduler = schedulerFactory.getScheduler();   // Извлекаем планировщик из schedule factory

        scheduler.start();                                   // And start it off


        long ctime = System.currentTimeMillis();                    //текущее время

        JobDetail jobDetail = newJob(execute)
                .withIdentity("jobVacancyQ").build();     // Запускаем JobDetail с именем задания, группой задания и классом выполняемого задания

        Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 1/1 * ? *")).build();

        scheduler.scheduleJob(jobDetail, cronTrigger);

    }


}
