package ru.job4j.combainforsaleofbuns;

public abstract class Tarts {

    String name;

    int quantityTarts;

    public Tarts(String name, int quantityTarts) {
        this.name = name;
        this.quantityTarts = quantityTarts;
    }

    public int getQuantityBuns() {
        return quantityTarts;
    }

    public String getName;

    public abstract int getPrice();

    public abstract void setQuantityBuns(int quantityBuns);

}

