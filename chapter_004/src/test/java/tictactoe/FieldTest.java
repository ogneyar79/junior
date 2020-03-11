package tictactoe;

import org.junit.Test;
import tictactoe.model.exeption.InvalidPointException;
import tictactoe.model.exeption.OccupiedException;
import tictactoe.model.Field;
import tictactoe.model.Figure;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getFieldSize() throws Exception {
        final Field field = new Field();
        assertEquals(3, field.getFieldSize());
    }

    @Test
    public void getFigureWhenFigureNoSet() throws InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure actualFigure = field.getFigure(inputPoint);
        assertEquals(null, actualFigure);
    }

    @Test
    public void whenPointIncorecct() {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenPointYmoreThenSize() {
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getFieldSize() + 2);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;
        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);
        assertEquals(inputFigure, actualFigure);
    }


}