package ru.job4j.parserjob;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class ParserJobSqlRu {

    String url;

    File htmlFile;

    /**
     * Array conteiner for vacansies.
     */
    ArrayList<Vacancy> vacancies = new ArrayList<>();


    public ParserJobSqlRu(String url, File htmlFile) {
        this.url = url;
        this.htmlFile = htmlFile;
    }

    public ParserJobSqlRu(String url) {
        this.url = url;
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
     */
    public void parseVacancies(String url) throws IOException {
        Vacancy vacancy;
        Document document = this.connectToPageAndGetDocument(this.url);
        System.out.println(document.title());

        // получаем элементы которые содеражат атрибут class = " postslisttopic"
        Elements elements = document.getElementsByClass("postslisttopic");

        for (Element element : elements) {
            String valueAtribute = element.select("a").attr("href");
            System.out.println(" Work with text");
            System.out.println(element.child(0).text());
            System.out.println(valueAtribute);
            String nameJob;
            String linkJob;
            String date;
            String EsqribishenJob;
            this.vacancies.add();
        }
    }

    public ArrayList<Vacancy> getVacancies() {
        return vacancies;
    }

    public static void main(String... arg) throws IOException {

        ParserJobSqlRu parserJobSqlRu = new ParserJobSqlRu("https://www.sql.ru/forum/job/");
        Document document = parserJobSqlRu.connectToPageAndGetDocument(parserJobSqlRu.url);
        System.out.println(document.title());
        // получаем элементы которые содеражат атрибут class = " postslisttopic"
        Elements elements = document.getElementsByClass("postslisttopic");

        for (Element element : elements) {

            String valueAtribute = element.select("a").attr("href");
            System.out.println(" Work with text");
            System.out.println(element.child(0).text());
            System.out.println(valueAtribute);
            String nameJob;
            String linkJob;
            String date;
            String EsqribishenJob;


        }
    }
}




