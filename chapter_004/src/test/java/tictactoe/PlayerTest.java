package tictactoe;

import org.junit.Test;
import tictactoe.model.Figure;
import tictactoe.model.Player;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() throws Exception {
        final String nameInput = " Rob";
        final String expected = nameInput;

        Player player = new Player(nameInput, null);
        final String actualName = player.getName();
        assertEquals(expected, actualName);
    }

    @Test
    public void getFigure() throws Exception {
        final Figure inputValue = Figure.X;
        final  Figure expected = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualFigure = player.getFigure();

        assertEquals(expected, actualFigure);

    }

}