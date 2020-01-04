package ru.job4j.io.serverfirst;

import java.util.ArrayList;
import java.util.Random;

public class Dialog {

    private boolean opener;

    private final Random random;

    private final String word = " ";

    WordBase wordBase;

    private ArrayList<String> specialWords;

    // private ArrayList<String> dialogWords;


    Dialog(WordBase base) {
        this.specialWords = new ArrayList<>();
        this.specialWords.add("Stop");
        this.specialWords.add(" Wait");
        this.random = new Random();
        this.wordBase = base;
    }

    /**
     * procedure to close dialog.
     */
    public void closeDialog() {
        this.opener = false;
    }

    /**
     * function returning boolean false if  opened or true in another way.
     *
     * @return this.opener()
     */
    public boolean isClosed() {
        return !this.opener;
    }

    public String getRandomString() {
        String[] frases = this.wordBase.getCommonPhrase();
        String frase = frases[this.random.nextInt(frases.length - 1)];
        return frase;
    }


    public WordBase getWordBase() {
        return wordBase;
    }

    public ArrayList<String> getSpecialWords() {
        return specialWords;
    }
}


