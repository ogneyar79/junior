package ru.job4j.parserjob;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainParserJob {


    public static void main(String... arg) throws IOException {
        Set<Vacancy> vacancySet = new LinkedHashSet<>();
        String lookingAt = "Java";
        ParserJobSqlRu parserJobSqlRu = new ParserJobSqlRu("https://www.sql.ru/forum/job/", vacancySet, lookingAt);
        Document document = parserJobSqlRu.connectToPageAndGetDocument(parserJobSqlRu.url);
        System.out.println(document.title());
        parserJobSqlRu.parseVacancies(parserJobSqlRu.getUrl(), parserJobSqlRu.getVacancySet(), lookingAt);

        // получаем элементы которые содеражат атрибут class = " postslisttopic"
        //Elements elements = document.getElementsByClass("postslisttopic");
//        String nameJob;
//        String id;
//        String javaF = "Java";
//        String linkJob;
//        String date;
//        String EsqribishenJob;
//
//        for (Element element : elements) {
//
//            String valueAtribute = element.select("a").attr("href");
//        System.out.println(" Work with text");
//        System.out.println(element.child(0).text());
//        System.out.println(valueAtribute);
//            nameJob = element.child(0).text();
        //       System.out.println(nameJob.indexOf(javaF));
//
//            if (nameJob.indexOf(javaF) != -1 && nameJob.indexOf("JavaScript") == -1) {
//                Vacancy vacancy = new Vacancy();
//                System.out.println(valueAtribute);
//                vacancy.setLinkJob(valueAtribute);
//                System.out.println(nameJob);
//                vacancy.setNameJob(nameJob);
//                System.out.println(valueAtribute.substring(26, 32));
//                System.out.println(Integer.valueOf(valueAtribute.substring(26, 32)));
//                vacancy.setId(Integer.valueOf(valueAtribute.substring(26, 32)));
//            }
//        }
//    }
//
    }
}
