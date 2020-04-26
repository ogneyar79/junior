package tictactoe.view.reader;

import java.awt.*;

public class PointIputer implements IInputCoordinate {


    private final XOReader reader;

    public PointIputer(XOReader reader) {
        this.reader = reader;
    }

    @Override
    public Point inputPoint() {
        return new Point(this.reader.askCoordinate("X") - 1, reader.askCoordinate("Y") - 1);
    }
}
