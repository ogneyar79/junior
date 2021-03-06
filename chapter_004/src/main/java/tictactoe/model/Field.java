package tictactoe.model;

import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;

/**
 * Class is field for game Tic Tac Toe, actually [][] array.
 */
public class Field {

    private final int fieldSize;
    private static final int MIN_COORDINATE = 0;


    /**
     * array for setting figure.
     */
    private final Figure[][] field;

    /**
     * Creator for creating major field where game in progress.
     *
     * @param fieldSize
     */
    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        this.field = new Figure[this.fieldSize][this.fieldSize];

    }


    public int getFieldSize() {
        return fieldSize;
    }

    /**
     * Function where get Figure from field by Point.
     *
     * @param point Point that find figure.
     * @return Figure figure.
     * @throws InvalidPointException
     */
    public Figure getFigure(Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    /**
     * Procedure for setting figure on field.
     *
     * @param point  Point, coordinate where setting figure actually [][].
     * @param figure Figure
     * @throws InvalidPointException
     */
    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }


    public boolean checkFreeOccupied(Point point)  {
        boolean result = false;
        try {
            if (this.getFigure(point) == null) {
                result = true;
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * function that check correctness coordinate on field.
     *
     * @param point Point checked coordinate.
     * @return boolean result.
     */
    public boolean checkPoint(Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    /**
     * function for checking one point from Point.
     *
     * @param coordinate
     * @param maxCoordinate
     * @return result boolean.
     */
    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate <= maxCoordinate;
    }

    public Figure[][] getField() {
        return field;
    }


    /**
     * function that counts how many can be elements on our field.
     *
     * @return count int.
     */
    public int getElementCounter() {
        int count = 0;
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                count++;
            }
        }
        return count;
    }
}
