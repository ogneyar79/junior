package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IteratorArrayMInTest {


    IteratorArrayMIn it;

    @Before
    public void setUp() throws Exception {
        it = new IteratorArrayMIn(new int[]{0, 1, 2, 3, 4});

    }

    @Test
    public void testsThatNextMethodReternValueFromArrayConsistenntly() {
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        System.out.println(it.getIndex()); //0
        assertThat(it.next(), is(0));
        System.out.println(it.getIndex()); //1
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        System.out.println(it.getIndex()); //2
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        System.out.println(it.getIndex()); //3
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        System.out.println(it.getIndex()); //4
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        System.out.println(it.getIndex()); //5
        assertThat(it.hasNext(), is(false));
    }
}