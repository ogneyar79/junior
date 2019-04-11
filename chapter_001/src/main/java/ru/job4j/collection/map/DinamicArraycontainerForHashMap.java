package ru.job4j.collection.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicArraycontainerForHashMap<E> implements Iterable<E> {

    /**
     * Начальное значение массива container.
     */
    private int lengthcIndex = 20;

    /**
     * Kontainer of objects
     */
    private Object[] container = new Object[lengthcIndex];

    /**
     * прееменная показывающая когда надо увеличивать размер container.
     */
    private final int indexFull = 2;

    /**
     * счетчик элементов в container.
     */
    private int size = 0;

    /**
     * индеск показывающий на сколько нужно увеличитвать контейнерю
     */
    private final int indexRiseArray = 2;

    /**
     * количество изменений в контейнере объектовю
     */
    private int modCount = 0;

    /**
     * Добавление элемнтов в список по индексу.
     *
     * @param model    добавляемый объект
     * @param position index at array, where insert our object.
     */
    public void set(int position, E model) {
        this.container[position] = model;
        size++;
        modCount++;
        if (container.length - size < indexFull) {
            this.container = Arrays.copyOf(container, this.container.length * indexRiseArray);
        }
    }

    /**
     * Удаление элемента по индесксу.
     *
     * @param index индекс массива по которому удаляется содержимое массива.
     * @return возвращаемый по индеску объект.
     */
    public E delete(int index) {
        E oldValue;
        if (index >= this.container.length) {
            System.out.println("You Beyond range of array");
            oldValue = null;
        } else if ((E) this.getContainer()[index] == null) {
            System.out.println("Array cell is empty, N0 object with that array index");
            oldValue = null;
        } else {
            oldValue = (E) this.getContainer()[index];
            this.container[index] = null;
            size--;
            modCount++;
            System.out.println("EveryThing is good, We Done it");
        }
        return oldValue;
    }

    /**
     * Удаление элемента по индесксу.
     *
     * @param index индекс массива по которому удаляется содержимое массива.
     */
    public void pooreDelete(int index) {
        if (index >= this.container.length) {
            System.out.println("You Beyond range of array");
        } else if ((E) this.getContainer()[index] == null) {
            System.out.println("Array cell is empty, N0 object with that array index");
        } else {
            this.container[index] = null;
            size--;
            modCount++;
            System.out.println("EveryThing is good, We have Done it");
        }
    }

    public Object[] getContainer() {
        return container;
    }

    public void setContainer(Object[] container) {
        this.container = container;
        this.lengthcIndex = container.length;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            int indexI;
            int expectedModcount = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                for (int i = indexI; i < container.length; i++) {
                    if (container[indexI] == null) {
                        result = false;
                        indexI++;
                    } else if (container[indexI] != null) {
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public E next() {
                if (expectedModcount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[indexI++];
            }
        };
    }
}

