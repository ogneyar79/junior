package tictactoe.view;

import tictactoe.model.Field;
import tictactoe.model.Figure;
import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.model.exeption.InvalidPointException;
import tictactoe.view.reader.IInputCoordinate;
import tictactoe.view.reader.IXOConsoleReader;
import tictactoe.view.reader.PointIputer;
import tictactoe.view.reader.XOReader;

import java.awt.*;
import java.util.Optional;

public class ConsoleView {
    private static final Character SEPARATOR = '~';

    private final int separatorLength = 11;
    private final int indentLength = 50;
    private final int halfIndentL = indentLength / 2;
    private final String hypnenView = " -- ";

    private IXOConsoleReader reader;
    private IInputCoordinate imputer;

    public ConsoleView(IXOConsoleReader reader, IInputCoordinate imputer) {
        this.reader = reader;
        this.imputer = imputer;
    }

    public ConsoleView(IInputCoordinate imputer) {
        this.imputer = imputer;
    }

    public ConsoleView() {
    }

    public void show(final Game game) {
        final Player plOne = game.getPlayers()[0];
        final Player plTwo = game.getPlayers()[1];

        System.err.format("%" + indentLength + "s\n", " Game name:" + game.getName());

        System.err.format("%" + (halfIndentL
                        - separatorLength
                        + plTwo.getName().length()
                        + hypnenView.length() + plOne.getFigure().toString().length()) + "s %"
                        + (halfIndentL
                        + separatorLength
                        + halfIndentL
                        - plTwo.getName().length() - hypnenView.length() - plTwo.getFigure().toString().length()) + "s",
                plOne.getName() + hypnenView + plOne.getFigure(),
                plTwo.getName() + hypnenView + plTwo.getFigure() + "\n");

        final Field field = game.getField();
        for (int y = 0; y < field.getFieldSize(); y++) {
            if (y != 0) {
                System.err.format("%" + indentLength + "s\n", generateSeparator(SEPARATOR, separatorLength));
            }
            System.err.format("%" + indentLength + "s\n", generateLine(field, y));
        }
    }


    protected String generateLine(final Field field, final int y) {
        String result = "";
        try {
            for (int x = 0; x < field.getFieldSize(); x++) {
                Figure figure = null;
                try {
                    figure = field.getFigure(new Point(x, y));
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }
                String leftWall = (x != 0 ? "|" : "");
                String figureSymbol = String.format("%s", figure != null ? figure : " ");
                String figureCell = String.format("%s%2s ", leftWall, figureSymbol);
                result = result.concat(figureCell);

            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return result;
    }


//    private int askCoordinate(final String coordinateName) {
//        System.err.format("Please input %s", coordinateName);
//        final Scanner in = new Scanner(System.in);
//        return in.nextInt();
//    }

    public String showWinner(Optional<Figure> figure) {
        String message;
        if (figure.isPresent()) {
            message = "Winner is " + figure;
            System.out.println(message);

        } else {
            message = " No winner here is draw";
        }
        return message;
    }

    public Point askPoint() throws InvalidFigureWriting, InvalidPointException {

        return this.imputer.inputPoint();
    }

    public String generateSeparator(final Character piece, final int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result = result + piece;
        }
        return result;
    }

    public static void main(String... args) {

        Field field = new Field(3);
        IXOConsoleReader reader2 = new XOReader();
        IInputCoordinate imputer = new PointIputer((XOReader) reader2);
        ConsoleView consoleView = new ConsoleView(reader2, imputer);
        String empty = consoleView.generateLine(field, 2);
        System.out.print(empty);

        String line = consoleView.generateSeparator('~', 10);
        System.out.print(line);
        System.err.format("%" + consoleView.indentLength + "s\n", consoleView.generateSeparator(ConsoleView.SEPARATOR, 11));
    }

}
