package ru.job4j.multithereading.threads.bomberman.bombermanmodel;

public class Wall extends Figure {

    public Wall(String name, String color, Cell myPlace) {
        super(name, color, myPlace);
        myPlace.getCellLock().lock();
    }
}
