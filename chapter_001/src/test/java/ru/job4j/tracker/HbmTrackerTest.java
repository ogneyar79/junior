package ru.job4j.tracker;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HbmTrackerTest {

    @org.junit.jupiter.api.Test
    void add() {
        ItemS itemS = new ItemS("TestName");
        itemS.setDescription("First Test");
        HbmTrackerT hbmTT = new HbmTrackerT();
        ItemS checked = hbmTT.add(itemS);
        assertEquals(new ItemS(1, "TestName", "First Test"), checked);
    }

    @org.junit.jupiter.api.Test
    void replace() {
        ItemS itemS = new ItemS("TestName");
        itemS.setDescription("Second Test");
        HbmTrackerT hbmTT = new HbmTrackerT();
        ItemS checked = hbmTT.add(itemS);
        checked.setDescription("Replaced");
        checked.setName("Test");
        hbmTT.replace(checked);

        assertEquals(checked, hbmTT.findById(checked.getId()));
    }

    @org.junit.jupiter.api.Test
    void delete() {
        ItemS itemS = new ItemS("TestName");
        itemS.setDescription("Third Test");
        HbmTrackerT hbmTT = new HbmTrackerT();
        hbmTT.add(itemS);
        hbmTT.delete(1);

        assertEquals(new ItemS("Ziro"), hbmTT.findById(1));
    }

    @org.junit.jupiter.api.Test
    void findAll() {
        HbmTrackerT hbm = new HbmTrackerT();
        hbm.add(new ItemS("TestUno"));
        hbm.add(new ItemS("TestDos"));
        List<ItemS> list = hbm.findAll();
        assertEquals(2, list.size());
    }

    @org.junit.jupiter.api.Test
    void findByName() {
        ItemS itemS = new ItemS("TestName");
        itemS.setDescription("Fourth Test");
        HbmTrackerT hbmT = new HbmTrackerT();
        ItemS checked = hbmT.add(itemS);
        assertEquals(checked, hbmT.findByName(itemS.getName()).get(0));
    }

}