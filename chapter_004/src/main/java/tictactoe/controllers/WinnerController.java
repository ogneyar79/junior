package tictactoe.controllers;

import tictactoe.model.Field;
import tictactoe.model.Figure;

import java.util.Optional;

/**
 * Class Show Who win or The game go on.
 */
public class WinnerController {


    /**
     * method return Winner Figure Optional if have Or Optional with Null.
     *
     * @param field Field
     * @return result Optional can be with Null.
     */
    public Optional<Figure> getWinner(Field field) {
        Optional<Figure> result = Optional.ofNullable(null);
        Figure figure = Figure.X;
        if ((this.checkDiagonal(field, figure)) || (this.checkLanes(field, figure))) {
            result = Optional.of(figure);
        } else if (this.checkDiagonal(field, this.changeFigure(figure)) || this.checkLanes(field, this.changeFigure(figure))) {
            result = Optional.of(this.changeFigure(figure));
        }
        return result;
    }

    /**
     * method change Figure Tic Tac Toe.
     *
     * @param figure Figure.
     * @return result Figure
     */
    Figure changeFigure(Figure figure) {
        Figure frsult = null;
        Figure figureX = Figure.X;
        Figure figureO = Figure.O;
        if (figureX.equals(figure)) {
            frsult = figureO;
        }
        if (figureO.equals(figure)) {
            frsult = figureX;
        }
        return frsult;
    }

    /**
     * Function check  if all Figures on  all diagonals field  are The same.
     *
     * @param field
     * @param figure
     * @return
     */
    boolean checkDiagonal(Field field, Figure figure) {
        boolean right = true;
        boolean left = true;
        for (int i = 0; i < field.getField().length; i++) {
            Figure figureR = field.getField()[i][i];
            Figure figureL = field.getField()[field.getField().length - i - 1][i];
            if (figureR == null & figureL == null) {
                return false;
            }
            if (figureR == null) {
                figureR = this.changeFigure(figure);
            }
            if (figureL == null) {
                figureL = this.changeFigure(figure);
            }
            right &= (figureR.equals(figure));
            left &= (figureL.equals(figure));
        }
        if (right || left) {
            return true;
        }
        return false;
    }

    /**
     * Function check  if all Figures  are The same on  all lines(colons and rows) of field  are The same.
     *
     * @param field
     * @param figure
     * @return
     */
    boolean checkLanes(Field field, Figure figure) {
        boolean cols, rows;
        for (int col = 0; col < field.getField().length; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < field.getField().length; row++) {
                Figure figureCols = field.getField()[col][row];
                Figure figureRows = field.getField()[row][col];
                if (figureCols == null) {
                    figureCols = this.changeFigure(figure);
                }
                if (figureRows == null) {
                    figureRows = this.changeFigure(figure);

                    cols &= (figureCols.equals(figure));
                    rows &= (figureRows.equals(figure));
                }
                if (cols || rows) {
                    return true;
                }
            }
        }
        return false;
    }
}
