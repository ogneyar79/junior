package tictactoe.controllers;

import org.junit.Test;
import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;


import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void changeFigure() throws Exception {
        WinnerController winnerControl = new WinnerController();
        Figure figureX = Figure.X;
        winnerControl.changeFigure(figureX);
        Figure resultO = winnerControl.changeFigure(figureX);
        assertEquals(resultO.equals(Figure.O), (true));
    }


    @Test
    public void checkDiagonal() throws Exception {
        int field_size = 3;
        Field field = new Field(field_size);
        Figure figure = Figure.X;
        Figure figureO = Figure.O;
        field.setFigure(new Point(0, 0), figure);


        field.setFigure(new Point(1, 1), figure);
        field.setFigure(new Point(2, 2), figure);
        field.setFigure(new Point(0, 1), figureO);
        field.setFigure(new Point(0, 2), figureO);

//        for (int i = 0; i < field.getField().length; i++) {
//            for (int j = 0; j < field.getField()[i].length; j++) {
//                System.out.println(field.getField()[i][j].toString());
//            }
//        }
        WinnerController winnerControl = new WinnerController();
        Boolean fact = winnerControl.checkDiagonal(field, figure);
        boolean expect = true;
        assertEquals(expect, (fact));
    }

    @Test
    public void checkLanes() throws Exception {
        int field_size = 3;
        Field field = new Field(field_size);
        Figure figure = Figure.X;
        Figure figureO = Figure.O;
        field.setFigure(new Point(0, 0), figure);
        field.setFigure(new Point(1, 1), figure);
        field.setFigure(new Point(2, 2), figure);
        field.setFigure(new Point(0, 1), figureO);
        field.setFigure(new Point(0, 2), figureO);
        WinnerController winnerControl = new WinnerController();
        Boolean fact = winnerControl.checkLanes(field, figure);
        boolean expect = true;
        assertEquals(expect, (fact));
    }
    @Test
    public void checkWinnerFigure() throws InvalidPointException {
        int field_size = 3;
        Field field = new Field(field_size);
        Figure figure = Figure.X;
        Figure figureO = Figure.O;
        field.setFigure(new Point(0, 0), figure);
        field.setFigure(new Point(1, 1), figure);
        field.setFigure(new Point(2, 2), figure);
        field.setFigure(new Point(0, 1), figureO);
        field.setFigure(new Point(0, 2), figureO);
        WinnerController winnerControl = new WinnerController();
        Figure factGetiingFigure = winnerControl.getWinner(field).get();
        System.out.println(factGetiingFigure.toString());
        assertEquals(figure, (factGetiingFigure));
    }

}