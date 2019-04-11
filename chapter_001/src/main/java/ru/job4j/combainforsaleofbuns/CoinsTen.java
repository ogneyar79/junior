package ru.job4j.combainforsaleofbuns;

/**
 * класс CoinsTen for and realisation geting and keeping coins.
 *
 * @author Sirotkin.
 */
public abstract class CoinsTen implements ICoins {

    /**
     * @ param field for name string.
     */
    private final String name = "Coin_10";


    String yourChange;

    private int change;

    private int quantity;

    /**
     * @ param int field for max monets.
     */
    private final int maxQuantity = 250;

    /**
     * @ param int for quantity monets.
     */
    private int balanceMonets;

    private int cashBalance = balanceMonets * 10;


    /**
     * @ param int that show remaining place for monets.
     */
    private int difference = maxQuantity - balanceMonets;


    public CoinsTen(int balanceMonets) {
        this.balanceMonets = 250;
    }

    public CoinsTen(int i, int i1) {
    }


    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public int getBalanceMonets() {
        return balanceMonets;
    }

    public int getDifference() {
        return difference;
    }


    public void giveChange() {
        System.out.println(" Your change =" + " " + change);
    }

    /**
     * method for download coins to stock.
     *
     * @return balanceMonets
     */
    public int putMoney(int quantity) {
        int temporraryBank = quantity;

        if (quantity > difference) {
            change = quantity - difference;
            giveChange();
            temporraryBank = difference;
            balanceMonets = temporraryBank + balanceMonets;
        } else {
            balanceMonets = quantity + balanceMonets;

        }
        return balanceMonets;
    }

    public void giveChange(int quantity) {
        change = quantity;
        giveChange();

    }

    public void info() {
        System.out.print("You can load" + difference + "10 coins");
    }


}
