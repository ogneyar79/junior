package ru.job4j.collection.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkedContainerTest {


    LinkedContainer<Integer> linkedContainer;

    @Before
    public void beforeTest() {
        linkedContainer = new LinkedContainer<Integer>();
        linkedContainer.add(1);
        linkedContainer.add(2);
        linkedContainer.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(linkedContainer.get(2), is(1));
        assertThat(linkedContainer.get(1), is(2));
    }

    @Test
    public void whenGetFirstElement() {
        assertThat(linkedContainer.getFirst().getDate(), is(3));

    }

}