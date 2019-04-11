package ru.job4j.multithereading.threads.bomberman.bombermanmodel;

public class PlayerUno extends Figure {

    boolean bomb;

    /**
     * конструктор фигуры игрока
     *
     * @param name,   фигуры, которая ходит.
     * @param color,  Фигуры, которая ходит.
     * @param myPlace клетка занимаемая Фигурой, которая ходит.
     */
    public PlayerUno(final String name, String color, Cell myPlace) {
        super(name, color, myPlace);
        bomb = true;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Cell getMyPlace() {
        return myPlace;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setMyPlace(Cell myPlace) {
        this.myPlace = myPlace;
    }


}
