package ru.job4j.multithereading.threads.bomberman.bombermanmodel;

public class StartForTest {
    public static void main(String[] args) throws InterruptedException {
        int monsterNumber = 1;
        Thread[] monsterThread = new Thread[monsterNumber];

        //    Board board = new Board(8, 8, monserNumber, monsterThread);
        //  System.out.println(" We are creating monster");
//        board.createMonsterS(monserNumber);
        //      System.out.println(" The monsters have created"System.out.println(" We have just began to get out monster");
        //    board.getMonsterThread()[0].start();

        Board board = new Board(8, 8, monsterNumber, monsterThread);
        Cell cell = new Cell(board.boardRlForGame, 0, 2);

        Monster monstert = new Monster("Monstertest1", "Green", cell, board);
        System.out.println(board);
        System.out.println(board.cells[7].getNumKoord());
        System.out.println(monstert.board);

        MonsterMoveThrread monsterTest = new MonsterMoveThrread(monstert);
       monsterTest.run();
    }
}
