package ru.job4j.collection;

import java.util.Comparator;

public class UserAgeComporator implements Comparator<UserP> {
    @Override
    public int compare(UserP o1, UserP o2) {
        int result;
        if (o1.getAge() > o2.getAge()) {
            result = 1;
        } else if (o1.getAge() < o2.getAge()) {
            result = -1;
        } else {
            result = 0;
        }
        return result;
    }
}
