package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MatrixIteratorTest {

    private ConcreteArray itSecond;
    IIterator el;

    @Before
    public void setUp() {
        itSecond = new ConcreteArray(new int[][]{{1, 2, 3}, {4, 5, 6}});
        el = itSecond.getIterator();
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(1));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(2));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(3));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(4));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(5));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(6));
        assertThat(el.hasNext(), is(false));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(el.next(), is(1));
        assertThat(el.next(), is(2));
        assertThat(el.next(), is(3));
        assertThat(el.next(), is(4));
        assertThat(el.next(), is(5));
        assertThat(el.next(), is(6));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(el.hasNext(), is(true));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(1));
        assertThat(el.next(), is(2));
        assertThat(el.next(), is(3));
        assertThat(el.next(), is(4));
        assertThat(el.next(), is(5));
        assertThat(el.next(), is(6));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        itSecond = new ConcreteArray(new int[][]{});
        el = itSecond.getIterator();
        el.next();
    }
}