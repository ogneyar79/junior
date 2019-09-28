package ru.job4j.parserjob;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegresJobParserSql {

    public String findThatByRegres(String focusGroup) {
        String result = "";

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(focusGroup);

        while (matcher.find()) {
            result = matcher.group();
        }
        return result;

    }

    public static void main(String... args) {

        String focusGroup = "https://www.sql.ru/forum/677304/bez-opyta-raboty-stoit-li-poluchat-sertifikat-java";
        RegresJobParserSql regresJobParserSql = new RegresJobParserSql();
        String result = regresJobParserSql.findThatByRegres(focusGroup);
        System.out.println(result);
    }

}
