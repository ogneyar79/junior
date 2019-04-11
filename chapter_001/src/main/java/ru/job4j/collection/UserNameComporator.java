package ru.job4j.collection;

import java.util.Comparator;

public class UserNameComporator implements Comparator<UserP> {


    @Override
    public int compare(UserP o1, UserP o2) {
        return o1.getName().compareTo(o2.getName());
    }


}
