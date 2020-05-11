package tictactoe.controllers;

import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.exeption.InvalidFigure;
import tictactoe.model.exeption.InvalidPointException;
import tictactoe.model.exeption.OccupiedException;

import java.awt.*;
import java.util.Optional;

/**
 * Class control setting (moving) figures on field.
 */
public class MoveController {
    private final CurrentMoveController currentMoveController;
    final WinnerController winnerController;

    public MoveController(CurrentMoveController currentMoveController, WinnerController winnerController) {
        this.currentMoveController = currentMoveController;
        this.winnerController = winnerController;
    }

    /**
     * Procedure that setting figure on field.
     *
     * @param field  Field where setting figures.
     * @param point  Point coordinate according with we setting figures.
     * @param figure Figure that we setting.
     * @throws OccupiedException
     * @throws InvalidPointException
     */
    void applyFigure(final Field field, Point point, Figure figure) throws OccupiedException, InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new OccupiedException();
        }
        field.setFigure(point, figure);
    }

    /**
     * Function that check opportunity setting figure, aggregation two controllers.
     *
     * @return result boolean.
     */
    public boolean controlMove(final Field field) {
        boolean result = false;
        boolean moveResult = this.currentMoveController.getCurrentFigure().isPresent();
        boolean winnerResultNO = !this.winnerController.getWinner(field).isPresent();
        if (moveResult & winnerResultNO) {
            result = true;
        }
        return result;
    }

    /**
     * Function that move figure, but before need use controlMove method, that check validation.
     *
     * @param field    Field.
     * @param point    Point
     * @param currentF Figure
     * @return result boolean if was successed in.
     */
    public boolean moveFigure(final Field field, final Point point, Figure currentF) throws InvalidFigure, OccupiedException, InvalidPointException {
        boolean result = false;
        if (currentF != this.currentMoveController.getCurrentFigure().get()) {
            throw new InvalidFigure("NO according to current Figure");
        }
        if (field.checkFreeOccupied(point) & field.checkPoint(point)) {
            this.applyFigure(field, point, currentF);
            result = true;
        }
        return result;
    }


    public CurrentMoveController getCurrentMoveController() {
        return currentMoveController;
    }

    public Optional<Figure> getCurrentFigure() {
        return this.currentMoveController.getCurrentFigure();

    }

    public WinnerController getWinnerController() {
        return winnerController;
    }
}
