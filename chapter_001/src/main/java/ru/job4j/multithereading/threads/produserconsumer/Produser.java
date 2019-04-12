//package ru.job4j.multithereading.threads.produserconsumer//package ru.job4j.multithereading.threads.produserconsumer;
//
//import java.util.Random;
//
//public class Produser implements Runnable {
//
//    private SimpleBlockingQueue<Integer> myQueue;
//
//    public Produser(SimpleBlockingQueue<Integer> myQueue) {
//        this.myQueue = myQueue;
//    }
//
//    @Override
//    public void run() {
//        Random random = new Random();
//        while (true) {
//            int i = 0;
//            i++;
//            try {
//
//                myQueue.offer(random.nextInt());
//                System.out.println(i);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//