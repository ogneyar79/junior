package ru.job4j.multithereading.threads.produserconsumer;

import org.junit.Test;

import java.util.Random;

public class SimpleBlockingQueueTest {

    @Test
    public void whenUseBlockingQueue1() {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(20);
        Random random = new Random();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < queue.getMaxLine(); i++) {
                queue.offer(i);
                System.out.println(String.format("%s вставляет %s", Thread.currentThread().getName(), i));
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(String.format("%s вытаскивает %s", Thread.currentThread().getName(), queue.poll()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer.start();
        producer.start();

        try {
            consumer.join(03);
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("exit");
    }
}