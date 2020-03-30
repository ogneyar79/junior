package tictactoe.controllers;

import org.junit.Before;
import org.junit.Test;
import tictactoe.model.Field;
import tictactoe.model.Figure;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    Field field;

    // figure that make first step
    Figure firstFigure;

    CurrentMoveController controller;

    Figure figure;
    Figure figureO;

    @Before
    public void setUp() throws Exception {
        field = new Field(3);
        figure = Figure.X;
        figureO = Figure.O;
        firstFigure = figure;
        controller = new CurrentMoveController(field, firstFigure);
    }

    @Test
    public void countFigureRow() throws Exception {
        field.setFigure(new Point(0, 0), figure);
        field.setFigure(new Point(1, 0), figure);
        field.setFigure(new Point(2, 2), figure);
        field.setFigure(new Point(0, 1), figureO);
        field.setFigure(new Point(0, 2), figureO);
        int expected = 2;
        int count = controller.countFigureAtColumns(0);
        assertEquals(expected, count);
    }

    @Test
    public void getCurrentFigure() throws Exception {
        field.setFigure(new Point(0, 0), figure);
        field.setFigure(new Point(2, 2), figure);
        field.setFigure(new Point(0, 1), figureO);
        Figure actalFigure = controller.getCurrentFigure().get();
        Figure expected = Figure.O;
        assertEquals(expected, actalFigure);
    }

    @Test
    public void getFigureIfNoFigure() {
        Figure actalFigure = controller.getCurrentFigure().get();
        Figure expected = Figure.X;
        assertEquals(expected, actalFigure);
    }

}