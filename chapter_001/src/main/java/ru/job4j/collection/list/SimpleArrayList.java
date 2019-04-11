package ru.job4j.collection.list;

import java.util.NoSuchElementException;

public class SimpleArrayList<E> {

    private int size = 0;
    private Node<E> first = null;

    /**
     * Метод вставляет в начало списка данные, в first element.
     */
    public void add(E date) {
        if (date == null) {
            throw new NullPointerException("The first argument for add() is null.");
        }
        Node<E> newLink = new Node<>(date);
        if (first == null) {
            this.first = newLink;
            this.first.next = null;

        } else {
            Node<E> temp = first;
            this.first = newLink;
            this.first.next = temp;
        }
        this.size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E delete() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node<E> copyFirsElement = this.first;
        this.first = this.first.next;
        copyFirsElement.next = null;
        this.size--;
        return copyFirsElement.date;
    }

    /**
     * Реализовать метод удаления  элементa в списке по индексу.
     */
    public E delete(int index) {
        Node<E> result = this.first;
        Node<E> elementNodeForDeleted = this.first;
        if (index == 0) {
            delete();
        } else if (index < 1 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index
                    + ", Size: " + size);
        } else if (index == size - 1) {
            for (int j = 0; j < index; j++) {
                result = result.next;
                if (j == index - 1) {
                    elementNodeForDeleted.next = null;
                    break;
                }
                elementNodeForDeleted = elementNodeForDeleted.next;
            }
        } else {
            for (int j = 0; j < index; j++) {
                result = result.next;
                if (j == index - 1) {
                    Node<E> temp = elementNodeForDeleted.next;
                    elementNodeForDeleted.next = elementNodeForDeleted.next.next;
                    temp.next = null;
                    break;
                }
                elementNodeForDeleted = elementNodeForDeleted.next;
            }
            this.size--;
        }
        return result.date;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        if (index == 0) {
            return result.date;
        }
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return date.toString();
        }
    }

    public Node<E> getFirst() {
        return first;
    }
}
