package tictactoe.view.reader;

import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;

public class PointIputer implements IInputCoordinate {


    private final IXOConsoleReader reader;

    public PointIputer(IXOConsoleReader reader) {
        this.reader = reader;
    }

    @Override
    public Point inputPoint() throws InvalidFigureWriting, InvalidPointException {
        return new Point(this.reader.askCoordinate("X") - 1, reader.askCoordinate("Y") - 1);
    }
}
