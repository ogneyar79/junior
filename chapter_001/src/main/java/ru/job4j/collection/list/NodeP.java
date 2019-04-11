package ru.job4j.collection.list;

public class NodeP<E> {

    private NodeP<E> next;

    private E date;

    public NodeP(NodeP<E> next, E date) {
        this.next = next;
        this.date = date;
    }

    public NodeP<E> getNext() {
        return next;
    }

    public E getDate() {
        return date;
    }

    public void setNext(NodeP<E> next) {
        this.next = next;
    }

    public void setDate(E date) {
        this.date = date;
    }
}
