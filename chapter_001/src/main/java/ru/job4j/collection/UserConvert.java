package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvert {

    /**
     * @ param List</User> field
     */
    List<User> listUser = new ArrayList<>();

    /**
     * @ param map</Integer, User>field for userList
     */

    HashMap<Integer, User> usersList;

    /**
     * @ param User user
     */
    User user;

    /**
     * method for convert List<User> to HashMap list.
     *
     * @param list<User>
     * @return the userList
     */
    HashMap<Integer, User> process(List<User> list) {
        this.listUser = list;
        HashMap<Integer, User> userList = new HashMap<>();
        for (User user : listUser) {
            userList.put(user.getId(), user);
        }
        return userList;
    }

    @Override
    public String toString() {
        return "UserConvert{"
                +
                "listUser="
                +
                listUser
                +
                ", usersList="
                +
                usersList
                +
                ", user="
                +
                user
                +
                '}';
    }

    public static void main(String[] args) {
        UserConvert forConvertUser = new UserConvert();
        forConvertUser.listUser.add(new User(0, "Ivan", "Moscow"));
        forConvertUser.listUser.add(new User(1, "Liza", "Moscow"));
        forConvertUser.listUser.add(new User(2, "Robert", "Norilsk"));
        forConvertUser.listUser.add(new User(3, "Yana", "Tula"));
        forConvertUser.process(forConvertUser.listUser);
        forConvertUser.usersList = forConvertUser.process(forConvertUser.listUser);
        System.out.print(forConvertUser.usersList);

    }
}

