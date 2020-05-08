package tictactoe.model;

import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.model.exeption.InvalidPointException;
import tictactoe.view.reader.IInputCoordinate;

import java.awt.*;

public class XOSimpleBot implements IInputCoordinate {

    private final String botName;

    private final Figure figure;

    private final LogicalBiohaver logic;
    private final Game game;

    public XOSimpleBot(String botName, Figure figure, Game game) {
        this.botName = botName;
        this.figure = figure;
        this.game = game;
        this.logic = new LogicalBiohaver(figure, game);
    }




    @Override
    public Point inputPoint() throws InvalidFigureWriting, InvalidPointException {
        return logic.getInfoFirstOrNOt(game, figure) ? logic.stepPointIfMyFirst() : logic.stepPointIfMySecond();


    }
}
