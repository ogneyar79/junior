package ru.job4j.parserjob;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParserJobSqlRuTest {

    final String url = "https://www.sql.ru/forum/job/";
    Set<Vacancy> vacancySet = new HashSet<>();
    String javaFinder = "Java";
    ParserJobSqlRu parserJobSqlRu;

    String htmlPath = "C: \\projects\\sirotkinmaksim\\chapter_002\\src\\test\\java\\resources\\SqlJob\\tableTwo.html";
    String html = "tableTwo.html";
    String htmlPathOne = "C:\\projects\\sirotkinmaksim\\chapter_002\\src\\test\\java\\resources\\SqlJob\\tableOne.html";

    Function<String, Document> convektorAtDocumentFrom;

    @Before
    public void init() {

        this.parserJobSqlRu = new ParserJobSqlRu(url, vacancySet, javaFinder);
    }

    @Test
    public void getQuantityPages() {
        int result = parserJobSqlRu.getQuantityPages(this.url);
        System.out.println(result);
        assertThat(result, is(957));
    }

//    @Test
//    public void checkParsingOnePageFromSite() throws IOException {
//        System.out.println(vacancySet.isEmpty());
//        vacancySet.forEach(vacancy -> System.out.println(vacancy.toString()));
//        LocalDateTime localDateTime = LocalDateTime.now().minusDays(3);
//        System.out.println(localDateTime.toString());
//        parserJobSqlRu.setMaxDate(localDateTime);
//        parserJobSqlRu.parseVacancies(Jsoup.connect(url).get(), );
//        vacancySet.forEach(vacancy -> System.out.println(vacancy.toString()));
    //     assertThat(parserJobSqlRu.isAddNewElement(), is(true));
//    }
//

    @Test
    public void parseAllPagesAndReturnSetWithVacancy() throws IOException {
        System.out.println(vacancySet.isEmpty());
        vacancySet.forEach(vacancy -> System.out.println(vacancy.toString()));
        parserJobSqlRu.setMaxDate(LocalDateTime.now().minusDays(10));

        convektorAtDocumentFrom = new Function<String, Document>() {
            @Override
            public Document apply(String s) {
                Document document = null;
                try {
                    document = Jsoup.connect(s).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return document;
            }
        };

        vacancySet = parserJobSqlRu.parseThroughPagesToSet(convektorAtDocumentFrom);
        vacancySet.forEach(vacancy -> System.out.println(vacancy.toString()));
        assertThat(parserJobSqlRu.isAddNewElement(), is(true));
    }

    @Test
    public void parseHtmlFromFileReturnSetWithVacancy() throws IOException {
        System.out.println(vacancySet.isEmpty());
        vacancySet.forEach(vacancy -> System.out.println(vacancy.toString()));
        parserJobSqlRu.setMaxDate(LocalDateTime.of(2002, 01, 01, 00, 01, 01));

        vacancySet = parserJobSqlRu.parseThroughPagesToSet(new File(htmlPathOne));
        vacancySet.forEach(vacancy -> System.out.println(vacancy.toString()));
        assertThat(parserJobSqlRu.isAddNewElement(), is(true));
    }


//    @Test
//    public void checkParseFromDocument() throws IOException {
//        Document document = parserJobSqlRu.connectToPageAndGetDocument(url);
//        System.out.println(document.title());

//    }


//    @Test
//    public void ChangeBolleanIfThrueThenFalse() {
//        parserJobSqlRu.changeAnewElIfOneementWasAdded(true);
//        parserJobSqlRu.changeAnewElIfOneementWasAdded(false);
//        System.out.println(parserJobSqlRu.isAddNewElement());
//        assertThat(parserJobSqlRu.isAddNewElement(), is(true));
//    }

//    @Test
//    public void turnIntoLocalDayTimeFromDateStringOfBaseData() {
//        String date = "вчера, 13:06";
//        String time = date.substring(date.indexOf(",") + 2);
//        System.out.println(time);
//
//        int hour = new Integer(time.split(":")[0].trim());
//        System.out.println(hour);
//        int min = new Integer(time.split(":")[1].trim());
//        System.out.println(min);
//        date = date.substring(0, date.indexOf(",")).trim();
//        LocalDate localDate = LocalDate.now();
//        System.out.println("Local Date today" + localDate);
//        System.out.println(date);
//        if (date.contains("вчера")) {
//            localDate = localDate.minusDays(1);
//            System.out.println(" Yesterday - one day " + localDate.minusDays(1));
//        } else if (!date.contains("сегодня") && !date.contains("вчера")) {   // if date String figure like "12 feb 2019"
//            int year = new Integer("20" + date.substring(date.length() - 2)); // get from String date and set year int
//            System.out.println(year);
//            String strMonth = date.substring(2, 6).trim();
//            System.out.println(strMonth);
//            int day = new Integer(date.substring(0, 2).trim());
//            System.out.println(day);
//            localDate = LocalDate.of(year, parserJobSqlRu.getMonth(strMonth), day);  // set localDate via getMonth from String get into class Month
//            System.out.println(parserJobSqlRu.getMonth(strMonth));
//        }
//        System.out.println("Local Day For turn Into" + localDate);
//        LocalTime localTime = LocalTime.of(hour, min);
//        System.out.println(localTime);
//        LocalDateTime.of(localDate, localTime);
//        System.out.println(LocalDateTime.of(localDate, localTime));
//   }
}