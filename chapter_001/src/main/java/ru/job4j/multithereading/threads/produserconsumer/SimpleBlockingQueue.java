package ru.job4j.multithereading.threads.produserconsumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * блокирующая, потокобезопасная очередь на базе Линкед Лист.
 * <p>
 * "param <T> Тип элемента очереди
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    private int maxLine;



    public SimpleBlockingQueue(int maxLine) {
        this.maxLine = maxLine;
    }

    public void offer(T value) {
        synchronized (this) {
            while (queue.size() >= maxLine) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.queue.offer(value);
            this.notify();
            System.out.println("Wake up");
        }
    }


    public T poll() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                this.wait();
            }
            this.notify();
            System.out.println(" Get up");
            return this.queue.poll();
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public Queue<T> getQueue() {
        return queue;
    }

    public int getMaxLine() {
        return maxLine;
    }
}


