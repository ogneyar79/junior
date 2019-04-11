package ru.job4j.combainforsaleofbuns;

/**
 * класс Banknotes_50 conteiner for keeping bankonote by nominal 50.
 *
 * @author Sirotkin.
 */
public class BanknotesFifthy implements ICoins {

    /**
     * @ param field for name string.
     */
    private final String name = "cash_50";

    /**
     * @ param int for quantity banknotes.
     */
    private int balanceMonets;

    /**
     * @ param int that show sum money.
     */
    private int cashBalance;


    private final int maxQuantity = 100;

    /**
     * @ param int that show max sum money.
     */
    private final int maxCash = 5000;

    /**
     * @ param int that How one bankonotes is.
     */
    private final int nominal = 50;

    private int difference = maxQuantity - balanceMonets;

    private int differenceCashBalance = maxCash - cashBalance;


    @Override

    public int getMaxQuantity() {
        return maxQuantity;
    }


    private int change;

    /**
     * @ param int that show.
     */
    private int quantity;

    /**
     * method for creaction Coinx_10 object.
     *
     * @param balanceMonets int
     */
    public BanknotesFifthy(int balanceMonets, int change) {
        this.balanceMonets = balanceMonets;
        this.cashBalance = balanceMonets * 50;
        this.change = change;
    }


    public String getName() {
        return name;
    }

    public int getCashBalance() {
        return cashBalance;
    }

    public int getMaxCash() {
        return maxCash;
    }

    public int getDifferenceCashBalance() {
        return differenceCashBalance;
    }

    public int getBalanceMonets() {
        return balanceMonets;
    }

    public int getDifference() {
        return difference;
    }

    public int getNominal() {
        return nominal;
    }

    public int getChange() {
        return change;
    }

    /**
     * method for download banknots to stock.
     *
     * @return cashBalance
     */
    public int putMoney(int quantity) {
        int temporraryBank = quantity;

        if (quantity > difference) {
            change = quantity - differenceCashBalance;
            giveChange(change);
            temporraryBank = differenceCashBalance;
            cashBalance = temporraryBank + cashBalance;
            temporraryBank = 0;
        } else {
            cashBalance = quantity + cashBalance;
            temporraryBank = 0;

        }
        info();
        return cashBalance;

    }

    /**
     * method for giving change.
     */
    public void giveChange() {
        System.out.println(" Your change =" + " " + change);
    }

    /**
     * method for hand change.
     */
    public void giveChange(int quantity) {
        change = quantity;
        giveChange();
    }

    public void info() {
        System.out.print("Your balance" + cashBalance + "Notes");
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void setCashBalance(int cashBalance) {
        this.cashBalance = cashBalance;
    }
}
