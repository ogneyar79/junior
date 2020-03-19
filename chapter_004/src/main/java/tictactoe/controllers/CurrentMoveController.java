package tictactoe.controllers;

import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;
import java.util.Optional;

public class CurrentMoveController {

    public Optional<Figure> getCurrentFigure(final Field field, Figure firstFigure) {
        Optional<Figure> figureResult = Optional.of(WinnerController.changeFigure(firstFigure));
        int countStep = 0;
        for (int columns = 0; columns < field.getFieldSize(); columns++) {
            countStep += this.countFigureAtColumns(field, columns);
        }
        if (countStep % 2 == 0) {
            figureResult = Optional.of(firstFigure);
        }
        if (countStep == field.getFieldSize() * field.getFieldSize()) {
            figureResult = Optional.empty();
        }
        return figureResult;
    }


    int countFigureAtColumns(final Field field, final int colmns) {
        int countFigure = 0;
        for (int row = 0; row < field.getFieldSize(); row++) {
            try {
                if (field.getFigure(new Point(row, colmns)) != null) {

                    ++countFigure;
                    System.err.println(countFigure);
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }


}
