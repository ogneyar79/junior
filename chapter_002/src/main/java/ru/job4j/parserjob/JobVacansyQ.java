package ru.job4j.parserjob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JobVacansyQ implements Job {


    ParsingManagerSql managerSql;


    public JobVacansyQ(ParsingManagerSql managerSql) {
        this.managerSql = managerSql;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        managerSql.work();

    }


}

