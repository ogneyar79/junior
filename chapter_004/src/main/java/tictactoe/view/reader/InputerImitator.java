package tictactoe.view.reader;

import tictactoe.model.Field;
import tictactoe.model.exeption.InvalidFigureWriting;

import java.awt.*;

public class InputerImitator implements IInputCoordinate {

    private final XOaskImitation reader;
    Field field;

    public InputerImitator(Field field) {
        this.field = field;
        this.reader = new XOaskImitation(field);
    }


    @Override
    public Point inputPoint() {
        try {
            return new Point(reader.askCoordinate("X"), reader.getArrayY());
        } catch (InvalidFigureWriting invalidFigureWriting) {
            invalidFigureWriting.printStackTrace();
        }
    }
}
