package ru.job4j.multithereading.threads.nonblocingalgoritm;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;


public class HashTest {
    @Test
    public void whenHashIncrementTrowExceptions() throws InterruptedException {
        Hash hash = new Hash();
        AtomicReference<Exception> atomic = new AtomicReference<>();

        Thread threadFirst = new Thread(() -> {
            hash.add(new Base(100, 0));
            hash.add(new Base(200, 0));
            hash.add(new Base(300, 0));
            for (int i = 0; i < 300; i++) {
                try {
                    hash.update(new Base(100, 0));
                    System.out.println(Thread.currentThread().getName() + " " + i);
                } catch (OptimisticException e) {
                    atomic.set(e);
                }
            }
        });
        Thread threadSecond = new Thread(() -> {
            hash.add(new Base(100, 0));
            hash.add(new Base(200, 0));
            hash.add(new Base(300, 0));

            for (int i = 0; i < 300; i++) {
                try {
                    hash.update(new Base(100, 0));
                    System.out.println(Thread.currentThread().getName() + " " + i);
                } catch (OptimisticException e) {
                    atomic.set(e);
                }
            }
        });
        threadFirst.start();
        threadSecond.start();
        threadFirst.join();
        threadSecond.join();
        assertThat(atomic.get().getMessage(), is(" It has already been changed"));
    }
}