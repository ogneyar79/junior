package tictactoe.view.reader;

import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.model.exeption.InvalidPointException;

public interface IXOConsoleReader {

    int askCoordinate(final String coordinateName) throws InvalidFigureWriting, InvalidPointException;
}
