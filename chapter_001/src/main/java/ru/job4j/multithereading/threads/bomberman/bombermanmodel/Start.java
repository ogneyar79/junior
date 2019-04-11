package ru.job4j.multithereading.threads.bomberman.bombermanmodel;

public class Start {

    public static void main(String[] args) throws InterruptedException {
        int monserNumber = 3;

        Thread[] monsterThread = new Thread[monserNumber];

        Board boardFirst = new Board(8, 8, monserNumber, monsterThread);
        boardFirst.createWallOnBoard(5);
        System.out.println(" We are creating monster");
        boardFirst.createMonsterS(monserNumber);
        System.out.println(" The monsters have created");
        Figure figureBomb = boardFirst.getPlayerUno();
        Movment movmentBomb = new Movment(figureBomb, boardFirst);
        System.out.println(" We have just began to get out monster");
        for (int i = 0; i < monsterThread.length; i++) {
            boardFirst.getMonsterThread()[i].setDaemon(true);
            System.out.println(" monster number" + i);
            boardFirst.getMonsterThread()[i].start();
        }
        BombeManGamePlayerTread bombert = new BombeManGamePlayerTread(boardFirst, movmentBomb);

        Thread threadBomber = new Thread(bombert);
        threadBomber.start();

    }
}
