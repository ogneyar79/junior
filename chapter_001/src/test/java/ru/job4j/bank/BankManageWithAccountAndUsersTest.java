package ru.job4j.bank;


import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BankManageWithAccountAndUsersTest {
    @Test
    public void whenAddToUserToCatalogFromToHashMap() {
        Pasport pasport = new Pasport(12345678, "Robert", "Ivanov");
        User user = new User("Robert", pasport, 1000, "1234567890");
        BankManageWithAccountAndUsers catalogUsersAtHashMap = new BankManageWithAccountAndUsers();
        catalogUsersAtHashMap.addUser(user);

        Pasport pasportExpected = new Pasport(12345678, "Robert", "Ivanov");
        User expected = new User("Robert", pasportExpected, 1000, "1234567890");

        catalogUsersAtHashMap.getUserListMap().containsKey(expected);
        boolean expectedd = true;

        boolean result = catalogUsersAtHashMap.getUserListMap().containsKey(user);


        assertThat(result, is(expectedd));
    }

    @Test
    public void whenDeleteToUserToCatalogFromToHashMap() {
        Pasport pasport1 = new Pasport(12345678, "Robert", "Ivanov");
        User user1 = new User("Robert", pasport1, 1000, "1234567890");
        BankManageWithAccountAndUsers catalogUsersAtHashMap1 = new BankManageWithAccountAndUsers();
        catalogUsersAtHashMap1.addUser(user1);
        catalogUsersAtHashMap1.deleteUser(user1);

        int result = catalogUsersAtHashMap1.getUserListMap().size();
        int excpected = 0;
        assertThat(result, is(excpected));
    }

    @Test
    public void whenAddAccountToUserToCatalogFromToHashMap() {
        Pasport pasport2 = new Pasport(12345678, "Robert", "Ivanov");
        User user2 = new User("Robert", pasport2, 1000, "1234567890");
        BankManageWithAccountAndUsers catalogUsersAtHashMap2 = new BankManageWithAccountAndUsers();
        catalogUsersAtHashMap2.addUser(user2);
        catalogUsersAtHashMap2.addAccountToUser(pasport2, new Account(0, "1234567891"));
        catalogUsersAtHashMap2.getUserListMap();
        Map<User, List<Account>> userListMap = catalogUsersAtHashMap2.getUserListMap();
        userListMap.get(user2);
        List<Account> accountListUser2 = userListMap.get(user2);
        accountListUser2.size();
        int result = accountListUser2.size();
        int excpected = 2;
        assertThat(result, is(excpected));
    }


}
