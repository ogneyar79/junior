package ru.job4j.multithereading.threads.userstore;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@ThreadSafe
public class UserStorage {

    @GuardedBy("this")
    private final List<User> users = new ArrayList<>();


    /**
     * Добавление юзера в хранилище.
     *
     * @param user добавляемый в хранишлище объект.
     * @return boolean true если есть успешно добавлии.
     */
    public synchronized boolean add(User user) {
        boolean result;
        if (users.contains(user)) {
            result = false;
        } else {
            users.add(user);
            result = true;
        }
        return result;
    }

    /**
     * Удаление юзера из хранилища.
     *
     * @param user удаляемый из хранишлище объект.
     * @return boolean true если есть успешно добавлии.
     */
    public synchronized boolean remove(User user) {
        boolean result = false;
        if (users.contains(user)) {
            users.remove(user);
            result = true;
        }
        return result;
    }

    /**
     * замена юзера с одинаковым id на другой объект User user.
     *
     * @param user объект с изменненными данными, который вносим в хранилище на замену дргому.
     * @return boolean true если замена прошла успшно.
     */
    public synchronized boolean update(User user) {
        boolean result = false;
        for (ListIterator<User> it = users.listIterator(); it.hasNext();) {
            User user1 = it.next();
            if (user1.getId() == user.getId()) {
                it.set(user);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Поиск User объекта по id.
     *
     * @param id по которому ведется поиск возвращаемого объекта.
     * @return User если есть иначе null.
     */
    private synchronized User findById(int id) {
        User resultUser = null;
        for (User user : this.users) {
            int userId = user.getId();
            if (userId == id) {
                resultUser = user;
                break;
            }
        }
        return resultUser;
    }

    /**
     * Поиск User объекта по id.
     *
     * @param id по которому ведется поиск объекта.
     * @return boolean true если есть объект с данным id иначе false.
     */
    private synchronized boolean checkById(int id) {
        boolean result = false;
        for (User user : this.users) {
            int userId = user.getId();
            if (userId == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Осуществляет перевод денег с одного счета на дргоуй.
     *
     * @param fromId откуда перечисляем деньги.
     * @param toId   куда переводим деньги
     * @param amount сумма денег.
     * @return boolean true если есть перевод осуществлён.
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        User fromUser;
        User toUser = null;
        boolean result = false;
        if (this.checkById(toId)) {
            toUser = this.findById(toId);
        } else {
            System.out.println(" No Have such user toId" + toId);
            result = false;
        }
        if (this.checkById(fromId) && checkById(toId)) {
            fromUser = this.findById(fromId);
            if (fromUser.checkSufisientSum(fromId)) {
                fromUser.setAmount(fromUser.getAmount() - amount);
                toUser.setAmount(toUser.getAmount() + amount);
                System.out.println(" Successful toId = " + toUser.getAmount());
                result = true;
            }
        } else {
            System.out.println(" No Have such user fromId" + fromId);
            result = false;
        }

        return result;
    }
}
