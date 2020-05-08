package tictactoe.view.reader;

import tictactoe.model.Field;
import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XOaskImitation implements IXOConsoleReader {


    final private int size;        // field.size
    // final private int arrayIndex;
    //  private final int rangeOneArray;  // size array quantity fields
    private final Field field;
    private int arrayX;
    private int arrayY;

    public XOaskImitation(Field field) {
        this.field = field;
        this.size = field.getFieldSize();
    }

    private int arrayIndex;

    /**
     * index deleted element at array if Point on field is occupied.
     */
    private List<Integer> indexRemoveArray = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));

    /**
     * function chek free cells on the field.
     *
     * @param point
     * @return
     * @throws InvalidPointException
     */
    public boolean checkFree(Point point) throws InvalidPointException {
        boolean result = false;
        if (this.field.getFigure(point) == null) {
            result = true;
        }
        return result;
    }

    @Override
    public int askCoordinate(String coordinateName) throws InvalidFigureWriting, InvalidPointException {
      //  System.out.format("Please input %s:", coordinateName);
        int firstRandom = (int) (Math.random() * (indexRemoveArray.size()));
        int coodinateAtOne = indexRemoveArray.get(firstRandom);
        this.indexRemoveArray.remove(firstRandom);
        arrayX = coodinateAtOne / this.size;
        arrayY = coodinateAtOne - (arrayX * this.size);
        while (!checkFree(new Point(arrayX, arrayY))) {
            arrayX = askCoordinate("X");
            arrayY = getArrayY();
        }
        if (coordinateName.equalsIgnoreCase("X")) {
            return arrayX;
        }
        if (coordinateName.equalsIgnoreCase("Y")) {
            return arrayY;
        }

        throw new InvalidFigureWriting();

    }

    public int askCoorImitator(String coordinateName, int arrayIndex) throws InvalidFigureWriting {
        System.out.format("Please input %s:", coordinateName);

        this.arrayIndex = arrayIndex;
        arrayX = arrayIndex / this.size;
        arrayY = arrayIndex - (arrayX * this.size);

        if (coordinateName.equalsIgnoreCase("X")) {
            return arrayX;
        }
        if (coordinateName.equalsIgnoreCase("Y")) {
            return arrayY;
        }
        throw new InvalidFigureWriting();
    }


    private int getArrayX() {
        return arrayX;
    }

    int getArrayY() {
        return arrayY;
    }

    int getArrayIndex() {
        return arrayIndex;
    }
}
