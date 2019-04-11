package ru.job4j.multithereading.threads.userstore;

public class User {

    private String name;

    private int id;
    private int amount;

    public User(String name, int id, int amount) {
        this.name = name;
        this.id = id;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    boolean checkSufisientSum(int amount) {
        boolean result = false;
        return this.amount >= amount ? true : false;
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

        if (id != user.id) {
            return false;
        }
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id;
        return result;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
