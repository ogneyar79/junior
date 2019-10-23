package ru.job4j.parserjob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class JobVacansyQ implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Configjob configjob = new Configjob();
        ParserJobBaseDateWork parserJobBaseDateWork = new ParserJobBaseDateWork(configjob);
        parserJobBaseDateWork.setConnection(configjob);

        Set<Vacancy> vacancySet = new HashSet<>();
        String javaFinder = "Java";
        String htmlPathOne = "C:\\projects\\sirotkinmaksim\\chapter_002\\src\\test\\java\\resources\\SqlJob\\tableOne.html";

        File file = new File(htmlPathOne);

        ParserJobSqlRu parserJobSqlRu = new ParserJobSqlRu(vacancySet, javaFinder, file);

        ParsingManagerSql managerSql;
        try {
            managerSql = new ParsingManagerSql(parserJobSqlRu, parserJobBaseDateWork);
            parserJobSqlRu.setMaxDate(LocalDateTime.of(2002, 01, 01, 00, 01, 01));
            managerSql.work();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}

