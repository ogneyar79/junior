package ru.job4j.parserjob;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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
        Document document = parserJobSqlRu.connectToPageAndGetDocument(parserJobSqlRu.getUrl());

    }
}
