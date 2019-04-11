package ru.job4j.collection.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;



public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(2), is(1));
    }
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeletedFirstElement() {
        list.delete();
        assertThat(list.get(0), is(2));
        list.delete();
        assertThat(list.get(0), is(1));
    }
    @Test
    public void whenDeletedElement() {
       int result = list.delete(2);
        assertThat(result, is(1));
    }
}