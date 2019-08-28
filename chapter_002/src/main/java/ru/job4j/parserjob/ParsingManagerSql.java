package ru.job4j.parserjob;

import org.quartz.SchedulerException;

import java.io.IOException;

public class ParsingManagerSql {

    ParserJobSqlRu parserJobSqlRu;

    ParserJobBaseDateWork parserJobBaseDateWork;

    String url;

    TimeManagerQ timeManagerQ;

    public ParsingManagerSql(ParserJobSqlRu parserJobSqlRu, ParserJobBaseDateWork parserJobBaseDateWork, String url, TimeManagerQ timeManagerQ) {
        this.parserJobSqlRu = parserJobSqlRu;
        this.parserJobBaseDateWork = parserJobBaseDateWork;
        this.url = url;
        this.timeManagerQ = timeManagerQ;
    }


    public void manage() {

    }

    public void beginLookAtVacancy() throws SchedulerException {

        timeManagerQ.task();
    }

    public ParserJobSqlRu getParserJobSqlRu() {

        return new ParserJobSqlRu(this.url, this.parserJobSqlRu.getVacancySet(), this.parserJobSqlRu.javaF);
    }

    public ParserJobBaseDateWork getParserJobBaseDateWork() {
        return parserJobBaseDateWork;
    }
}
