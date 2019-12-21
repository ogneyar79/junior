package ru.job4j.io.serverfirst;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DialogTest {
    WordBase wordBase = new WordBase();

    Dialog dialog = new Dialog(wordBase);

    @Test
    public void checkInisialization() {
        System.out.println(dialog.getWordBase().getAnswersByPattern().size());
        System.out.println(dialog.getWordBase().getCommonPhrase().length);
        assertThat(dialog.getWordBase().getAnswersByPattern().size(), is(9));
        assertThat(dialog.getWordBase().getCommonPhrase().length, is(10));
    }


}