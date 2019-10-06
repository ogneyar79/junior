package ru.job4j.parserjob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class TimeManagerQ {

    private static final Logger LOGGER = LogManager.getLogger(TimeManagerQ.class.getName());

    // Class<? super Job> execute;    // Когда можно и нужно использовать эту переменную, причем когда я пытался в тесте использовать ее не пролучилось

    public void task() throws SchedulerException {
        String cronTimer = null;

        try (InputStream inputStream = TimeManagerQ.class.getClassLoader().getResourceAsStream("jobSql.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            cronTimer = properties.getProperty("cron.time");
        } catch (IOException e) {
            LOGGER.error("error load profile", e);
        }

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        JobDetail jobDetail = JobBuilder.newJob(JobVacansyQ.class).withIdentity("jobVacansyQ", "group1")
                .build(); // ? До конца не понял, что за group1
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow().
                        withSchedule(CronScheduleBuilder
                                .cronSchedule(cronTimer)).build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

    public static void main(String[] args) {
        TimeManagerQ parser = new TimeManagerQ();
        try {
            parser.task();
        } catch (SchedulerException e) {
            LOGGER.error("ERROR", e);
        }

    }
}

