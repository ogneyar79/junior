package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIteratorForArray implements Iterator<Integer> {

    int[] value;
    int indexEvenNumber;

    public EvenIteratorForArray(int[] value) {
        this.value = value;
    }

    @Override
    public void remove() {
    }

    public boolean hasNext() {
        boolean result = false;
        int indexFindNextEven = indexEvenNumber;
        System.out.println(indexEvenNumber);
        System.out.println(indexFindNextEven);
        if (this.value.length == 0) {
            result = false;
        }
        for (int i = indexEvenNumber; i < value.length; i++) {
            if (value[i] % 2 == 0) {
                result = true;
                System.out.println("Break");
                System.out.println(i + "i");
                break;
            }
            System.out.println(indexFindNextEven);
            System.out.println(i + "I1");
            indexFindNextEven++;
            System.out.println(indexFindNextEven);
        }
        return result;
    }

    public Integer next() {
        if (!EvenIteratorForArray.this.hasNext()) {
            throw new NoSuchElementException();
        }
        System.out.println(indexEvenNumber);
        while (value[indexEvenNumber] % 2 != 0) {
            System.out.println(indexEvenNumber);
            indexEvenNumber++;
        }
        System.out.println(indexEvenNumber);
        return value[indexEvenNumber++];
    }

    public void makeNext() {
        try {
            next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
