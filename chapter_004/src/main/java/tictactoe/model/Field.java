package tictactoe.model;

import tictactoe.model.exeption.InvalidPointException;
import tictactoe.model.exeption.OccupiedException;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getFieldSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException, OccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        if(field[point.x][point.y] !=null) {
            throw new OccupiedException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate <= MAX_COORDINATE;
    }
}
