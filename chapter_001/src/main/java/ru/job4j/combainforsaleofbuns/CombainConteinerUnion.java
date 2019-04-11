package ru.job4j.combainforsaleofbuns;

/**
 * класс CombainConteinerUnion handle with orders in our combain Bans.
 *
 * @author Sirotkin.
 */
public class CombainConteinerUnion {

    /**
     * @ param field quantity int for different int meaning.
     */
    int quantity;

    /**
     * @ param field change int meaning.
     */
    int change;

    /**
     * @ param field coins Icoins interface[], show different tipe 0f coins and banknotes.
     */
    ICoins[] coins = new ICoins[6];

    /**
     * @ param field coins Tarts abstract class[], show different tipe 0f tarts.
     */
    Tarts[] tarts = new Tarts[1];

    /**
     * @ param field coins Icoins interface[], show different tipe 0f coins and banknotes that used for pay moneq back(change).
     */
    ICoins[] changeCoins = new ICoins[6];

    /**
     * method for creaction CombainConteinerUnion object.
     *
     * @param coins       Icoins[]
     * @param tarts       Tarts[]interface
     * @param changeCoins ICoins[]
     */
    public CombainConteinerUnion(ICoins[] coins, Tarts[] tarts, ICoins[] changeCoins) {
        this.coins = coins;
        this.tarts = tarts;
        this.changeCoins = changeCoins;
    }

    /**
     * method for fill Tarts[] interface conteiner by new Buns.
     *
     * @return the tarts[]
     */
    public Tarts[] fillConteiner() {
        this.tarts[0] = new Buns("TestedBuns", 300, 30);
        return tarts;
    }

    /**
     * method for fill Tarts[] interface conteiner by new Buns.
     */
    public void fillTarts() {
        tarts[0] = new Buns(" Buns", 200, 30);
    }

    /**
     * method for fill coins[] conteiner.
     *
     * @return the coins[]
     */
    public ICoins[] fillICoins(ICoins[] coins) {
        coins[0] = new BanknotesHundreed(0, 0);
        coins[1] = new BanknotesFifthy(0, 0);
        coins[2] = new CoinsTen(0, 0) {
            @Override
            public int getCashBalance() {
                return 0;
            }

            @Override
            public int getNominal() {
                return 0;
            }

            @Override
            public int getDifferenceCashBalance() {
                return 0;
            }

            @Override
            public int getChange() {
                return 0;
            }

            @Override
            public void setChange(int change) {

            }

            @Override
            public void setCashBalance(int cashBalance) {

            }

            @Override
            public int getMaxCash() {
                return 0;
            }
        };
        coins[3] = new CoinsFive(0, 0);
        coins[4] = new CoinsTwo(0, 0);
        coins[5] = new CoinsOne(0, 0);

        return coins;
    }

    /**
     * method for fill(put) max money to conteiner.
     * put money metod fill by moneq, here we get cashBalance max
     *
     * @return the coins
     */
    public ICoins[] putMoney() {
        for (int i = 0; i < coins.length; i++) {
            this.coins[i].putMoney(this.coins[i].getMaxCash());
        }
        return coins;
    }

    public Tarts[] getTarts() {
        return tarts;
    }


    /**
     * method for giving bancnonte different nominal from our conteinter for change.
     *
     * @param quantity int = change(pay money back) that conteiner pay back
     *                 and giving change
     *                 here we creat array for hand there change from our array coins
     * @return the changeCoins
     */
    public ICoins[] optimusChange(int quantity) {
        changeCoins = new ICoins[coins.length];

        for (int i = 0; i < coins.length; i++) {

            if (quantity % coins[i].getNominal() != 0 && coins[i].getCashBalance() != 0) {
                double rest = quantity % coins[i].getNominal();   // 470/100=0.70
                double multyRest = rest * coins[i].getNominal();  // 0.70*100=70
                double withoutRestMax = quantity - multyRest;     // 470 -70=400
                if (withoutRestMax > coins[i].getCashBalance()) {   // если сумма целочисленной сдачи больше наличия купюр в контейнере напрмпре нужно дать 400 а там 200


                    quantity = quantity - coins[i].getCashBalance();
                    coins[i].putMoney(-(coins[i].getCashBalance()));

                    coins[i].setChange(coins[i].getCashBalance());       //chahnge =
                    coins[i].info();
                } else {                                         // если денег на целочисленную сдачу в контейнере хватает
                    coins[i].putMoney((int) -withoutRestMax);
                    coins[i].setChange((int) -withoutRestMax);
                    quantity = (int) multyRest;
                }     // = 70
            } else if (coins[i].getCashBalance() == 0) {
                coins[i].info();
                continue;
            } else {
                coins[i].putMoney(-quantity);
                coins[i].setChange(quantity);
                break;
            }
        }

        for (int j = 0; j < changeCoins.length; j++) {
            changeCoins[j].setCashBalance(coins[j].getChange());
            coins[j].setChange(0);
        }
        return changeCoins;
    }

    /**
     * method for fill give some kind of tarts to client from our conteiner.
     * change quantity tarts if buying
     *
     * @return the tarts[]
     */
    public Tarts[] giveTarts(String name, int quantity) {
        for (int i = 0; i < tarts.length; i++) {
            if (tarts[i].getName.equals(name)) {
                tarts[i].quantityTarts = this.tarts[i].getQuantityBuns() - quantity;

            }
        }
        System.out.println(" Your" + name + quantity);
        return tarts;
    }

    /**
     * method for buy tarts from out conteinre.
     *
     * @param money     Icoins[]
     * @param nameTarts String
     * @param quantity  int, that quantity tarts we'll to wont to buy
     * @return the tarts[] that we will have baying
     * in this mithod we use other metods(chekPreceQuantity)
     */
    public Tarts buyTarts(ICoins[] money, String nameTarts, int quantity) {
        Tarts tartsTemp = new Buns("buns", 0, 30);
        Tarts tartS = new Buns(" buns", quantity, 30);
        boolean yes;
        yes = chekPriceQuantity(money, nameTarts, quantity);
        if (yes) {
            for (int i = 0; i < tarts.length; i++) {
                if (tarts[i].getName.equals(nameTarts) && tarts[i].getQuantityBuns() >= quantity) {
                    giveTarts(nameTarts, quantity);
                    tartsTemp = tartS;


                } else {
                    System.out.println(" We don't have buns for you");
                    tartS.setQuantityBuns(0);
                }
            }
        }
        return tartsTemp;
    }

    /**
     * method count all money at out conteiner Icoins[].
     *
     * @return the cash
     */
    public int cashCount(ICoins[] money) {
        int cash = 0;
        for (int i = 0; i < money.length; i++) {
            cash = money[i].getCashBalance() + cash;

        }
        return cash;
    }

    /**
     * method for chec that we have enough tarts for sale acording to order and that customer have enough money .
     * and here give change use another method optimusChnge
     *
     * @return the yes bolean
     */
    public boolean chekPriceQuantity(ICoins[] money, String nameTarts, int quantity) {
        boolean yes = false;
        money = money;
        int change;
        int cash = cashCount(money);
        for (int i = 0; i < tarts.length; i++) {
            if (tarts[i].getName.equals(nameTarts) && cash == quantity * tarts[i].getPrice()) {
                yes = true;
            } else if (tarts[i].getName.equals(nameTarts) && cash > quantity * tarts[i].getPrice()) {

                cash = cashCount(money);   // расчитаем нашу наличность для покупки
                change = cash - quantity * tarts[i].getPrice();   // расчитаем сдачи
                optimusChange(change);   // выдаём сдачи
                yes = true;
            } else {
                yes = false;
                System.out.println(" You no hava enough money, You need" + (quantity * tarts[i].getPrice() - cash));
            }

        }
        return yes;
    }


    public static void main(String[] args) {
        ICoins[] coins = new ICoins[6];

        Tarts[] tarts = new Tarts[1];
        ICoins[] changeCoins = new ICoins[6];

        CombainConteinerUnion conteiner = new CombainConteinerUnion(coins, tarts, changeCoins);
        conteiner.fillICoins(coins);
        conteiner.fillICoins(changeCoins);
        conteiner.fillTarts();
    }
}






