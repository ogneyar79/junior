package ru.job4j.multithereading.threads.pool;

import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {

    /**
     * Предмет письма.
     */
    private String subject;

    /**
     * Содержимое письма.
     */
    private String body;

    /**
     * Пул потоков.
     */
    ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(User user) {
        subject = MessageFormat.format("Notification for {0}, email {1}.", user.getName(), user.getEmail());
        body = MessageFormat.format("Add a new event to {0}. ",
                user.getName());

        this.pool.submit(() -> send(subject, body, "email"));

    }

    /**
     * Метод отсылки сообщения.
     *
     * @param subject Тема письма.
     * @param body    Тело письма.
     * @param email   Письмо.
     */
    public void send(String subject, String body, String email) {

    }

    /**
     * Закрытие пула потоков.
     */
    public void close() {
        this.pool.shutdown();
        while (!this.pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
