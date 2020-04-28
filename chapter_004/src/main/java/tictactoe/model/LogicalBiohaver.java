package tictactoe.model;

import java.awt.*;

public class LogicalBiohaver {

    boolean firstStep;

    public boolean getInfoFirstOrNOt(Game game, Figure figure) {
        boolean result = false;
        if (game.getFirstFigure().equals(figure)) {
            result = true;
        }
        return result;
    }

    public Point stepPoint() {

        return new Point();
    }

    ;

}
