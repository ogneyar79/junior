package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

/**
 * We test different method for testing class Tracker.
 *  @author Sirotkin
 *  @since  10.09.2017
 */
public class TrackerTest {


    /**
     * we test method add new Item.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1",  "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    /**
     * we test method add new Item.
     */
    @Test
    public void whenFindByIdReturnItem() {
        Tracker tracker1 = new Tracker();
        Item item1 = new Item("test1", "testDescription2", 123L);
        tracker1.add(item1);
        tracker1.findById(item1.getId());
        System.out.println(item1.getId());
        assertThat(tracker1.getAll().get(0), is(item1));
    }

    /**
     * we test method add new Item.
     */
    @Test
    public void whenUpdateChangedItemOnItem() {
        Tracker tracker2 = new Tracker();
        Item item2 = new Item("Test3", "TestDescription3", 123L);
        tracker2.add(item2);
        Item item3 = new Item("T4", "TD4", 123L);
        item3.setId(item2.getId());
        tracker2.update(item3);
        assertThat(tracker2.getAll().get(0), is(item3));
    }

    /**
     * we test method add new Item.
     */
    @Test
    public void whenDeleteChangedForNull() {
        Tracker tracker4 = new Tracker();
        Item item6 = new Item("B", "TD", 123L);
        tracker4.add(item6);
        Item item4 = new Item("T5", "TD5", 123L);
        tracker4.add(item4);
        tracker4.delete(item6);
        assertThat(tracker4.getAll().get(0), is(item4));
    }

    /**
     * we test method add new Item.
     */
    @Test
    public void whenFindByNameStringKey() {

        Tracker tracker7 = new Tracker();

        Item item7 = new Item("bob", " Bob,bob", 123L);
        tracker7.add(item7);
        tracker7.findByName(item7.getName());
        assertThat(tracker7.getAll().get(0), is(tracker7.findByName(item7.getName()).get(0)));
    }

     }

