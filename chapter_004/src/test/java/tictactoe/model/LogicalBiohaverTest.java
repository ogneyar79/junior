package tictactoe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LogicalBiohaverTest {

    Figure myFigure;

    Player[] players;
    Field field;
    Game game;
    LogicalBiohaver logicalBiohaver;

    @BeforeEach
    void setUp() {
        myFigure = Figure.X;
        players = new Player[2];
        players[0] = new Player("Brain", myFigure);
        players[1] = new Player("Empty", Figure.O);
        field = new Field(3);
        game = new Game(players, field, "TestGame");
        logicalBiohaver = new LogicalBiohaver(myFigure, game);
    }

    @Test
    void counteStepMyFigureAndGetCountMyStep() throws InvalidPointException {
        int actual = logicalBiohaver.getCountMyStep();
        int expected = 0;
        assertEquals(expected, actual);

        field.setFigure(new Point(0, 0), myFigure);
        int expectedTwo = 1;
        actual = logicalBiohaver.getCountMyStep();
        assertEquals(expectedTwo, actual);

        field.setFigure(new Point(2, 0), Figure.O);
        field.setFigure(new Point(1, 0), myFigure);
        field.setFigure(new Point(0, 1), Figure.O);
        assertEquals(2, logicalBiohaver.getCountMyStep());

    }

    @Test
    void checkFree() throws InvalidPointException {
        boolean actual = logicalBiohaver.checkFree(new Point(0, 0));
        boolean expected = true;
        assertEquals(expected, actual);
        field.setFigure(new Point(1, 0), myFigure);
        field.setFigure(new Point(0, 1), Figure.O);
        actual = logicalBiohaver.checkFree(new Point(1, 0));
        expected = false;
        assertEquals(expected, actual);
        actual = logicalBiohaver.checkFree(new Point(0, 1));
        expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void getInfoFirstOrNOt() {
        boolean actualResult = logicalBiohaver.getInfoFirstOrNOt(game, myFigure);
        boolean expected = true;
        assertEquals(expected, actualResult);
        actualResult = logicalBiohaver.getInfoFirstOrNOt(game, Figure.O);
        expected = false;
        assertEquals(expected, actualResult);
    }

    @Test
    void checkDiagonalFinish() throws InvalidPointException {
        Optional<Point> actualResult = logicalBiohaver.checkDiagonalFinish(field, myFigure);
        boolean expectedResult = true;
        boolean actual = actualResult.isEmpty();
        assertEquals(true, actual);
        field.setFigure(new Point(1, 1), myFigure);
        field.setFigure(new Point(0, 0), myFigure);
        actualResult = logicalBiohaver.checkDiagonalFinish(field, myFigure);
        actual = actualResult.isPresent();
        int X = (int) actualResult.get().getX();
        int Y = (int) actualResult.get().getY();
        int expectedX = 2;
        int expectedY = 2;
        assertEquals(true, actual);
        assertEquals(expectedX, X);
        assertEquals(expectedY, Y);
    }

    @Test
    void checkDiagonalFinishForOpoziteFigure() throws InvalidPointException {
        Optional<Point> actualResult = logicalBiohaver.checkDiagonalFinish(field, Figure.O);
        //   field.setFigure(new Point(1, 1), myFigure);
        field.setFigure(new Point(0, 0), myFigure);
        boolean expectedResult = true;
        boolean actual = actualResult.isEmpty();
        assertEquals(true, actual);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 0), Figure.O);
        actualResult = logicalBiohaver.checkDiagonalFinish(field, Figure.O);
        int X = (int) actualResult.get().getX();
        int Y = (int) actualResult.get().getY();
        int expectedX = 0;
        int expectedY = 2;
        assertEquals(expectedX, X);
        assertEquals(expectedY, Y);
    }

    @Test
    void checkLineFinish() throws InvalidPointException {
        field.setFigure(new Point(0, 0), myFigure);
        field.setFigure(new Point(1, 0), myFigure);
        field.setFigure(new Point(2, 0), Figure.O);
        field.setFigure(new Point(0, 2), Figure.O);
        field.setFigure(new Point(1, 1), myFigure);
        Optional<Point> actualResult = logicalBiohaver.checkLineFinish(field, myFigure);
        int X = (int) actualResult.get().getX();
        int Y = (int) actualResult.get().getY();
        int expectedX = 1;
        int expectedY = 2;
        assertEquals(expectedX, X);
        assertEquals(expectedY, Y);
    }

    @Test
    void checkLineFinishEnather() throws InvalidPointException {
        field.setFigure(new Point(0, 1), myFigure);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 0), myFigure);
        field.setFigure(new Point(1, 2), Figure.O);
        field.setFigure(new Point(1, 1), myFigure);
        field.setFigure(new Point(2, 0), Figure.O);
        Optional<Point> actualResult = logicalBiohaver.checkLineFinish(field, myFigure);
        int X = (int) actualResult.get().getX();
        int Y = (int) actualResult.get().getY();
        int expectedX = 2;
        int expectedY = 1;
        assertEquals(expectedX, X);
        assertEquals(expectedY, Y);

    }

    @Test
    void getRandomExeption() throws InvalidPointException {
        Point result = logicalBiohaver.getRandomCordinate();
        int X = (int) result.getX();
        int Y = (int) result.getY();
        System.err.println(X);
        System.err.println(Y);
        Point compareException = new Point(0, 0);
        Point compareExceptionTwo = new Point(2, 0);
        Point threeException = new Point(1, 1);
        assertEquals(true, (compareException != result));
        assertEquals(true, (compareExceptionTwo != result));
        assertEquals(true, (threeException != result));
    }

    @Test
    void getPrioritetAttakElseDeffendElseNull() throws InvalidPointException {
        field.setFigure(new Point(0, 1), myFigure);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 0), myFigure);
        Optional<Point> result = logicalBiohaver.getPrioritetAttakElseDeffendElseEmpty();
        assertEquals(true, result.isEmpty());

    }

    @Test
    void getDeffend() throws InvalidPointException {
        field.setFigure(new Point(0, 0), myFigure);
        field.setFigure(new Point(2, 0), Figure.O);
        field.setFigure(new Point(1, 0), myFigure);
        field.setFigure(new Point(2, 1), Figure.O);
        Optional<Point> result = logicalBiohaver.getPrioritetAttakElseDeffendElseEmpty();
        Point actalResult = result.get();
        Point expected = new Point(2, 2);
        assertEquals(expected, actalResult);

    }

    @Test
    void stepPointIfMyFirst() throws InvalidPointException {
        Point actualResult = logicalBiohaver.stepPointIfMyFirst();
        Point expected = new Point(1, 1);
        assertEquals(expected, actualResult);
        field.setFigure(new Point(0, 0), myFigure);
        field.setFigure(new Point(1, 1), Figure.O);
        actualResult = logicalBiohaver.stepPointIfMyFirst();
        expected = new Point(2, 0);
        assertEquals(expected, actualResult);
    }

    @Test
    void stepPointIfMyFirstAndHaveAttack() throws InvalidPointException {
        field.setFigure(new Point(1, 1), myFigure);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(2, 0), myFigure);
        field.setFigure(new Point(1, 2), Figure.O);
        Point actualResult = logicalBiohaver.stepPointIfMyFirst();
        Point expected = new Point(0, 2);
        assertEquals(expected, actualResult);
    }

    @Test
    void stepPointIfMyFirstNoAttack() throws InvalidPointException {
        field.setFigure(new Point(1, 1), myFigure);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(2, 0), myFigure);
        field.setFigure(new Point(0, 2), Figure.O);
        field.setFigure(new Point(0, 1), myFigure);
        field.setFigure(new Point(2, 1), Figure.O);
        Point actualResult = logicalBiohaver.stepPointIfMyFirst();
        System.err.println(actualResult);
    }

    @Test
    void stepPointIfMySecond() throws InvalidPointException {
        field.setFigure(new Point(0, 0), Figure.O);
        Point actualResult = logicalBiohaver.stepPointIfMySecond();
        Point expected = new Point(1, 1);
        assertEquals(expected, actualResult);
        field.setFigure(new Point(1, 1), myFigure);
        field.setFigure(new Point(2, 0), Figure.O);
        actualResult = logicalBiohaver.stepPointIfMySecond();
        assertEquals(new Point(1, 0), actualResult);
    }
    @Test
    void stepPointIfMySecondOtherVariant() throws InvalidPointException {
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 1), myFigure);
        field.setFigure(new Point(2, 2), Figure.O);
        Point expected = new Point(2, 0);
        Point actualResult = logicalBiohaver.stepPointIfMySecond();
        assertEquals(expected, actualResult);
    }

}