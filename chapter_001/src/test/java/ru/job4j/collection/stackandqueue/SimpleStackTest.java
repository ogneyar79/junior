package ru.job4j.collection.stackandqueue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    SimpleStack<Integer> simpleStackContainer;

    @Before
    public void setUp() throws Exception {

        simpleStackContainer = new SimpleStack<Integer>();

        simpleStackContainer.push(1);
        simpleStackContainer.push(2);
        simpleStackContainer.push(3);
    }
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(simpleStackContainer.getOurStackContainer().get(2), is(1));
        assertThat(simpleStackContainer.getOurStackContainer().get(0), is(3));
    }
    @Test
    public void whenDeletedElementByMethodPollThatWeAddedLast() {
        int result;
        result = simpleStackContainer.poll();
        assertThat(result, is(3));
    }


}