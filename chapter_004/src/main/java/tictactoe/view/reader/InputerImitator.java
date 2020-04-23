package tictactoe.view.reader;

import tictactoe.model.Field;
import tictactoe.model.exeption.InvalidFigureWriting;

import java.awt.*;

public class InputerImitator implements IInputCoordinate {

    private final IXOConsoleReader reader;


    public InputerImitator(IXOConsoleReader reader) {

        this.reader = reader;
    }


    @Override
    public Point inputPoint() throws InvalidFigureWriting {
        return new Point(reader.askCoordinate("X"), reader.askCoordinate("Y") - 1);
    }
}
