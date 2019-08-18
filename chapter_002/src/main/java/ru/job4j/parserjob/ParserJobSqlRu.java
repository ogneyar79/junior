package ru.job4j.parserjob;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


public class ParserJobSqlRu {

    String url;

    File htmlFile;

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

    public static void main(String... arg) throws IOException {

        ParserJobSqlRu parserJobSqlRu = new ParserJobSqlRu("https://www.sql.ru/forum/job/");
        Document document = parserJobSqlRu.connectToPageAndGetDocument(parserJobSqlRu.url);
        System.out.println(document.title());
        // получаем элементы которые содеражат атрибут class = " postslisttopic"
        Elements elements = document.getElementsByClass("postslisttopic");

        for (Element element : elements) {
            String valueAtribute = element.attr("href");
            System.out.println(valueAtribute);
        }
    }


}

