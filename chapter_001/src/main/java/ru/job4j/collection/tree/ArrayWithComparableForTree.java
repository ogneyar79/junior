package ru.job4j.collection.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayWithComparableForTree<V> implements Comparable<ArrayWithComparableForTree>, Iterable<ArrayWithComparableForTree> {

    private ArrayList<V> arrayList;
    V[] forArays;

    @Override
    public int compareTo(ArrayWithComparableForTree o) {
        int result = this.arrayList.size() - o.getArrayList().size();

        return result != 0 ? result : 0;
    }

    @Override
    public Iterator<ArrayWithComparableForTree> iterator() {
        return this.getArrayList().iterator();
    }

    public ArrayList getArrayList() {

        return arrayList;
    }

    public ArrayWithComparableForTree(V[] forArays) {
        this.arrayList = new ArrayList<>();
        Collections.addAll(arrayList, forArays);
    }
}
