package concurrent.nonblockingalgoritm;


import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASQueue<T> {

    private final AtomicReference<Node<T>> head = new AtomicReference<>();
    private final AtomicReference<Node<T>> tail = new AtomicReference<>();

    public void push(T value) {
        Node<T> temp = new Node<>(value);
        Node<T> checker;
        if (tail.get() == null) {
            throw new UnsupportedOperationException("Queue is not impl.");
        }
        do {
            checker = tail.get();
            temp.next = checker;

        } while (!tail.compareAndSet(checker, temp));
    }

    public T poll() {
        Node<T> cheker;
        Node<T> temp;
        do {
            cheker = head.get();
            if (cheker == null) {
                throw new IllegalStateException("Queue is not impl.");
            }
            temp = cheker.next;
        } while (this.head.compareAndSet(cheker, temp));
        cheker.next = null;
        return cheker.value;
    }

    private static final class Node<T> {
        final T value;

        Node<T> next;

        public Node(final T value) {
            this.value = value;
        }
    }


}
