package ru.job4j.jchess;

/**
 * Created by maksi on 30.10.2017.
 */

public class Cell {

    final int cellX, cellY;
    final int cellOneCoordinate;
    private int color; // white
    private int cellOccupied;

    public Cell(int cellX, int cellY, int cellOneCoordinate, int color) {
        this.cellX = cellX;
        this.cellY = cellY;
        this.cellOneCoordinate = cellOneCoordinate;
        this.color = color;
    }

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public int getCellOneCoordinate() {
        return cellOneCoordinate;
    }

    public int getColor() {
        return color;
    }

    public void setColor(final int color) {

        if (color == 0 || color == 1) {
            this.color = color;
        } else {
            this.color = 0;
        }
    }

    public int getCellOccupied() {
        return cellOccupied;
    }

    public void setCellOccupied(int cellOccupied) {
        if (cellOccupied == 0) {
            this.cellOccupied = cellOccupied;
        } else {
            this.cellOccupied = 1;
        }
    }
}
