package ru.job4j.collection.stackandqueue;

import ru.job4j.collection.list.SimpleArrayList;


/**
 * Реализация стэка.
 *
 * @param <T> type of elements.
 */
public class SimpleStack<T> {

    /**
     * переменная, которая храниться в списке.
     */
   private T value;

    // Описание Stack - стек. Описывается LIFO - last input first output.
    /**
     * Наш котнтэйнер со связанным списоком type of Stack.
     */
    private SimpleArrayList<T> ourStackContainer = new SimpleArrayList();


    /**
     * удаляет и возвращает значение, которое добавили последним, в нашем контейнере оно первое по индексу.
     *
     * @return Значение для удаления.
     */
    public T poll() {
        T element = ourStackContainer.delete();
        return element;
    }

    /**
     * Добовляет значение в наш Stack, в элемент first.
     */
    public void push(T value) {
        ourStackContainer.add(value);
    }

    public T getValue() {
        return value;
    }

    public SimpleArrayList<T> getOurStackContainer() {
        return ourStackContainer;
    }
}
