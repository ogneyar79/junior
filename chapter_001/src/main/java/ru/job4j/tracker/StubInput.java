package ru.job4j.tracker;


import java.util.List;
import java.util.Scanner;

/**
 * класс IInput for enter text.
 *
 * @author Sirotkin.
 */
public class StubInput implements IInput {

    /**
     * @ param value String [] answers.
     */
    private List<String> answers;

    public List<String> getAnswers() {
        return answers;
    }

    /**
     * @ param value position int.
     */
    private int position = 0;

    /**
     * @ param field String question.
     * for hand text to method
     */
    private String question;

    /**
     * method for creaction StubInput object.
     *
     * @param answers [] String
     */
    public StubInput(List<String> answers) {

        this.answers = answers;
    }

    /**
     * @ param field Scanner.
     * for realisation read entering text
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * method for input and ofput text.
     *
     * @param question String
     * @return String s
     */
    public String ask(String question) {

        this.question = question;

        System.out.println(this.question);

        return answers.get(position++);
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

    /**
     * method for get scanner.
     *
     * @return scanner
     */
    public Scanner getScanner() {
        return scanner;
    }
}