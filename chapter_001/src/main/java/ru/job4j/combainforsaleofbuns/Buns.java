package ru.job4j.combainforsaleofbuns;

/**
 * класс Buns contieier for keepeing kind of tarts, Bans.
 *
 * @author Sirotkin.
 *
 */
public class Buns extends Tarts {

  private final String name = "buns";

    private int quantityBuns;

    private final int price = 30;

    private final int maxQuantityBuns = 3000;

    public Buns(String name, int quantityTarts, int price) {
        super(name, quantityTarts);
        name = name;
        this.quantityBuns = quantityTarts;
        price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantityBuns() {
        return quantityBuns;
    }

    public int getPrice() {
        return price;
    }

    public void setQuantityBuns(int quantityBuns) {
        this.quantityBuns = quantityBuns;
    }
}
