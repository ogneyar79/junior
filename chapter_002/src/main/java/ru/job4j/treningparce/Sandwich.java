package ru.job4j.treningparce;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String title;

    private List<Ingridient> ingridients;

    public Sandwich() {
        ingridients = new ArrayList<Ingridient>();

    }
    public void addIngridient(Ingridient ingridient) {
        ingridients.add(ingridient);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Ingridient> getIngridients() {
        return ingridients;
    }
}
