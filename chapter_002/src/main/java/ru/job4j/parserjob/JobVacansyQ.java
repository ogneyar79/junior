package ru.job4j.parserjob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;

public class JobVacansyQ implements Job {


    ParsingManagerSql managerSql;


    public JobVacansyQ(ParsingManagerSql managerSql) {
        this.managerSql = managerSql;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final Logger LOG = LogManager.getLogger(JobVacansyQ.class.getName());

        ParserJobSqlRu parserJobSqlRu = new ParserJobSqlRu(managerSql.url, managerSql.getParserJobSqlRu().vacancySet, managerSql.getParserJobSqlRu().javaF);
        try {
            parserJobSqlRu.parseVacancies(parserJobSqlRu.url, parserJobSqlRu.vacancySet, parserJobSqlRu.javaF);
            parserJobSqlRu.getVacancySet();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
