package ru.job4j.multithereading.threads.pinpong;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread2 = new MyThread("Maria");

        Thread.sleep(1000);
        thread2.keepRunning = false;
        System.out.println(System.currentTimeMillis() + " keepRunning is false");
    }
}

class MyThread implements Runnable {
    public String name = null;
    boolean keepRunning = true;

    int count = 0;

    public MyThread() {
    }

    public MyThread(String name) {
        this.name = name;
        Thread thread = new Thread(this, name);
        thread.start();
    }

    public boolean isKeepRunning() {
        return keepRunning;
    }

    @Override
    public void run() {
        while (keepRunning) {
            System.out.println(isKeepRunning());
            System.out.println(Thread.currentThread().getName() + " " + isKeepRunning());
            System.out.println(isKeepRunning());
        }
    }
}
