package ru.job4j.collection.statistickollection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StoreTest {
    List<Store.User> previoues;
    List<Store.User> current;
    Store store;
    List<List<String>> infoObject;

    @Before
    public void setUp() throws Exception {
        previoues = new ArrayList<>();
        current = new ArrayList<>();
        previoues.add(new Store.User(0001, "Vasilio"));
        previoues.add(new Store.User(0002, "Maksimus"));
        previoues.add(new Store.User(0003, "Olya"));
        previoues.add(new Store.User(0004, " Karina"));
        current.add(new Store.User(0001, "Vasilio"));
        current.add(new Store.User(0002, "Maksimus"));
        current.add(new Store.User(0003, " Olga"));
        current.add(new Store.User(0005, " Matvey"));
        store = new Store();
    }

    @Test
    public void diffCheckListStringWithInformationAboutChangesAtcollection() throws Exception {
       infoObject = store.diff(previoues, current);
        for (List<String> list : infoObject) {
            for (String s : list) {
                System.out.println(s);
            }
        }
        assertThat(infoObject.size(), is(2));
    }

}