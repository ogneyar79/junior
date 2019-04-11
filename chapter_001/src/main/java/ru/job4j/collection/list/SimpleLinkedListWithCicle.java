package ru.job4j.collection.list;


/**
 * Класс с реализацией метода для определения цикличности в связанном спискею
 */
public class SimpleLinkedListWithCicle {


    /**
     * внутренний класс, узел нашего связанного списка.
     * <p>
     * "param <T> Тип элемента в уздею
     */
    class Node<T> {
        T value;
        Node<T> next;
    }

    /**
     * method для опеределения цикличности в связанном спискею
     *
     * @param first первый элемент списка.
     */
    boolean hasCycle(Node first) {
        boolean result = false;
        if (first == null) {
            result = false;
        } else if (first.next == first) {
            result = true;
        }

        Node slow = first;
        Node fast = first;     // create two references.

        while (true) {
            if (fast == null) {
                result = false;
                break;
            } else if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {              // if the two ever meet...we must have a loop
                    result = true;
                    break;
                }
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

}
