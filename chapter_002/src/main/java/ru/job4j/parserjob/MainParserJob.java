package ru.job4j.parserjob;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

//public class MainParserJob {
//
//    public static void parsDateS(String date) {
//        String time = date.substring(date.indexOf(",") + 2);
//        int hour = new Integer(time.split(":")[0].trim());
//        int min = new Integer(time.split(":")[1].trim());
//        LocalTime localTime = LocalTime.of(hour, min);
//        date = date.substring(0, date.indexOf(",")).trim();
//        LocalDate localDate = LocalDate.now();
//        System.out.println(time);
//        System.out.println(date);
//        System.out.println(date.length());
//        LinkedHashSet<Vacancy> vacancies = new LinkedHashSet<>();
//
//        Iterator<Vacancy> vacancyIterator = vacancies.iterator();
//
//        if (date.contains("вчера")) {
//            System.out.println(date.contains("вчера"));
//            localDate.minusDays(1);
//        } else if (!date.contains("сегодня") && !date.contains("вчера")) {
//            int year = new Integer("20" + date.substring(date.length() - 2));
//            System.out.println(year);
//            String strMonth = date.substring(2, 6).trim();
//            int day = new Integer(date.substring(0, 2).trim());
//            localDate = LocalDate.of(year, Month.SEPTEMBER, day);
//            System.out.println(localDate);
//        }
//    }
//
//    public static void main(String... arg) throws IOException {
//        String date = "15 авг 19, 12:4";
//        String dateS = "сегодня, 18:28";
//        parsDateS(date);
//        parsDateS(dateS);
//        Set<Vacancy> vacancySet = new LinkedHashSet<>();
//        String lookingAt = "Java";
//        ParserJobSqlRu parserJobSqlRu = new ParserJobSqlRu("https://www.sql.ru/forum/job/", vacancySet, lookingAt);
//        Document document = parserJobSqlRu.connectToPageAndGetDocument(parserJobSqlRu.url);
//        System.out.println(document.title());
//        parserJobSqlRu.parseVacancies();
//
//    }
//}
