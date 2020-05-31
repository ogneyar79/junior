package ru.job4j.multithereading.threads.produserconsumer;


public class Produser implements Runnable {

    private final SimpleBlockingQueue<Integer> myQueue;
    private final int quantity;

    public Produser(SimpleBlockingQueue<Integer> myQueue, int quantity) {
        this.myQueue = myQueue;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        int index = 0;
        while (index < quantity) {
            myQueue.offer(index++);
            System.out.println(index);
        }
    }
}

