package ru.job4j.multithereading.threads.pool;

import ru.job4j.multithereading.threads.produserconsumer.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {

    /**
     * Переменная threads класса List<PoolWorker> threads где размещаются объекты Thread, делающие нашу работу.
     */
    private final List<PoolWorker> threads = new LinkedList<>();

    /**
     * Переменная task класса List<Runnable> где размещаются объекты, основной работы.
     */
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(100);

    /**
     * Конструктор - создание нового объекта
     *
     * @see ThreadPool
     * осуществляется создание потоков, их добавление(работников) в ArrayList и запуск
     */
    public ThreadPool() {
        for (int index = 0; index < Runtime.getRuntime().availableProcessors(); index++) {
            threads.add(new PoolWorker(tasks, index));
        }
        this.threads.forEach(Thread::start);
    }

    /**
     * Процедура передачи работы, котрую необходимо сделать {@link ThreadPool}
     *
     * @param job - передоваемая работа
     */
    public void work(Runnable job) {
        try {
            tasks.offer(job);
        } catch (Exception e) {
            System.out.println("Unable to add task to queue.");
        }
    }

    /**
     * Процедура остановуки потоков {@link ThreadPool}
     */
    public void shutdown() {
        System.out.println("Shutdown");
        for (PoolWorker worker : threads) {
            worker.interrupt();
            System.out.println(String.format("%s is stops.", worker.getName()));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Внутренний Класс работников, берущих основную работусо свойствами <b>task</b> и <b>index</b>.
     *
     * @autor maksimus.s@mail.ru
     */
    private class PoolWorker extends Thread {

        /**
         * Переменная task класса List<Runnable> где размещаются объекты, основной работы, в нашем случае передаём из основного класса.
         */
        private final SimpleBlockingQueue<Runnable> t;

        /**
         * Конструктор - создание нового объекта
         *
         * @see PoolWorker()
         * осуществляется передача ссылки на задания и создание объектов работников
         */
        public PoolWorker(SimpleBlockingQueue<Runnable> tasks, int index) {
            this.t = tasks;
            System.out.println(String.format("Thread %s is started", index));
        }

        /**
         * Процедура по запуску работника {}
         * основное действие - брать работу.
         */
        @Override
        public void run() {
            Runnable task;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    task = t.poll();
                    task.run();
                } catch (Exception e) {
                    System.out.println(String.format("%s is interrupted.", Thread.currentThread().getName()));
                }
            }
        }
    }
}
