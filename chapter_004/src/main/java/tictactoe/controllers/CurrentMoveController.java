package tictactoe.controllers;

import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;
import java.util.Optional;

/**
 * Class that show Which figure must make a step.
 */
public class CurrentMoveController {
    private int countStep;

    private final Field field;

    /**
     * figure that make first Step at The Game.
     * from this depend definition current figure.
     */
    private final Figure firstFigure;


    public CurrentMoveController(Field field, Figure firstFigure) {
        this.field = field;
        this.firstFigure = firstFigure;
    }

    /**
     * Function that show figure that need to make a step
     *
     * @return figureResult Optional is Figure figure that first gow.
     */
    public Optional<Figure> getCurrentFigure() {

        Optional<Figure> figureResult = Optional.of(WinnerController.changeFigure(this.firstFigure));
        this.countStep = 0;
        for (int columns = 0; columns < this.field.getFieldSize(); columns++) {
            countStep += this.countFigureAtColumns(columns);
        }
        if (countStep % 2 == 0) {
            figureResult = Optional.of(firstFigure);
        }
        if (countStep == this.field.getFieldSize() * this.field.getFieldSize()) {
            figureResult = Optional.empty();
        }
        return figureResult;
    }

    /**
     * inner funcktion for using at getCurrentFigure's method for counting figures at columns from up to down.
     *
     * @param colmns int number column at array From field Field.
     * @return
     */
    int countFigureAtColumns(final int colmns) {
        int countFigure = 0;
        for (int row = 0; row < field.getFieldSize(); row++) {
            try {
                if (field.getFigure(new Point(row, colmns)) != null) {

                    ++countFigure;
   //                 System.err.println(countFigure);
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }

    public int getCountStep() {
        return countStep;
    }
}
