package ru.job4j.collection;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserConvertTestTest {


    /**
     * we test method convert list of User to HashMap.
     */
    @Test
    public void whenConvertListUserToHashMap() {
        UserConvert forConvertUser = new UserConvert();
        List<User> listUser = new ArrayList<>();
        List<User> expected = new ArrayList<>();
        HashMap<Integer, User> expectedd = new HashMap<>();


        listUser.add(new User(0, "Ivan", "Moscow"));
        listUser.add(new User(1, "Liza", "Moscow"));
        listUser.add(new User(2, "Robert", "Norilsk"));
        listUser.add(new User(3, "Yana", "Tula"));
        expected = listUser;
        expectedd.put(((listUser.get(0)).getId()), (listUser.get(0)));
        expectedd.put(((listUser.get(1)).getId()), (listUser.get(1)));
        expectedd.put(((listUser.get(2)).getId()), (listUser.get(2)));
        expectedd.put(((listUser.get(3)).getId()), (listUser.get(3)));

        forConvertUser.process(listUser);
        Map<Integer, User> result = forConvertUser.process(listUser);
        System.out.print(forConvertUser.usersList);
        assertThat(result.get(0), is(expected.get(0)));
        assertThat(result, is(expectedd));
    }


}