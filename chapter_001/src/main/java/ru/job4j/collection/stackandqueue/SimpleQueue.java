package ru.job4j.collection.stackandqueue;


import ru.job4j.collection.list.SimpleArrayList;

/**
 * Реализация очереди.
 *
 * @param <T> type of elements.
 */
public class SimpleQueue<T> {

    /**
     * Наш котнтэйнер со связанным списоком type of Queue.
     */
    private SimpleArrayList simpleArrayListContainerQuue = new SimpleArrayList();

    /**
     * Добовляет значение в наш Queue.
     */
    public void push(T value) {
        simpleArrayListContainerQuue.add(value);
    }

    /**
     * удаляет и возвращает перовое значение что добавили, в нашем контейнере, оно последнее по индексу.
     *
     * @return Значение для удаления.
     */
    public T poll() {
        int index = simpleArrayListContainerQuue.getSize() - 1;
        System.out.println("index" + index);
        T value = (T) simpleArrayListContainerQuue.delete(index);

        return value;
    }

    public SimpleArrayList getSimpleArrayListContainerQuue() {
        return simpleArrayListContainerQuue;
    }
}


