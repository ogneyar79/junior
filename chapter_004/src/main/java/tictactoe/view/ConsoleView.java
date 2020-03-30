package tictactoe.view;

import tictactoe.controllers.CurrentMoveController;
import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.Game;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleView {


    public void show(final Game game) {
        System.err.format(" Game name %s\n", game.getName());
        Field field = game.getField();
        for (int x = 0; x < field.getFieldSize(); x++) {
            if (x != 0) {
                printSeparator();
            }
            printLine(field, x);
        }
    }


    private void printLine(final Field field, final int x) {

        for (int y = 0; y < field.getFieldSize(); y++) {
            if (y != 0) {
                System.err.print("|");
            }
            System.err.print(" ");

            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
            } catch (InvalidPointException e) {
                throw new RuntimeException(e);
            }
            System.err.print(figure != null ? figure : "  ");
            System.err.print(" ");
        }
        System.err.println();
    }

    private int askCoordinate(final String coordinateName) {
        System.err.format("Please input %s", coordinateName);
        final Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public String showWinner(Optional<Figure> figure) {
        String message;
        if (figure.isPresent()) {
            message = "Winner is " + figure;
            System.out.print(message);

        } else {
            message = " No winner here is draw";
        }
        return message;
    }

    public Point askPoint() {

        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private void printSeparator() {
        System.err.println("~~~~~~~~~~~~~~");
    }

}
