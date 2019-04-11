package ru.job4j.collection;

public class User {
    private Integer id;

    private String name;

    private String citi;

    public User(Integer id, String name, String citi) {
        this.id = id;
        this.name = name;
        this.citi = citi;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCiti() {
        return citi;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCiti(String citi) {
        this.citi = citi;
    }
}
