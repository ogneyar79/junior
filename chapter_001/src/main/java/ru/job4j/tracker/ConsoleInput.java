package ru.job4j.tracker;


import java.util.List;
import java.util.Scanner;

/**
 * класс ConsoleInput for realisation methods for enter of dates.
 *
 * @author Sirotkin.
 */
public class ConsoleInput implements IInput {

    /**
     * @ param value String [] answers.
     */
    private List<String> answers;

    /**
     *@ param value int position.
     * .Show i at arrays answers
     */

    /**
     * @ param field Scanner.
     * for realisation read entering text
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * @ param field String question.
     * for hand text to method
     */
    private String question;

    /**
     * method for input and ofput text.
     *
     * @param question String
     * @return String s
     */
    public String ask(String question) {
        String s;
        this.question = question;
        System.out.println(this.question);
        s = scanner.nextLine();

        return s;
    }

    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (Integer value : range) {
            if (value == key) {
                exist = true;
                break;
            }

        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }

    public ConsoleInput() {
    }

    /**
     * method for creaction ConsoleInput object.
     *
     * @param answers [] String
     */
    public ConsoleInput(List<String> answers) {

        this.answers = answers;
    }

    /**
     * method for get scanner.
     *
     * @return scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * method for get question.
     *
     * @return question
     */
    public String getQuestion() {
        return question;
    }

}

