package ru.job4j.collection.stackandqueue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    private SimpleQueue<Integer> simpleQueueContainer;



    @Before
    public void setUp() throws Exception {

        simpleQueueContainer = new SimpleQueue<Integer>();
        simpleQueueContainer.push(1);
        simpleQueueContainer.push(2);
        simpleQueueContainer.push(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(simpleQueueContainer.getSimpleArrayListContainerQuue().get(2), is(1));
        assertThat(simpleQueueContainer.getSimpleArrayListContainerQuue().get(0), is(3));
    }
    @Test
    public void whenDeletedElementByMethodPollOfLastElement() {
        int result;
        result = simpleQueueContainer.poll();
        assertThat(result, is(1));
    }

}