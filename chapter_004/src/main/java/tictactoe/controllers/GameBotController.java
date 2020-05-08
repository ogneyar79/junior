package tictactoe.controllers;

import tictactoe.model.*;
import tictactoe.model.exeption.InvalidFigure;
import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.model.exeption.InvalidPointException;
import tictactoe.model.exeption.OccupiedException;
import tictactoe.view.ConsoleView;
import tictactoe.view.reader.InputerImitator;

import java.awt.*;
import java.util.Optional;

public class GameBotController implements IGameController {
    /**
     * object that define show our game.
     */
    private final ConsoleView consoleView;

    /**
     * object that control movement our figure.
     */
    private final MoveController moveController;

    public GameBotController(ConsoleView consoleView, MoveController moveController) {
        this.consoleView = consoleView;
        this.moveController = moveController;
    }


    @Override
    public void aggregatePlay(Game game) throws InvalidFigure, InvalidFigureWriting, InvalidPointException, OccupiedException {
        this.consoleView.show(game);
        Field field = game.getField();
        while (moveController.controlMove(field)) {
            Figure currentF = moveController.getCurrentMoveController().getCurrentFigure().get();
            System.err.format("Please  enter move Point for: %s\n", currentF);
            XOSimpleBot brain = new XOSimpleBot("BRAIN", currentF, game);
            Point point = brain.inputPoint();
            while (!field.checkPoint(point) & !(field.checkFreeOccupied(point))) {
                System.err.println("Put walid coordinate");
                point = brain.inputPoint();
            }
            moveController.moveFigure(field, point, currentF);
            this.consoleView.show(game);
            if (!moveController.controlMove(field)) {
                System.err.println(" We have winner");
                break;
            }
            currentF = moveController.getCurrentMoveController().getCurrentFigure().get();
            System.err.format("Please  enter move Point for: %s\n", currentF);
            InputerImitator inputerImitator = new InputerImitator(field);
            point = inputerImitator.inputPoint();
            while (!field.checkPoint(point) & !(field.checkFreeOccupied(point))) {
                System.err.println("Put valid coordinate");
                point = inputerImitator.inputPoint();
            }
            moveController.moveFigure(field, point, currentF);
            this.consoleView.show(game);
        }
        Optional<Figure> figure = moveController.getWinnerController().getWinner(game.getField());
        consoleView.showWinner(figure);
    }

    public static void main(String... args) throws InvalidFigure, InvalidFigureWriting, OccupiedException, InvalidPointException {
        Player[] players = new Player[2];
        Field field = new Field(3);
        players[0] = new Player("ONE", Figure.X);
        players[1] = new Player("TWO", Figure.O);
        Game game = new Game(players, field, "FIRSTGame");
        ConsoleView consoleView = new ConsoleView();
        CurrentMoveController currentController = new CurrentMoveController(game.getField(), game.getFirstFigure());
        WinnerController winnerController = new WinnerController();
        MoveController moveController = new MoveController(currentController, winnerController);
        IGameController warBots = new GameBotController(consoleView, moveController);
        warBots.aggregatePlay(game);
    }
}
