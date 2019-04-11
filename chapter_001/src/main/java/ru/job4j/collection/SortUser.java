package ru.job4j.collection;

import java.util.*;

public class SortUser {
    List<UserP> users;

    public Set<UserP> sort1(List<UserP> userP) {
        Set<UserP> setUser = new TreeSet<>();
        for (UserP o : userP) {
            setUser.add(o);

        }
        return setUser;
    }

    public List<UserP> sortNameLength(List<UserP> users) {

        users.sort(new Comparator<UserP>() {
            @Override
            public int compare(UserP o1, UserP o2) {
                Integer u1 = new Integer(o1.getName().length());
                Integer u2 = new Integer(o2.getName().length());
                return u1 - u2;
            }

        });

        return users;
    }

    public List<UserP> sortByAllFields(List<UserP> users) {
        Comparator<UserP> people = new UserNameComporator().thenComparing(new UserAgeComporator());
        users.sort(people);
        return users;
    }
}
