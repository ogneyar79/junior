package ru.job4j.parserjob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.parserjob.workjsoup.ConectionJsoupGetingDocument;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Set;

/**
 * Class for direct parsing site.
 *
 * @version 2.1
 * @autor Sirotkin Maksim
 * @since 29.08.19
 */
public class ParserJobSqlRu {

    ConectionJsoupGetingDocument myJsoupObject;

    /**
     * field link for conection with site.
     */
    String url;

    /**
     * field copy of one page site at HTML format.
     */
    String fileName;

    /**
     * Logger for info output.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Loaded properties with connection options.
     */
    private Configjob configjob = new Configjob();

    /**
     * Beginning Date of the search.
     * It's max(date) from Base or first January this year.
     */
    private LocalDateTime maxDate;

    RegresJobParserSql regreObject = new RegresJobParserSql();

    /**
     * field informing even if one element was Added.
     */
    private boolean addNewElement = false;

    /**
     * Procedure seting  boolean addNewElement even if one element was Added..
     *
     * @param addNewElement
     */
    private void changeAnewElIfOneementWasAdded(boolean addNewElement) {
        if (addNewElement == true) {
            this.addNewElement = true;
            System.out.println("has  been added element at Set ");
        }
    }

    public boolean isAddNewElement() {
        return addNewElement;
    }

    /**
     * conteiner for vacansies.
     */
    Set<Vacancy> vacancySet;

    /**
     * Vacancy is being looked for.
     */
    String javaFinder;    //  In our case we going to look for vacancy with "Java"

    Set<Vacancy> getVacancySet() {
        return vacancySet;
    }

    public String getJavaFinder() {
        return javaFinder;
    }

    /**
     * Constructor of new object
     *
     * @param url
     * @param vacancySet
     * @param javaFinder
     * @see ParserJobSqlRu(String, Set<Vacancy></>, String)
     */
    public ParserJobSqlRu(String url, Set<Vacancy> vacancySet, String javaFinder) {
        this.url = url;
        this.vacancySet = vacancySet;
        this.javaFinder = javaFinder;
    }


    /**
     * Function getting field value {@link ParserJobSqlRu#url}
     *
     * @return url site for parsing.
     */
    public String getUrl() {
        return url;
    }

    public void setMaxDate(LocalDateTime maxDate) {
        this.maxDate = maxDate;
    }

    /**
     * Collects data from the pages of the site.
     * In each cycle, adds the following number to the address, starting with one.
     *
     * @return SetVacancy<></>
     * @throws IOException If it is impossible to connect to the site.
     */
    public Set<Vacancy> parseThroughPagesToSet(ConectionJsoupGetingDocument myJsoupObject) throws IOException {

        this.vacancySet.clear();
        System.out.println("Let's continue");
        String url;

        int pages = getQuantityPages(this.url);
        System.out.println("Let's Start" + " Pages int" + pages);
        LOGGER.info(String.format("Total pages to parse: %s", pages));

        for (int page = 1; page <= pages; page++) {
            url = String.format("%s/%s", this.url, page);
            System.out.println("Let's continue");
            System.out.println(url);
            LOGGER.info(String.format("Parsing page %s of %s pages.", page, pages));
            System.out.println(page);
            Document document = myJsoupObject.conectHtmlRepresentationAndGetDocument(url);
            this.parseVacancies(document);
        }
        return this.vacancySet;
    }

    /**
     * Method searches for the number of all pages in the section.
     * Only for sql.ru
     *
     * @param url of page.
     * @return number of pages.
     * @throws IOException if can't get document.
     */
    public int getQuantityPages(String url) {
        Document doc = null;
        System.out.println("Method Pages");
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements sortOptions = doc.getElementsContainingOwnText("Страницы:");          // container for all pages XML
        String pages = sortOptions.text().trim(); // All pages  at one, the Method text iterate and add(append) each element To String Builder
        String[] p = pages.split("\\s");
        System.out.println(Integer.parseInt(p[p.length - 1]) + " Quantity of Pages");
        return Integer.parseInt(p[p.length - 1]);
    }

    /**
     * Method(Procedure) for parsing vacancies  from site(one page).
     * add found our vacancy to our container.
     *
     * @param document
     */
    public void parseVacancies(Document document) throws IOException {
        Vacancy vacancy;
        String nameJob;
        //         получаем элементы которые содеражат атрибут class = " postslisttopic" and work with these items and his children
        Elements elements = document.getElementsByClass("postslisttopic");
        for (Element element : elements) {
            nameJob = element.child(0).text();
            // if find that looking for make manipulation like geting Date and another, and create object Vacancy and add to BaaseData
            if (nameJob.indexOf(this.javaFinder) != -1 && nameJob.indexOf("JavaScript") == -1 && nameJob.indexOf("Java Script") == -1) {

                String linkJob = element.select("a").attr("href"); // variable for  url about vacancy
                System.out.println(linkJob);
                int id = Integer.parseInt(regreObject.findThatByRegres(linkJob));
                String date = element.parent().child(5).text(); // String Date of  publication of vacancy, getting from site
                System.out.printf("String Date of  publication of vacancy, getting from site is %s%n ", date);
                LocalDateTime vacDate = this.parsDate(date); // variable date and time together, setTing by parseDate with  String Date
                if (vacDate.isAfter(this.maxDate)) {
                    System.out.printf("The Dates for add to Vacancy to BaseDate including are id, nameJob, linkJob and Date:" +
                            " %d%n,%s%n,%s%n,%s%n", id, nameJob, linkJob, vacDate.toString());

                    vacancy = new Vacancy(id, nameJob, linkJob, vacDate);

                    this.changeAnewElIfOneementWasAdded(this.vacancySet.add(vacancy)); // add new element and report if one ore more Elements was added
                }
            }
        }
    }

    /**
     * Return local datetime.
     *
     * @param date url representation of the datetime.
     * @return local datetime.
     */
    private LocalDateTime parsDate(String date) {
        String time = date.substring(date.indexOf(",") + 2);  // cat the date until hour and month
        int hour = new Integer(time.split(":")[0].trim()); // make hours in int
        int min = new Integer(time.split(":")[1].trim());
        LocalTime localTime = LocalTime.of(hour, min);     // set  LocalTime
        // leave only date without hours, It's might be at words like "today" else figure like "12 feb 2019"
        date = date.substring(0, date.indexOf(",")).trim();
        LocalDate localDate = LocalDate.now(); // get and set LocalDate

        if (date.contains("вчера")) {
            localDate = localDate.minusDays(1);
        } else if (!date.contains("сегодня") && !date.contains("вчера")) {   // if date String figure like "12 feb 2019"
            int year = new Integer("20" + date.substring(date.length() - 2)); // get from String date and set year int
            String strMonth = date.substring(2, 6).trim();   // get String month like "feb"
            int day = new Integer(date.substring(0, 2).trim());  // get String day and set int day
            localDate = LocalDate.of(year, getMonth(strMonth), day);  // set localDate via getMonth from String get into class Month
        }
        return LocalDateTime.of(localDate, localTime);
    }

    /**
     * Return month.
     *
     * @param strMonth url representation of the month.
     * @return month.
     */
    private Month getMonth(String strMonth) {
        Month result = Month.JANUARY;
        if ("фев".equals(strMonth)) {
            result = Month.FEBRUARY;
        } else if ("мар".equals(strMonth)) {
            result = Month.MARCH;
        } else if ("апр".equals(strMonth)) {
            result = Month.APRIL;
        } else if ("май".equals(strMonth)) {
            result = Month.MAY;
        } else if ("июн".equals(strMonth)) {
            result = Month.JUNE;
        } else if ("июл".equals(strMonth)) {
            result = Month.JULY;
        } else if ("авг".equals(strMonth)) {
            result = Month.AUGUST;
        } else if ("сен".equals(strMonth)) {
            result = Month.SEPTEMBER;
        } else if ("окт".equals(strMonth)) {
            result = Month.OCTOBER;
        } else if ("ноя".equals(strMonth)) {
            result = Month.NOVEMBER;
        } else if ("дек".equals(strMonth)) {
            result = Month.DECEMBER;
        }
        return result;
    }
}

