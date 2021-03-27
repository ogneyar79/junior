package ru.job4j.di;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class StartUI {


    @Autowired
    private Store store;

    @Autowired
    private ConsoleInput input;

//    public StartUI(Store store, ConsoleInput input) {
//        this.store = store;
//        this.input = input;
//    }

    public void add(String value) {
        store.add(value);
    }

    public void addToConsole() {
        input.addToList(input.askStr());
    }


    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
        for (String value : input.getList()) {
            int i = 0;
            System.out.println(" We are reading the text :" + i++);
            System.out.println(value);
        }
    }
}
