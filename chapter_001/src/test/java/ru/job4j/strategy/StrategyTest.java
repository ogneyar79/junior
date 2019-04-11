package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;


/**
 * We test different method for testing classes strategy.
 *
 * @author Sirotkin
 * @since 24.09.2017
 */
public class StrategyTest {
    @Test
    public void whenDrawTriangle() {

        Paint first = new Paint();


        first.setShape(new Triangle());
        first.draw();

        String expected = String.format("+    %n++   %n+ +  %n+  + %n+++++%n");
        assertThat(first.getShape().pic(), is(expected));

    }

    @Test
    public void whenDrawSquare() {

        Paint second = new Paint();


        second.setShape(new Square());
        second.draw();

        String expected = String.format("+++++%n+   +%n+++++%n+   +%n+++++");
        assertThat(second.getShape().pic(), is(expected));

    }

}





