package ru.job4j.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorArrayTest {

    @Test
    public void whenCountArrayTwoTwo() {

        ConcreteArray it = new ConcreteArray(new int[][]{{1, 2}, {3, 4}});
        IIterator el = it.getIterator();
        el.valuesCountArray(it.value);
        int result;
        result = el.valuesCountArray(it.value);

        assertThat(result, is(4));
    }

    @Test
    public void whenHasNextChekThatLastElementNoNext() {

        ConcreteArray itSecond = new ConcreteArray(new int[][]{{1, 2}, {3}});
        IIterator elSecond = itSecond.getIterator();
        elSecond.setCurrent(2);

        elSecond.hasNext();
        boolean resultSecond = elSecond.hasNext();
        assertThat(resultSecond, is(true));
    }

    @Test
    public void whenNextThatTwoCalLingMethodReternSecondElementArray() {
        ConcreteArray itThird = new ConcreteArray(new int[][]{{1, 2}, {3}});
        IIterator elThird = itThird.getIterator();
        int resultThird = elThird.next();
        resultThird = elThird.next();
        assertThat(resultThird, is(2));
    }
}