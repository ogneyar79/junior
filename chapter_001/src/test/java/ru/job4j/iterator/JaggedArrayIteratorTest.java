package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JaggedArrayIteratorTest {

    private ConcreteArray itSecond;
    IIterator el;

    @Before
    public void setUp() {
        itSecond = new ConcreteArray(new int[][]{{1}, {3, 4}, {7}});
        el = itSecond.getIterator();
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        System.out.println(el.getInnerIndex());
        assertThat(el.next(), is(1));
        System.out.println(el.getInnerIndex());
        assertThat(el.next(), is(3));
        System.out.println(el.getInnerIndex());
        assertThat(el.next(), is(4));
        assertThat(el.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(el.hasNext(), is(true));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(1));
        assertThat(el.next(), is(3));
        assertThat(el.next(), is(4));
        assertThat(el.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(1));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(3));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(4));
        assertThat(el.hasNext(), is(true));
        assertThat(el.next(), is(7));
        assertThat(el.hasNext(), is(false));
    }
}
