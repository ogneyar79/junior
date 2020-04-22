package tictactoe.view.reader;

import tictactoe.model.exeption.InvalidFigureWriting;

public interface IXOConsoleReader {

    int askCoordinate(final String coordinateName) throws InvalidFigureWriting;
}
