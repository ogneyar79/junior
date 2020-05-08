package tictactoe.view.reader;

import tictactoe.model.Field;
import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;

public class InputerImitator implements IInputCoordinate {

    private final XOaskImitation reader;
    Field field;

    public InputerImitator(Field field) {
        this.field = field;
        this.reader = new XOaskImitation(field);
    }


    @Override
    public Point inputPoint() throws InvalidFigureWriting, InvalidPointException {

            return new Point(reader.askCoordinate("X"), reader.getArrayY());

    }
}
