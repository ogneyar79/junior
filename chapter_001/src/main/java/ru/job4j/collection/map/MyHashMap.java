package ru.job4j.collection.map;

import java.util.Iterator;

public class MyHashMap<L, O> implements Iterable<MyEntry> {

    /**
     * Контейнер переменная где размещаются объекты типа MyEntry.
     */
    DinamicArraycontainerForHashMap<MyEntry> containerMap = new DinamicArraycontainerForHashMap();

    /**
     * переменная которая размещается в контейнрее и которая является хранилищем для ключа и значения.
     */
    MyEntry myEntry;

    /**
     * счетчик элементов в container.
     */
    private int size = this.containerMap.getSize();

    /**
     * Расчет hash функции.
     *
     * @param key на основании которого расчитывается функция.
     * @return возвращаемое в результате число.
     */
    int hash(final L key) {
        int hash = 31;
        hash = hash * 31 + key.hashCode();

        return hash % this.containerMap.getContainer().length;
    }

    /**
     * Функция для перерасчета всех hash значений и перераспределения объектов в нашей карте.
     *
     * @return возвращаемое в результате число.
     */
    DinamicArraycontainerForHashMap<MyEntry> reStartHashFunction() {
        DinamicArraycontainerForHashMap<MyEntry> containerMap2 = new DinamicArraycontainerForHashMap();
        int indexHash;
        Object[] container = new Object[containerMap.getContainer().length];
        System.out.println(container.length);
        containerMap2.setContainer(container);
        System.out.println(this.containerMap.getSize());
        System.out.println(this.containerMap.getContainer().length);
        for (Iterator<MyEntry> it = this.containerMap.iterator(); it.hasNext();) {
            MyEntry<L, O> myEntry = it.next();
            indexHash = hash(myEntry.getKey());
            containerMap2.set(indexHash, myEntry);
        }
        return containerMap2;
    }

    /**
     * вставка ассоциативных объектов в карту.
     *
     * @param key   на основании которого расчитывается функция.
     * @param value обект, который храниться в нашей карте
     * @return возвращаемое bolean значение по результатам работы метода.
     */
    boolean insert(L key, O value) {
        boolean result = false;
        int chekingRiseLength = containerMap.getContainer().length;
        int indexHash = hash(key);
        MyEntry<L, O> entry = (MyEntry<L, O>) this.containerMap.getContainer()[indexHash];
        if (entry == null) {
            MyEntry basket = new MyEntry(key, value);
            containerMap.set(indexHash, basket);
            if (chekingRiseLength < containerMap.getContainer().length) {
                this.containerMap = reStartHashFunction();
                System.out.println(" We increase doble our container");
            }
            result = true;
        } else if (entry.getKey() != null & !entry.getKey().equals(key)) {
            System.out.println(" This collision. The cell has already object with another key");
            result = false;
        } else if (entry.getKey() != null & entry.getKey().equals(key)) {
            MyEntry basket = new MyEntry(key, value);
            containerMap.set(indexHash, basket);
            System.out.println(" The Key Was the same and this why object with that key was changed");
            result = true;
        }
        return result;
    }

    /**
     * удаление объектов из карты по ключу.
     *
     * @param key параметр по которому находим объект для удаления.
     * @return возвращаемое bolean значение по результатам работы метода.
     */
    boolean delete(L key) {
        boolean result;
        int indexHash = hash(key);
        MyEntry<L, O> entry = (MyEntry<L, O>) this.containerMap.getContainer()[indexHash];
        if (entry == null) {
            result = false;
            System.out.println(" We no have such key in our map");
        } else if (entry.getKey().equals(key)) {
            this.containerMap.getContainer()[indexHash] = null;
            result = true;
        } else {
            System.out.println("We have another key in this sell");
            result = false;
        }
        return result;
    }

    /**
     * поиск объекта по ключу.
     *
     * @param key объект-ключ по которому ищем ассоциативный объект.
     * @return возвращаемое O значение по результатам работы метода, если значение не найдено, то возвращается null.
     */
    O getValue(L key) {
        int indexHash = hash(key);
        MyEntry<L, O> entry = (MyEntry<L, O>) this.containerMap.getContainer()[indexHash];
        if (entry.getKey().equals(key)) {
            return entry.getValue();
        }
        return null;
    }

    @Override
    public Iterator<MyEntry> iterator() {
        return containerMap.iterator();
    }
}
