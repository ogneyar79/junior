package tictactoe.model;

import tictactoe.model.exeption.InvalidPointException;
import tictactoe.model.exeption.OccupiedException;

import java.awt.*;

public class Field {

    private final int FIELD_SIZE;
    private static final int MIN_COORDINATE = 0;


    private final Figure[][] field;

    public Field(final int field_size) {
        FIELD_SIZE = field_size;
        this.field = new Figure[FIELD_SIZE][FIELD_SIZE];
    }


    public int getFieldSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int MAX_COORDINATE ) {
        return coordinate >= MIN_COORDINATE && coordinate <= MAX_COORDINATE;
    }

    public Figure[][] getField() {
        return field;
    }
}
