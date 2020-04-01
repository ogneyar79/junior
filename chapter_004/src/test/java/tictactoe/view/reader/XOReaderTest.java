package tictactoe.view.reader;

import org.junit.Test;
import tictactoe.model.Figure;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class XOReaderTest {

    XOReader reader = new XOReader();
    Scanner scanner;

    @Test
    public void askCoordinate() {
        ByteArrayInputStream input = new ByteArrayInputStream(("0").getBytes());
        System.setIn(input);
        scanner = new Scanner(System.in);
        Figure figure = Figure.X;
        String message = " For figure" + figure;
        int zero = reader.askCoordinate(message);

        assertEquals(0, zero);
    }
}