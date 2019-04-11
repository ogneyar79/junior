package ru.job4j.collection.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TreeTestNumberTwoWithFindDoubleAndBinaryOrNot {
    Node<Integer> rootNodeTwo = new Node<>(0);

    Tree<Integer> treeObgectTwo = new Tree<>(rootNodeTwo);

    @Before
    public void setUp() throws Exception {
        treeObgectTwo.add(0, 0);
    }

    @Test
    public void checkNoDoblicateByAddAtChilds() {
        assertThat(treeObgectTwo.add(0, 0), is(false));

    }

    @Test
    public void findDoublicutBy() throws Exception {
        assertThat(treeObgectTwo.findDoublicutBy(0), is(true));
        assertThat(treeObgectTwo.findDoublicutBy(2), is(false));
    }

    @Test
    public void isBinary() throws Exception {
        treeObgectTwo.add(0, 1);
        treeObgectTwo.add(0, 2);
        assertThat(treeObgectTwo.isBinary(), is(false));
    }

}