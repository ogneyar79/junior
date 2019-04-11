package ru.job4j.collection.statistickollection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InfoWithHashMapTest {
    InfoWithHashMap infoObject;
    List<Store.User> previoues;
    List<Store.User> current;
    List<String> listInfo;

    @Before
    public void setUp() throws Exception {
        infoObject = new InfoWithHashMap();
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
        listInfo = new ArrayList<>();
    }

    @Test
    public void changedAndDeletedElments() throws Exception {
        listInfo = infoObject.changedAndDeletedElments(previoues, current);
        assertThat(listInfo.size(), is(4));
        for (String listInfo : listInfo) {
            System.out.println(listInfo);
        }

        assertThat(infoObject.getTheCompareMap().size(), is(1));
    }

    @Test
    public void infoChangeOfcollectiont() throws Exception {
        for (List<String> list : infoObject.infoChangeOfcollectiont(previoues, current)) {
            for (String s : list) {
                System.out.println(s);
            }
        }
        assertThat(infoObject.getTheCompareMap().size(), is(1));
    }

}