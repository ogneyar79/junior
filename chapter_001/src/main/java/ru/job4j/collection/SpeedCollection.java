package ru.job4j.collection;

import java.util.*;

public class SpeedCollection {
    int amount;
    Collection<String> collectionA = new ArrayList<>();
    Collection<String> collectionL = new LinkedList<String>();
    Collection<String> collectionTreeS = new TreeSet<String>();

    public long add(Collection<String> collection, int amount) {
        long timeOut = 0;

        for (int index = 0; index != amount; index++) {
            long timeStart = System.nanoTime();
            collection.add(String.valueOf(index));
            long timeEnd = System.nanoTime();
            long timeResult = timeEnd - timeStart;
            System.out.println(timeResult);
            timeOut = +timeResult;
            System.out.println(timeOut);
        }
        return timeOut;
    }

    public long delete(Collection<String> collection) {
        long timeStart = System.nanoTime();
        collection.remove(0);
        long timeEnd = System.nanoTime();
        long timeResult = timeEnd - timeStart;
        System.out.println(timeResult);
        return timeResult;
    }

    public long delete(LinkedList<String> collection) {
        long timeStart = System.nanoTime();
        collection.removeFirst();
        long timeEnd = System.nanoTime();
        long timeResult = timeEnd - timeStart;
        System.out.println(timeResult);
        return timeResult;
    }

    public long delete(TreeSet<String> collection) {
        long timeStart = System.nanoTime();
        Iterator<String> stringIterator = collection.iterator();
        while (stringIterator.hasNext()) {
            stringIterator.next();
            stringIterator.remove();
            break;
        }
        long timeEnd = System.nanoTime();
        long timeResult = timeEnd - timeStart;
        System.out.println(timeResult);
        return timeResult;
    }

    public long deleteAmount(Collection<String> collection, int amount) {
        long timeStart = System.nanoTime();
        Iterator<String> iterator = collection.iterator();
        int i = 0;
        while (i < amount) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                i++;
            }
        }
        long timeEnd = System.nanoTime();
        long timeResult = timeEnd - timeStart;
        System.out.println(timeResult);
        return timeResult;
    }

    public static void main(String[] args) {
        SpeedCollection collection = new SpeedCollection();
        Collection<String> collectionA = new ArrayList<String>();
        collection.add(collectionA, 10);
        Collection<String> collectionL = new LinkedList<String>();
        collection.add(collectionL, 10);
        TreeSet<String> collectionTreeS = new TreeSet<String>();
        collection.add(collectionTreeS, 10);
        collection.delete(collectionA);
        collection.delete(collectionL);
        collection.delete(collectionTreeS);

        collection.deleteAmount(collectionA, 3);
        collection.deleteAmount(collectionL, 3);
        collection.deleteAmount(collectionTreeS, 3);
    }

}