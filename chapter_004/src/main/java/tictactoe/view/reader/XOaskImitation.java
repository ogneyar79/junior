package tictactoe.view.reader;

import tictactoe.model.exeption.InvalidFigureWriting;

public class XOaskImitation implements IXOConsoleReader {


    final private int size;
    final private int arrayIndex;
    private final int rangeOneArray;

    public XOaskImitation(int size, int arrayIndex, int rangeOneArray) {
        this.arrayIndex = arrayIndex;
        this.size = size;
        this.rangeOneArray = rangeOneArray;
    }


    @Override
    public int askCoordinate(String coordinateName) throws InvalidFigureWriting {
        System.out.format("Please input %s:", coordinateName);
        int arrayX = this.arrayIndex / this.size;
        int arrayY = this.arrayIndex - (arrayX * this.size);

        if (coordinateName.equalsIgnoreCase("X")) {
            return arrayX;
        }
        if (coordinateName.equalsIgnoreCase("Y")) {
            return arrayY;
        }
        throw new InvalidFigureWriting();

    }


}
