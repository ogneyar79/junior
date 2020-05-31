package ru.job4j.multithereading.threads.produserconsumer;

import java.util.ArrayList;

public class Consumer<T> implements Runnable {

    private SimpleBlockingQueue<Integer> myQueue;
    private ArrayList<T> list = new ArrayList<>();

    public Consumer(SimpleBlockingQueue<Integer> myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (!myQueue.isEmpty()) {
            try {
                list.add((T) myQueue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
