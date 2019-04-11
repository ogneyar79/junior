package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankManageWithAccountAndUsers {

    private Map<User, List<Account>> userListMap = new HashMap<>();

    public BankManageWithAccountAndUsers() {
        Map<User, List<Account>> userListMap = new HashMap<>();
    }

    public Map<User, List<Account>> getUserListMap() {
        return userListMap;
    }

    public void addUser(User user) {

        this.userListMap.putIfAbsent(user, user.getUserAccounts());
    }

    public void deleteUser(User user) {
        this.userListMap.remove(user);
    }


    public void addAccountToUser(Pasport passport, Account account) {
        for (User user : this.userListMap.keySet()) {
            if (user.getPasport().equals(passport)) {
                user.getUserAccounts().add(account);
            } else {
                System.out.println(" No user with " + passport);
            }
        }
    }

    public void deleteAccountFromUser(Pasport passport, Account account) {
        for (User user : this.userListMap.keySet()) {
            if (user.getPasport().equals(passport)) {
                user.getUserAccounts();
                for (Account account1 : user.getUserAccounts()) {
                    if (account1.equals(account)) {
                        user.getUserAccounts().remove(account1);
                    } else {
                        System.out.println("No account with" + account);
                    }
                }
            } else {
                System.out.println(" No user with" + passport);
            }
        }

    }

    public List<Account> getUserAccounts(Pasport passport) {
        List<Account> userAccounts = new ArrayList<>();
        for (User user : this.userListMap.keySet()) {
            if (user.getPasport().equals(passport)) {
                user.getUserAccounts();
                userAccounts = user.getUserAccounts();
            } else {
                System.out.println(" No user with passport" + passport);
                userAccounts = null;
            }
        }
        return userAccounts;

    }

    public Account getUserAccount(String requissite, Pasport pasport) {
        Account result = null;
        for (Account account : this.getUserAccounts(pasport)) {
            account.getRequisites();
            if (account.getRequisites().equals(requissite)) {
                result = account;
            } else {
                System.out.println(" No have such account with N" + requissite);
                result = null;
            }
        }
        return result;
    }

    //- метод для перечисления денег с одного счёта на другой счёт: если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.

    public boolean transferMoney(Pasport srcPassport, String srcRequisite, Pasport destPassport, String dstRequisite, double amount) {

        boolean result = false;

        boolean resultUser1 = false;
        boolean resultUser2 = false;
        List<Account> userAccountsFirstUser;
        userAccountsFirstUser = this.getUserAccounts(srcPassport);
        for (User user : this.userListMap.keySet()) {
            if (user.getPasport().equals(srcPassport) && this.getUserAccount(srcRequisite, srcPassport).getRequisites().equals(srcRequisite) && this.getUserAccount(srcRequisite, srcPassport).chekSum(amount)) {
                resultUser1 = true;
            } else {
                resultUser1 = false;
            }
        }
        for (User user : this.userListMap.keySet()) {
            if (user.getPasport().equals(destPassport) && this.getUserAccount(dstRequisite, destPassport).getRequisites().equals(dstRequisite)) {
                resultUser2 = true;
            } else {
                result = false;
            }
        }
        if (resultUser1 && resultUser2) {
            this.getUserAccount(srcRequisite, srcPassport).makeTransfer(this.getUserAccount(srcRequisite, srcPassport), (this.getUserAccount(dstRequisite, destPassport)), amount);
            result = true;

        } else {
            System.out.println(" We can't make this transfer");
            result = false;
        }


        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BankManageWithAccountAndUsers that = (BankManageWithAccountAndUsers) o;

        return userListMap.equals(that.userListMap);
    }

    @Override
    public int hashCode() {
        return userListMap.hashCode();
    }
}




