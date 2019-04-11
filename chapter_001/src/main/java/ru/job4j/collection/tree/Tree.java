package ru.job4j.collection.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * переменная Node<E> корневой узел нашего дерева
     */
    private Node<E> root;
    /**
     * переменная которая показывает количество элементов, узлов в дереве.
     */
    int size = 0;


    /**
     * констуктор нашего класса.
     *
     * @param root Node<E>, элемент, который будет хранится в корне нашего дерева.
     */
    public Tree(Node<E> root) {
        this.root = root;
        this.size = size;
        size++;
    }

    /**
     * Добавить элемент childValue в  потомков parent.
     * Parent может иметь список child.
     *
     * @param parentValue параметр <E> значения в Node<E>, родителсьскоого Tree узла, в потомков которогого добавляем значение.
     * @param childValue  параметр <E> значение, которое добалвяем, в потомок нашего узла.
     * @return
     */
    @Override
    public boolean add(E parentValue, E childValue) {
        boolean rezult = false;
        E valueOfChild = childValue;
        if (this.findDoublicutBy(valueOfChild)) {
            rezult = false;
            System.out.println(" We have The Same Meaning childValue = " + childValue + " at our Tree");
            return rezult;
        }
        Queue<Node<E>> data = new LinkedList<>();
        Node<E> nodeOfChild = new Node<>(valueOfChild);
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(parentValue)) {
                el.leaves().add(nodeOfChild);
                size++;
                rezult = true;
                break;
            }
            for (Node<E> ch : el.leaves()) {
                data.offer(ch);
            }
        }
        return rezult;
    }


    /**
     * Функция для поиска значения в нашем дереве.
     *
     * @param value E значение, что мы ищем.
     * @return возвращаемое в результате Optional значение, может содержать Null, а может  E значение.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Функция для поиска дубликата в нашем дереве.
     *
     * @return возвращаемое в результате bolean значение.
     */
    public boolean findDoublicutBy(E value) {
        Optional<Node<E>> rsl = this.findBy(value);
        return rsl.isPresent();
    }

    /**
     * Функция для определения, является ли дерево бинарным.
     *
     * @return возвращаемое в результате boolean значение.
     */
    public boolean isBinary() {
        boolean isBinaryResult = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                isBinaryResult = false;
                break;
            }
        }
        return isBinaryResult;
    }

    /**
     * Функция для итерации, в результате работы котрой мы можем полцчить доступ к <E> значениям, хранящимся в узлах дерева, не Node.
     *
     * @return возвращаемое в результате object Iterator.
     */
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            Queue<Node<E>> data = new LinkedList<>();
            int indexI = 0;

            {
                data.offer(root);
            }

            @Override
            public boolean hasNext() {
                return indexI < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = null;

                while (!this.data.isEmpty()) {
                    Node<E> el = data.poll();
                    result = el.getValue();
                    indexI++;
                    if (el.leaves() != null) {
                        for (Node<E> child : el.leaves()) {
                            data.offer(child);
                        }
                    }
                    break;
                }
                return result;
            }
        };
    }


}
