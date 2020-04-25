package tictactoe.controllers;

import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.model.exeption.InvalidFigure;
import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.view.ConsoleView;
import tictactoe.view.reader.IXOConsoleReader;
import tictactoe.view.reader.XOReader;

import java.awt.*;
import java.util.Optional;

/**
 * Class that aggregate our Controllers that we can play.
 */
public class GameController {

    /**
     * object that define show our game.
     */
    private final ConsoleView consoleView;

    /**
     * object that control movement our figure.
     */
    private final MoveController moveController;

    public GameController(ConsoleView consoleView, MoveController moveController) {
        this.consoleView = consoleView;
        this.moveController = moveController;
    }


    /**
     * Procedure that make game to play.
     *
     * @param game Game.
     * @throws InvalidFigure
     */

    public void aggregatePlay(Game game) throws InvalidFigure, InvalidFigureWriting {
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

    public static void main(String... args) throws InvalidFigure, InvalidFigureWriting {
        Player[] players = new Player[2];
        Field field = new Field(3);
        players[0] = new Player("ONE", Figure.X);
        players[1] = new Player("TWO", Figure.O);
        Game game = new Game(players, field, "FIRSTGame");
        IXOConsoleReader reader = new XOReader();
        ConsoleView consoleView = new ConsoleView(reader);
        CurrentMoveController currentController = new CurrentMoveController(game.getField(), game.getFirstFigure());
        WinnerController winnerController = new WinnerController();
        MoveController moveController = new MoveController(currentController, winnerController);

        GameController gameController = new GameController(consoleView, moveController);
        gameController.aggregatePlay(game);
    }

}
