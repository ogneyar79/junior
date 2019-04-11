package ru.job4j.multithereading.threads.pool;

import org.junit.Test;

public class ThreadPoolTest {


    public class Job implements Runnable {
        int number = 0;

        /**
         * Конструктор - создание нового объекта с определенными значениями.
         * @param num - порядковый номер работы
         *
         * @see Job
         */
        public Job(int num) {
            this.number = num;
        }

        /**
         * Процедура по осуществлению работы
         *
         */
        @Override
        public void run() {
            System.out.println(String.format("Thread %s doing JOB #%s", Thread.currentThread().getName(), number));
        }
    }

    @Test
    public void whenAddTenJobsThenWork() {
        ThreadPool pool = new ThreadPool();

        for (int index = 0; index < 10; index++) {
            pool.work(new Job(index));
        }
        pool.shutdown();
    }


}