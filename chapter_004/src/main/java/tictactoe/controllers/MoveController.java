package tictactoe.controllers;

import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.exeption.InvalidPointException;
import tictactoe.model.exeption.OccupiedException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, Point point, Figure figure) throws OccupiedException, InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new OccupiedException();
        }

        field.setFigure(point, figure);
    }
}
