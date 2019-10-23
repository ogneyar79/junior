package ru.job4j.parserjob;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ParserJobBaseDateWorkTest {


    Configjob configjob = new Configjob();
    ParserJobBaseDateWork parserJobBaseDateWork = new ParserJobBaseDateWork(configjob);


    @Test
    public void setConnection() throws Exception {

        parserJobBaseDateWork.setConnection(configjob);
    }

    @Test
    public void createStructure() throws Exception {
        String create = "CREATE TABLE IF NOT EXISTS  vacancy ( id integer unique, "
                +
                "    name text, "
                +
                "    link text, "
                +
                "      elTiempo timestamp )";
        parserJobBaseDateWork.setConnection(configjob);
        parserJobBaseDateWork.createStructure(create);
    }

    @Test
    public void addVacansy() throws Exception {
        parserJobBaseDateWork.setConnection(configjob);
        Vacancy vacancy = new Vacancy(1, "Java Developer", "WWW//JobSql", LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        Set<Vacancy> vacancies = new HashSet<>();
        vacancies.add(vacancy);

        parserJobBaseDateWork.addVacansy(vacancies);

    }

    @Test
    public void getDateMaxFromBaseAndGetVacanciesFromBase() throws Exception {
        parserJobBaseDateWork.setConnection(configjob);
        Vacancy vacancy = new Vacancy(2, " Java S", " WWW//JobSQl", LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        Set<Vacancy> vacancies = new HashSet<>();
        vacancies.add(vacancy);
        parserJobBaseDateWork.addVacansy(vacancies);
        parserJobBaseDateWork.getVacanciesFromBase();
        parserJobBaseDateWork.getDateMaxFromBase();
    }
}