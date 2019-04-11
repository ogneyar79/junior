package ru.job4j.collection.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TreeTest {


    Node<Integer> rootNode = new Node<>(0);

    Tree<Integer> treeObgect = new Tree<>(rootNode);


    @Before
    public void setUp() throws Exception {

        treeObgect.add(0, 1);
        treeObgect.add(0, 2);

    }

    @Test
    public void add() throws Exception {
        Iterator treeIterrator = treeObgect.iterator();
        assertThat(treeIterrator.next(), is(0));
        assertThat(treeIterrator.next(), is(1));
    }

    @Test
    public void addWithDoublicate() throws Exception {
        assertThat(treeObgect.add(0, 0), is(false));
    }

    @Test
    public void findBy() throws Exception {
        Optional<Node<Integer>> rsl = treeObgect.findBy(2);
        Node<Integer> result = rsl.get();

        assertThat(result.getValue(), is(2));
    }

    @Test
    public void when6ElFindLastThen6() {
        Node<Integer> nodeRootR = new Node<>(1);
        Tree<Integer> tree = new Tree<Integer>(nodeRootR);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }
}