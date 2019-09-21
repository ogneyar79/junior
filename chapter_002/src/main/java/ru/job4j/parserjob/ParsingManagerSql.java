package ru.job4j.parserjob;

import org.quartz.SchedulerException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Class parsing site manager.
 *
 * @version 0.2
 * @autor Sirotkin Maksim
 * @since 30.08.19
 */
public class ParsingManagerSql {

    /**
     * field parsing object.
     */
    ParserJobSqlRu parserJobSqlRu;

    /**
     * field configuration connection.
     */
    Configjob configjob;

    public Configjob getConfigjob() {
        return configjob;
    }

    public String getUrl() {
        return url;
    }

    public ParserJobSqlRu getParserJobSqlRu() {
        return parserJobSqlRu;
    }

    /**
     * field conection baseDate object.
     */
    ParserJobBaseDateWork parserJobBaseDateWork;

    /**
     * field link for conection with site.
     */
    String url;

    /**
     * field Time manager  object How often we use our program.
     */
    TimeManagerQ timeManagerQ;

    /**
     * Constructor of new object
     *
     * @param parserJobSqlRu
     * @param parserJobBaseDateWork
     * @param url
     * @param timeManagerQ
     * @see ParsingManagerSql(ParserJobSqlRu , ParserJobBaseDateWork, String, TimeManagerQ)
     */
    public ParsingManagerSql(ParserJobSqlRu parserJobSqlRu, ParserJobBaseDateWork parserJobBaseDateWork, String url, TimeManagerQ timeManagerQ) throws SchedulerException {
        this.parserJobSqlRu = parserJobSqlRu;
        this.parserJobBaseDateWork = parserJobBaseDateWork;
        this.url = url;
        this.timeManagerQ = timeManagerQ;
    }


    /**
     * Procedure starting to Work, actually  start timeManager{@link ParserJobSqlRu#url}
     */
    public void beginWork() throws SchedulerException {
        try {
            this.timeManagerQ.task();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function getting field ParserJobBaseDateWork object {@link ParserJobSqlRu#url}
     *
     * @return object.
     */
    public ParserJobBaseDateWork getParserJobBaseDateWork() {
        return parserJobBaseDateWork;
    }

    /**
     * Procedure creation private field ParserJobSqlRu about maxDate for search vacancy. We get it from ParserJobBaseDateWork object.
     */
    public void setMaxDate() {
        this.parserJobSqlRu.setMaxDate(this.parserJobBaseDateWork.getDateMaxFromBase());
    }

    /**
     * Function getting field information have elements at collection from ParserJobSqlRu or not.
     * Yes(have or has) = false.
     *
     * @return boolean.
     */
    public boolean getInfoIsElementsAtSet() {
        return !this.getParserJobSqlRu().vacancySet.isEmpty();
    }
}
