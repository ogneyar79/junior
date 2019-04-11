package ru.job4j.bank;

public class Account {

    private double value;

    private String requisites;
    boolean info;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
        info = true;
    }


    public boolean chekSum(double sum) {
        return this.getValue() >= sum && this.getValue() > 0 ? true : false;
    }

    public void makeTransfer(Account strAccount, Account destAccount, double sum) {
        boolean succes;
        succes = strAccount.chekSum(sum);
        if (succes) {
            strAccount.value = strAccount.getValue() - sum;
            destAccount.value = destAccount.getValue() + sum;
        }
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) {
            return false;
        }
        return requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + requisites.hashCode();
        return result;
    }
}
