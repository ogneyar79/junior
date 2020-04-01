package tictactoe.view;

import org.junit.jupiter.api.Test;
import tictactoe.model.Field;
import tictactoe.model.Figure;

import java.awt.*;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ConsoleViewTest {
    ConsoleView consoleView = new ConsoleView();

    @Test
    public void testLineFormatWithElement() throws Exception {
        final String line = " O |   |   ";

        final Field field = new Field(3);
        field.setFigure(new Point(0, 1), Figure.O);
        System.err.print(line);
        assertEquals(line, consoleView.generateLine(field, 1));
    }

    @Test
    public void testLineFormatWith2Elements() throws Exception {
        final String line = " O |   | X ";

        final Field field = new Field(3);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(2, 1), Figure.X);
        System.err.print(line);
        assertEquals(line, consoleView.generateLine(field, 1));
    }

    @Test
    public void testLineFormatWith3Elements() throws Exception {
        final String line = " O | X | X ";
        System.err.print(line);

        final Field field = new Field(3);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.X);

        assertEquals( line, consoleView.generateLine(field, 1));
    }

    @Test
    public void testArgumentFieldIsNull() throws Exception {
        try {
            consoleView.generateLine(null, 1);
        } catch (Exception ex) {
            fail("Program is failed, because argument 'field' is null");
        }
    }

    @Test
    public void testArgumentLineNumberIsInvalid() throws Exception {
        final Field field = new Field(3);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.X);

        try {
            consoleView.generateLine(field, -1);
        } catch (Exception ex) {
            fail("Program is failed, because argument 'line number' has value '-1'");
        }
    }

    @Test
    public void testArgumentsFieldAndLineNumberAreInvalid() throws Exception {
        try {
            consoleView.generateLine(null, -1);
        } catch (Exception ex) {
            fail("Program is failed, because argument 'field' is null or argument 'line number' has value '-1'");
        }
    }
}