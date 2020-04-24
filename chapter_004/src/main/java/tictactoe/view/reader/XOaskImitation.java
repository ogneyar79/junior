package tictactoe.view.reader;

import tictactoe.model.Field;
import tictactoe.model.exeption.InvalidFigureWriting;

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


    @Override
    public int askCoordinate(String coordinateName) throws InvalidFigureWriting {
        System.out.format("Please input %s:", coordinateName);
        int arrayIndex = (int) (Math.random() * (field.getElementCounter()));
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
}
