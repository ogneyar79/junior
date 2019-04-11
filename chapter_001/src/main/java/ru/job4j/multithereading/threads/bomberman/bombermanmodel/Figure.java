package ru.job4j.multithereading.threads.bomberman.bombermanmodel;

/**
 * Базовый класс для создания движущих фигур в игре.
 */
public class Figure {


    final String name;

    final String color;

    Cell myPlace;

    public Figure(String name, String color, Cell myPlace) {
        this.name = name;
        this.color = color;
        this.myPlace = myPlace;

    }

    public void getInformationFigure() {
        Figure figure = this;
        System.out.println(String.format(" Имя Нашей модели %s, его цвет %s, номер его клетки %s, его координата Х равна %s, его координта Y равна %s", figure.getName(), figure.getColor(), figure.getMyPlace().getNumKoord(), figure.getMyPlace().getKoordinateLineX(), figure.getMyPlace().getKoordinateLinecolumneY()));

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


    public void setMyPlace(Cell myPlace) {
        this.myPlace = myPlace;
    }


}
