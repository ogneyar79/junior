package tictactoe.model;

import tictactoe.controllers.WinnerController;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LogicalBiohaver {

    int counterStepMy;

    /**
     * index deleted element at array if Point on field is occupied.
     */
    private List<Integer> indexRemoveArray = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7, 8));

    private final Figure figure;
    private final Game game;

    public LogicalBiohaver(Figure figure, Game game) {
        this.figure = figure;
        this.game = game;
    }

    /**
     * procedure that count quantity my Figure on the Field and as result quantity of steps.
     */
    public void counteStepMyFigure() {
        int count = 0;
        Field field = this.game.getField();
        for (int y = 0; y < field.getField().length; y++) {
            for (int x = 0; x < field.getField()[y].length; x++) {
                Figure figure1 = field.getField()[y][x];
                if ((figure1 != null) && figure1.equals(this.figure)) {
                    count++;
                    //        System.err.println(count);
                    //            System.err.println(counterStepMy);
                }
            }
        }
        this.counterStepMy = count;
    }

    /**
     * Function that return result counting of my steps on The field just now.
     *
     * @return result int.
     */
    public int getCountMyStep() {
        this.counteStepMyFigure();
        return counterStepMy;
    }

    /**
     * function chek free cells on the field.
     *
     * @param point
     * @return
     * @throws InvalidPointException
     */
    public boolean checkFree(Point point) throws InvalidPointException {
        boolean result = false;
        if (game.getField().getFigure(point) == null) {
            result = true;
        }
        return result;
    }

    /**
     * Function check that Figure make a  step first or not.
     *
     * @param game
     * @param figure
     * @return
     */
    public boolean getInfoFirstOrNOt(Game game, Figure figure) {
        boolean result = false;
        if (game.getFirstFigure().equals(figure)) {
            result = true;
        }
        return result;
    }


    /**
     * method that look for opportunity for attack or defending, it depends on figure my or opposite,
     * if two cells with our Figure and one free.
     *
     * @param field
     * @param myFigure
     * @return result Optional<Point></> if no opportunity Optional.empty.
     */
    Optional<Point> checkDiagonalFinish(Field field, Figure myFigure) {

        Optional<Point> resultRight = Optional.empty();
        Optional<Point> resultLeft = Optional.empty();

        int countR = 0;
        int countL = 0;
        for (int i = 0; i < field.getField().length; i++) {
            Figure figureR = field.getField()[i][i];
            Figure figureL = field.getField()[field.getField().length - i - 1][i];
            if ((figureR != null) && figureR.equals(myFigure)) {
                countR++;
            }
            if (figureR == null) {
                resultRight = Optional.of(new Point(i, i));
            }
            if ((figureL != null) && figureL.equals(myFigure)) {
                countL++;
            }
            if (figureL == null) {
                resultLeft = Optional.of(new Point(field.getField().length - i - 1, i));
            }
        }
        if (countR > 1 & resultRight.isPresent()) {
            return resultRight;
        }
        if (countL > 1 & resultLeft.isPresent()) {
            return resultLeft;
        }
        return Optional.empty();
    }

    /**
     * method that look for opportunity for attack or defending, it depends on figure my or opposite,
     * if two cells with our Figure and one free.
     *
     * @param field
     * @param myFigure
     * @return result Optional<Point></> if no opportunity Optional.empty.
     */
    Optional<Point> checkLineFinish(Field field, Figure myFigure) {
        int countColumn = 0;
        int countRows = 0;
        Optional<Point> resultColumn = Optional.empty();
        Optional<Point> resultRow = Optional.empty();

        for (int col = 0; col < field.getField().length; col++) {
            for (int row = 0; row < field.getField().length; row++) {
                Figure figureCols = field.getField()[col][row];
                Figure figureRows = field.getField()[row][col];
                if (figureCols == null) {
                    resultColumn = Optional.of(new Point(col, row));
                }
                if (figureRows == null) {
                    resultRow = Optional.of(new Point(row, col));
                }
                if ((figureCols != null) && figureCols.equals(myFigure)) {
                    countColumn++;
                }
                if ((figureRows != null) && figureRows.equals(myFigure)) {
                    countRows++;
                }
                if (row == field.getField().length - 1 & countColumn > 1 & resultColumn.isPresent()) {
                    return resultColumn;
                }
                if (row == field.getField().length - 1 & countRows > 1 & resultRow.isPresent()) {
                    return resultRow;
                } else if (row == field.getField().length - 1) {
                    countColumn = 0;
                    resultColumn = Optional.empty();
                    countRows = 0;
                    resultRow = Optional.empty();
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Function that return Random Point from range except 3 cells.
     */
    Point getRandomCordinate() throws InvalidPointException {

        int firstRandom = (int) (Math.random() * this.indexRemoveArray.size());
        int arrayIndex = indexRemoveArray.get(firstRandom);
        int size = 3;
        int arrayX = arrayIndex / size;
        int arrayY = arrayIndex - (arrayX * size);
        Point result = new Point(arrayX, arrayY);
        this.indexRemoveArray.remove(firstRandom);
        while (!checkFree(result)) {
            result = getRandomCordinate();
        }
        return result;
    }


    /**
     * Function look for opportunity to attack if we placed two cells or defend if opponent did it.
     * else Optional.empty but If we have select of attack and defend, choose attack.
     *
     * @return Optional<Point></>
     */
    Optional<Point> getPrioritetAttakElseDeffendElseEmpty() {
        if (checkDiagonalFinish(this.game.getField(), this.figure).isPresent()) {
            return checkDiagonalFinish(this.game.getField(), this.figure);
        }
        if (checkLineFinish(this.game.getField(), this.figure).isPresent()) {
            return checkLineFinish(this.game.getField(), this.figure);
        }
        if (checkDiagonalFinish(this.game.getField(), WinnerController.changeFigure(this.figure)).isPresent()) {
            return checkDiagonalFinish(this.game.getField(), WinnerController.changeFigure(this.figure));
        }
        if (checkLineFinish(this.game.getField(), WinnerController.changeFigure(this.figure)).isPresent()) {
            return checkLineFinish(this.game.getField(), WinnerController.changeFigure(this.figure));
        }
        return Optional.empty();
    }

    /**
     * function how our bot think about his step if it moves first.
     *
     * @return Point.
     * @throws InvalidPointException
     */
    public Point stepPointIfMyFirst() throws InvalidPointException {
        Point result;
        if (this.getCountMyStep() == 0) {
            return new Point(1, 1);
        }
        if (this.getCountMyStep() == 1) {
            return checkFree(new Point(0, 0)) ? new Point(0, 0) : new Point(2, 0);
        }
        if (getPrioritetAttakElseDeffendElseEmpty().isPresent()) {
            return getPrioritetAttakElseDeffendElseEmpty().get();
        }
        result = getRandomCordinate();
        return result;
    }

    /**
     * function how our bot think about his step if it moves Second.
     *
     * @return Point.
     * @throws InvalidPointException
     */
    public Point stepPointIfMySecond() throws InvalidPointException {

        Point result;
        if (this.getCountMyStep() == 0) {
            return checkFree(new Point(1, 1)) ? new Point(1, 1) : new Point(0, 0);
        }

        if (getPrioritetAttakElseDeffendElseEmpty().isPresent()) {
            return getPrioritetAttakElseDeffendElseEmpty().get();
        } else if (this.getCountMyStep() == 1) {
            return checkFree(new Point(0, 0)) ? new Point(0, 0) : new Point(2, 0);
        }

        result = getRandomCordinate();
        return result;
    }
}
