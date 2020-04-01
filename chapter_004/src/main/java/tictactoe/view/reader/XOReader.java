package tictactoe.view.reader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class XOReader implements IXOConsoleReader {


    @Override
    public int askCoordinate(String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("0_0 olololo!!!!!");
            return askCoordinate(coordinateName);
        }
    }

}
