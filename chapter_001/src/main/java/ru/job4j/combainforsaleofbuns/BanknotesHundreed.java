package ru.job4j.combainforsaleofbuns;

/**
 * класс banknotes100 conteiner for keeping bankonote by nominal 100.
 *
 * @author Sirotkin.
 */
public class BanknotesHundreed implements ICoins {

    /**
     * @ param field for name string.
     */
    private final String name = "cash_100";

    /**
     * @ param int for quantity banknotes.
     */
    private int balanceMonets;

    /**
     * @ param int that show max sum money.
     */
    private final int maxCash = 6000;

    private final int maxQuantity = 60;

    /**
     * @ param int that show sum money.
     */
    private int cashBalance;

    private final int nominal = 100;

    private int difference = maxQuantity - balanceMonets;

    private int differenceCashBalance = maxCash - cashBalance;


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
    public BanknotesHundreed(int balanceMonets, int change) {
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

    public int getBalanceMonets() {
        return balanceMonets;
    }

    public int getDifference() {
        return difference;
    }

    @Override
    public int getDifferenceCashBalance() {
        return differenceCashBalance;
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
        System.out.print("Yout balance" + cashBalance + "Notes");
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void setCashBalance(int cashBalance) {
        this.cashBalance = cashBalance;
    }
}



