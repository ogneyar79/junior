package tictactoe.view.reader;

import tictactoe.model.exeption.InvalidFigureWriting;

import java.awt.*;

public interface IInputCoordinate {
    public Point inputPoint() throws InvalidFigureWriting;


}
