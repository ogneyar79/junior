package ru.job4j.tasksortdeparament;


import java.util.Comparator;

public class ComporatorLengtch implements Comparator<String> {

    public int compare(String o1, String o2) {
        int res;
        if (o1.length() > o2.length()) {
            res = 1;
        } else if (o1.length() == o2.length()) {
            res = 0;
        } else {
            res = -1;
        }

        return res;
    }


}

