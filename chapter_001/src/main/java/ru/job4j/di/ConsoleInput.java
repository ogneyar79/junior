package ru.job4j.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Scope("prototype")
@Component
public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public String askStr() {
        System.out.println("Write The Text");
        return scanner.nextLine();
    }


    private List<String> list = new ArrayList<>();

    public void addToList(String value) {
        list.add(value);
    }

    public List<String> getList() {
        return list;
    }
}
