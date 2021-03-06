package ru.job4j.parserjob;

import org.junit.Before;
import org.junit.Test;
import org.quartz.Job;
import org.quartz.SchedulerException;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ParsingManagerSqlTest {

    String url = "https://www.sql.ru/forum/job/";
    Set<Vacancy> vacancySet = new HashSet<>();
    String javaFinder = "Java";
    Configjob configjob = new Configjob();
    String htmlPathOne = "C:\\projects\\sirotkinmaksim\\chapter_002\\src\\test\\java\\resources\\SqlJob\\tableOne.html";


    ParsingManagerSql parsingManagerSql;
    ParserJobBaseDateWork parserJobBaseDateWork;
    ParserJobSqlRu parserJobSqlRu;
    TimeManagerQ timeManagerQ;


    @Before
    public void init() throws SchedulerException {
        timeManagerQ = new TimeManagerQ();
        parserJobBaseDateWork = new ParserJobBaseDateWork(configjob);
        parserJobSqlRu = new ParserJobSqlRu(url, vacancySet, javaFinder);
        parsingManagerSql = new ParsingManagerSql(parserJobSqlRu, parserJobBaseDateWork, url, timeManagerQ);
        parsingManagerSql.file = new File(htmlPathOne);
        Job jobVacansyQ = new JobVacansyQ();
        parsingManagerSql.beginWork();
    }

    @Test
    public void work() throws Exception {
        parsingManagerSql.beginWork();
    }

}