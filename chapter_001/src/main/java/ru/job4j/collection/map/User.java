package ru.job4j.collection.map;

import java.util.*;

public class User {
    String name;
    int children;
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!name.equals(user.name)) {
            return false;
        }
        return birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthday.hashCode();
        return result;
    }

    public static void main(String[] args) {
        Calendar birthday = new GregorianCalendar(21, 02, 1990);
        User userOne = new User("Ivan", 2, birthday);
        User userTwo = new User("Ivan", 2, birthday);

        Map<User, Object> usrs = new HashMap<>();
        usrs.put(userOne, new Object());
        usrs.put(userTwo, new Object());
        System.out.println(usrs);

        System.out.println(userOne.hashCode());
        System.out.println(userTwo.hashCode());

        System.out.println(userOne.equals(userTwo));
    }


}
