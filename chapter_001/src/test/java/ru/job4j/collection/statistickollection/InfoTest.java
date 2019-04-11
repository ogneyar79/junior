package ru.job4j.collection.statistickollection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InfoTest {

    List<Store.User> previoues;
    List<Store.User> current;
    Info infoObject;

    @Before
    public void setUp() throws Exception {
        infoObject = new Info();
        previoues = new ArrayList<>();
        current = new ArrayList<>();
        previoues.add(new Store.User(0001, "Vasilio"));
        previoues.add(new Store.User(0002, "Maksimus"));
        previoues.add(new Store.User(0003, "Olya"));
        previoues.add(new Store.User(0004, " Karina"));
        current.addAll(previoues);
        current.add(new Store.User(0005, " Matvey"));
        current.remove(0);

    }

    @Test
    public void makeInfoAboutAddadedElements() throws Exception {
        infoObject.makeInfoAboutAddadedElements(previoues, current);
        System.out.println(infoObject.getListInfo().get(0));
        System.out.println(infoObject.getListInfo().get(1));
        assertThat(infoObject.getListInfo().size(), is(2));
    }

    @Test
    public void showChangedElement() throws Exception {
        current.set(3, new Store.User(0004, "Tor"));
        current.get(2).setName("V");
        infoObject.showChangedElement(previoues, current);
        System.out.println(previoues.get(0).id);
        System.out.println(previoues.get(0).name);
        System.out.println(previoues.get(1).id);
        System.out.println(previoues.get(1).name);
        System.out.println(previoues.get(2).id);
        System.out.println(previoues.get(2).name);
        System.out.println(previoues.get(3).id);
        System.out.println(previoues.get(3).name);
        System.out.println("Curent");
        System.out.println(current.get(0).id);
        System.out.println(current.get(0).name);
        System.out.println(current.get(1).id);
        System.out.println(current.get(1).name);
        System.out.println(current.get(2).id);
        System.out.println(current.get(2).name);
        System.out.println(current.get(3).id);
        System.out.println(current.get(3).name);
        for (String s : infoObject.getListInfo()) {
            System.out.println(s);
        }

    }
}