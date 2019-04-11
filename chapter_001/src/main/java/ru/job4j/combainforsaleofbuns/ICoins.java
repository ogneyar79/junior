package ru.job4j.combainforsaleofbuns;

public interface ICoins {


    void info();

    int putMoney(int quantity);

    void giveChange(int quantity);

    int getMaxQuantity();

    int getCashBalance();

    int getNominal();

    int getDifferenceCashBalance();

    int getChange();

    void setChange(int change);

    public void setCashBalance(int cashBalance);

    int getMaxCash();

}