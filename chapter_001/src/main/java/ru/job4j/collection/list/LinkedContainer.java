package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Динамический список на базе связанного спискаю
 * <p>
 * "param <E> Тип элемента нашего контейнера.
 */
public class LinkedContainer<E> implements Iterable<E> {

    /**
     * счетчик элементов в container.
     */
    private int size;

    /**
     * переменная класса NodeP, ссылка на первый элемент списка.
     */
    private NodeP first;

    /**
     * Содержит количество изменений в списке.
     */
    int modCount = 0;

    /**
     * Добавление нового значения в начало списока.
     *
     * @param value Новый объект, добавляемый в список.
     */
    public void add(E value) {
        NodeP<E> newLink = new NodeP<>(first, value);
        this.first = newLink;
        size++;
        modCount++;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModcount = modCount;
            NodeP<E> nodeP;
            int indexI;

            @Override
            public boolean hasNext() {
                return indexI < size;
            }

            @Override
            public E next() {
                E result;
                if (expectedModcount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (indexI == 0) {
                    result = (E) getFirst().getDate();
                    this.nodeP = getFirst();
                    indexI++;
                } else {
                    result = nodeP.getNext().getDate();
                    this.nodeP = nodeP.getNext();
                    indexI++;
                }
                return result;
            }
        };
    }

    /**
     * Получение элементов из списка по индексу.
     *
     * @param index Индекс искомого элемента.
     * @return Необходимый элемент списка.
     */
    public E get(int index) {
        E result = null;
        if (index == 0) {
            result = (E) this.getFirst().getDate();
        }
        Iterator<E> iteratorFindEleventByIndex = this.iterator();
        for (int i = 0; i <= index; i++) {
            result = iteratorFindEleventByIndex.next();
        }
        return result;
    }

    /**
     * Получение количества элементов связного списка.
     *
     * @return Количество элементов связного списка.
     */
    public int getSize() {
        return size;
    }

    /**
     * Получение первого элемента связного списка.
     *
     * @return первого элемната.
     */
    public NodeP getFirst() {
        return first;
    }
}
