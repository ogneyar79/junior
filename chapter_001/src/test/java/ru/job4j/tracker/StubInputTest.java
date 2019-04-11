package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;


/**
 * We test different method for testing class StubInput.
 *
 * @author Sirotkin
 * @since 17.09.2017
 */
public class StubInputTest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        String userChoice = "0";
        String name = "test name";
        String description = "desc";
        String exit = "Y";
        List<String> test1 = new ArrayList<>();
        test1.add(userChoice);
        test1.add(name);
        test1.add(description);
        test1.add(exit);
        IInput stubInputad = new StubInput(test1);

        new StartUI(stubInputad, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {

        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test NAME", "deskTest", 123L));
        //создаём StubInput с последовательностью действий
        String userChoice = "2";
        String id = item.getId();
        String name = "test name";
        String description = "desc";
        String exit = "Y";
        List<String> test2 = new ArrayList<>();
        test2.add(userChoice);
        test2.add(id);
        test2.add(name);
        test2.add(description);
        test2.add(exit);
        IInput input = new StubInput(test2);
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test NAME", "deskTest", 123L));
        Item item1 = tracker.add(new Item("ttt", "DDD", 123L));
        String userChoice = "3";
        String id = item.getId();
        String exit = "Y";
        List<String> test3 = new ArrayList<>();
        test3.add(userChoice);
        test3.add(id);
        test3.add(exit);
        IInput input = new StubInput(test3);
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.getAll().get(0), is(item1));
    }

    @Test
    public void whenFindeByNameThenTrackerHasSameNameValue() {

        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test NAME", "deskTest", 123L));
        //создаём StubInput с последовательностью действий
        String userChoice = "5";
        String name = "test NAME";
        String exit = "Y";
        List<String> test4 = new ArrayList<>();
        test4.add(userChoice);
        test4.add(name);
        test4.add(exit);
        IInput input = new StubInput(test4);
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.getAll().get(0).getName(), is("test NAME"));
    }
}

