package ru.job4j.multithereading.threads.bomberman.bombermanmodel;

public class MonsterMoveThrread implements Runnable {

    Monster monster;

    public MonsterMoveThrread(Monster monster) {
        this.monster = monster;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(" Run begin");
                monster.moveMonster();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
