package tictactoe.controllers;

import org.junit.Before;
import org.junit.Test;
import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.Game;
import tictactoe.model.Player;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class MoveControllerTest {

    Field field;
    Figure figureX;
    Figure figureO;
    Figure firstFigure;

    CurrentMoveController currentMoveController;
    WinnerController winnerController;
    MoveController controllerTest;


    @Before
    public void setUp() throws Exception {
        figureX = Figure.X;
        figureO = Figure.O;
        field = new Field(3);
        firstFigure = figureX;

        currentMoveController = new CurrentMoveController(field, firstFigure);
        winnerController = new WinnerController();
        controllerTest = new MoveController(currentMoveController, winnerController);
    }

    @Test
    public void applyFigure() throws Exception {
        Point point = new Point(0, 0);
        controllerTest.applyFigure(field, point, figureX);
        Figure actalFigure = field.getFigure(point);
        Figure expected = Figure.X;
        assertEquals(expected, actalFigure);
    }

    @Test
    public void controlMoveWhenWeHaveWinner() throws Exception {
        controllerTest.applyFigure(field, new Point(0, 0), figureX);
        controllerTest.applyFigure(field, new Point(0, 1), figureO);
        controllerTest.applyFigure(field, new Point(0, 2), figureX);
        controllerTest.applyFigure(field, new Point(1, 1), figureO);
        controllerTest.applyFigure(field, new Point(1, 2), figureX);
        controllerTest.applyFigure(field, new Point(2, 1), figureO);

        boolean result = controllerTest.controlMove(field);
        System.out.println(result);
        boolean expected = false;
        assertEquals(expected, result);
    }

    @Test
    public void moveFigure() throws Exception {
    }

}