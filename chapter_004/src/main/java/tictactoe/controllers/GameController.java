package tictactoe.controllers;

import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.Game;
import tictactoe.model.exeption.InvalidFigure;
import tictactoe.view.ConsoleView;

import java.awt.*;
import java.util.Optional;

/**
 * Class that aggregate our Controllers that we can play.
 */
public class GameController {

    private final ConsoleView consoleView;
    private final MoveController moveController;

    public GameController(ConsoleView consoleView, MoveController moveController) {
        this.consoleView = consoleView;
        this.moveController = moveController;
    }

    public void aggregatePlay(Game game) throws InvalidFigure {
        this.consoleView.show(game);
        Field field = game.getField();
        while (moveController.controlMove(field)) {
            final Figure currentF = moveController.getCurrentMoveController().getCurrentFigure().get();
            System.err.format("Please  enter move Point for: %s\n", currentF);
            Point point = this.consoleView.askPoint();
            moveController.moveFigure(field, point, currentF);
            this.consoleView.show(game);
        }
        moveController.getCurrentMoveController();
        Optional<Figure> figure = moveController.getWinnerController().getWinner(game.getField());
        consoleView.showWinner(figure);
    }

}
