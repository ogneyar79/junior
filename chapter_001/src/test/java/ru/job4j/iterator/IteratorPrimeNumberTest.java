package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IteratorPrimeNumberTest {

    private Iterator<Integer> it;


    @Before
    public void setUp() {
        it = new IteratorPrimeNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 3571});
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3571));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(3571));
    }

    @Test
    public void shouldReturnFalseCauseThereIsNoAnyPrimeNumber() {
        it = new IteratorPrimeNumber(new int[]{4, 6});
        assertThat("should return false, cause there is no any prime number", it.hasNext(), is(false));
    }

    @Test
    public void shouldReturnFalseCauseThereIsNoAnyPrimeNumberSecond() {
        IteratorPrimeNumber itSecond = new IteratorPrimeNumber(new int[]{4, 6});
        assertThat("should return false, cause there is no any prime number", itSecond.hasNextSecond(), is(false));
    }


    @Test
    public void checjNextWithInerMetodForRealisation() {


        IteratorPrimeNumber itSecond = new IteratorPrimeNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 3571});
        assertThat(itSecond.hasNextSecond(), is(true));
        assertThat(itSecond.next(), is(2));
        assertThat(itSecond.hasNextSecond(), is(true));
        assertThat(itSecond.next(), is(3));
        assertThat(itSecond.hasNextSecond(), is(true));
        assertThat(itSecond.next(), is(5));
        assertThat(itSecond.hasNextSecond(), is(true));
        assertThat(itSecond.next(), is(7));
        assertThat(itSecond.hasNextSecond(), is(true));
        assertThat(itSecond.next(), is(3571));
        assertThat(itSecond.hasNextSecond(), is(false));
        itSecond.next();
    }

    @Test
    public void checkbooleanPrimeNumberIs() {
        IteratorPrimeNumber itSecond = new IteratorPrimeNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 3571});
        assertThat(itSecond.checkPrimeNumberIs(2), is(true));
        assertThat(itSecond.checkPrimeNumberIs(5), is(true));
        assertThat(itSecond.checkPrimeNumberIs(9), is(false));
    }
}