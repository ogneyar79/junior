package ru.job4j.parserjob;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class ParserJobSqlRu {

    String url;

    File htmlFile;

    public Set<Vacancy> getVacancySet() {
        return vacancySet;
    }

    /**
     * Array conteiner for vacansies.
     */
    Set<Vacancy> vacancySet;

    /**
     * Vacancy is being looked for.
     */
    String javaF;    //  In our case we going to look for vacancy with "Java"

    public ParserJobSqlRu(String url, File htmlFile) {
        this.url = url;
        this.htmlFile = htmlFile;
    }

    public ParserJobSqlRu(String url, Set<Vacancy> vacancySet, String javaF) {
        this.url = url;
        this.vacancySet = vacancySet;
        this.javaF = javaF;
    }

    public Document connectToPageAndGetDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    public String getUrl() {
        return url;
    }

    /**
     * metod for parsing vacancies  from site.
     *
     * @param url String url.
     * @param vacancySet
     */
    public void parseVacancies(String url, Set<Vacancy> vacancySet, String javaF) throws IOException {
        Vacancy vacancy;
        String linkJob;
        String id;
        String EsqribishenJob;
        String nameJob;

        Document document = this.connectToPageAndGetDocument(this.url);
        System.out.println(document.title());

        // получаем элементы которые содеражат атрибут class = " postslisttopic"
        Elements elements = document.getElementsByClass("postslisttopic");
        for (Element element : elements) {

            String valueAtribute = element.select("a").attr("href");
            nameJob = element.child(0).text();

            if (nameJob.indexOf(javaF) != -1 && nameJob.indexOf("JavaScript") == -1 && nameJob.indexOf("Java Script") == -1) {
                vacancy = new Vacancy();
                System.out.println(valueAtribute);
                vacancy.setLinkJob(valueAtribute);
                System.out.println(nameJob);
                vacancy.setNameJob(nameJob);
                System.out.println(Integer.valueOf(valueAtribute.substring(26, 32)));
                vacancy.setId(Integer.valueOf(valueAtribute.substring(26, 32)));
                this.vacancySet.add(vacancy);
            }
        }
    }


}




