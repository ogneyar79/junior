package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private Pasport pasport;

    private List<Account> userAccounts;

    public User(String name, Pasport pasport, int value, String requisites) {
        this.name = name;
        this.pasport = pasport;
        this.userAccounts = userAccounts;
        this.userAccounts = new ArrayList<>();
        this.userAccounts.add(new Account(value, requisites));
    }


    public String getName() {
        return name;
    }

    public Pasport getPasport() {
        return pasport;
    }

    public List<Account> getUserAccounts() {
        return userAccounts;
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
        if (!pasport.equals(user.pasport)) {
            return false;
        }
        return userAccounts.equals(user.userAccounts);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + pasport.hashCode();
        return result;
    }
}
