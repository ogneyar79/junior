package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConsoleInput.class);
        context.register(Store.class);
        context.register(StartUI.class);
        context.refresh();
      //  BeanConfig.class
        context.scan("ru.job4j.di");
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
        ui.addToConsole("!!!!!");

        StartUI another = context.getBean(StartUI.class);
        another.print();
    }

}
