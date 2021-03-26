package ru.job4j.di;


import org.springframework.stereotype.Component;

@Component
public class StartUI {

    private Store store;
    private ConsoleInput input;

    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

    public void add(String value) {
        store.add(value);
    }

    public void addToConsole(String value) {
        input.addToList(value);
    }


    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
        for (String value : input.getList()) {
            System.out.println(value);
        }
    }
}
