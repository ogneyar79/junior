package tictactoe.controllers;

import tictactoe.model.Game;
import tictactoe.model.exeption.InvalidFigure;
import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.model.exeption.InvalidPointException;
import tictactoe.model.exeption.OccupiedException;

public interface IGameController {
    public void aggregatePlay(Game game) throws InvalidFigure, InvalidFigureWriting, InvalidPointException, OccupiedException;
}
