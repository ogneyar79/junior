package tictactoe.view.reader;

import tictactoe.model.exeption.InvalidFigureWriting;
import tictactoe.model.exeption.InvalidPointException;

import java.awt.*;

public interface IInputCoordinate {
    public Point inputPoint() throws InvalidFigureWriting, InvalidPointException;


}
