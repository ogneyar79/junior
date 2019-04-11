package ru.job4j.multithereading.threads.produserconsumer;

public class Consumer implements Runnable {

    private SimpleBlockingQueue<Integer> myQueue;
    private volatile boolean stop;

    public Consumer(SimpleBlockingQueue<Integer> myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            int i = 0;
            try {
                System.out.println(myQueue.poll());
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
