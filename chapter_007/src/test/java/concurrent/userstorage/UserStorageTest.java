package concurrent.userstorage;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class UserStorageTest {


    UserC userOne;
    UserC userTwo;
    UserStorage storage;
    Set<UserC> userSet;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        userSet = new HashSet<>();
        storage = new UserStorage(userSet);
        userOne = new UserC(1, 1000);
        userTwo = new UserC(2, 500);
    }

    @org.junit.jupiter.api.Test
    void add() {
        storage.add(userOne);

        assertThat(storage.getUserId(1).equals(userOne), is(true));
    }

    @org.junit.jupiter.api.Test
    void update() {

        storage.add(userOne);
        storage.update(new UserC(1, 1111));
        assertThat(storage.getUserId(1).getAmount(), is(1111));
    }

    @org.junit.jupiter.api.Test
    void delete() {
        storage.add(userOne);
        storage.delete(userOne);
        assertThat(storage.getUserId(1).equals(new UserC(0, 0)), is(true));
    }

    @org.junit.jupiter.api.Test
    void transfer() {
        storage.add(userOne);
        storage.add(userTwo);
        storage.transfer(1,2,500);
        assertThat(storage.getUserId(2).getAmount(), is(1000));
    }
}