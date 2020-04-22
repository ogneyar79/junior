package tictactoe.view.reader;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class XOaskImitationTest {


    int arrayDouble[][] = new int[][]{
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}};

    int size = arrayDouble.length;

    int array[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    int rangeOneArray = array.length;

    int arrayindex;
    IXOConsoleReader readerImitator;

    @Before
    public void setUp() throws Exception {
        arrayindex = 4;
        readerImitator = new XOaskImitation(size, rangeOneArray, arrayindex);
    }

    @Test
    public void askCoordinate() throws Exception {
        int resultX = readerImitator.askCoordinate("x");
        int resultY = readerImitator.askCoordinate("y");
        int expected = arrayDouble[resultX][resultY];
        assertEquals(expected, array[arrayindex]);

    }

}