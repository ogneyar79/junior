package ru.job4j.tracker;


import java.util.List;
import java.util.Scanner;

/**
 * interface IInput for package ru.job4j,tracker.
 *
 * @author Sirotkin.
 */
public interface IInput {


    /**
     * method for Iinput and ofput text in our package.
     *
     * @param question String
     * @return s String
     */
    String ask(String question);

    Scanner getScanner();

    int ask(String question, List<Integer> range);


}

