package ru.job4j.collection;

import java.util.*;

public class UserP implements Comparable<UserP> {

    List<UserP> userP = new ArrayList<>();

    private int age;
    private String name;

    public UserP(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int compareTo(UserP o) {
        int result = this.getAge() - o.getAge();
        return result != 0 ? result : 0;
    }

    @Override
    public String toString() {
        return "UserP{"
                +
                "userP="
                +
                userP
                +
                ", age="
                + age
                +
                ", name='"
                + name
                + '\''
                +
                '}';
    }


    public static void main(String[] args) {
        List<UserP> usersP = new ArrayList<>();
        usersP.add(new UserP(54, "Maksim"));
        usersP.add(new UserP(51, "Robert"));
        usersP.add(new UserP(21, "Elena"));
        usersP.add(new UserP(18, "Bill"));
        Set<UserP> setForuserP = new TreeSet<>();
        setForuserP.addAll(usersP);
        System.out.println(setForuserP);
        SortUser forSortUsersP = new SortUser();

        setForuserP = forSortUsersP.sort1(usersP);
        System.out.println(setForuserP);

        usersP = forSortUsersP.sortNameLength(usersP);
        System.out.println(usersP);


    }
}
