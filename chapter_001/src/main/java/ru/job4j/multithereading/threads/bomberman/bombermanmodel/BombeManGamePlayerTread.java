package ru.job4j.multithereading.threads.bomberman.bombermanmodel;

/**
 * .
 */
public class BombeManGamePlayerTread implements Runnable {

    /**
     * объект для создания модели игрового поля.
     */
    final Board board;

    /**
     * объект для выбора случайности базисного шага.
     */
    final Movment movment;

    public BombeManGamePlayerTread(Board board, Movment movment) {
        this.board = board;
        this.movment = movment;
    }

    @Override
    public void run() {

        Cell source = board.getPlayerUno().getMyPlace();
        Cell dest;
        board.getBoardRlForGame()[source.getKoordinateLineX()][source.getKoordinateLinecolumneY()].lock();
        while (!Thread.currentThread().isInterrupted()) {
            try {
                source = board.getPlayerUno().getMyPlace();
                if (board.getBoardRlForGame()[source.getKoordinateLineX()][source.koordinateLinecolumneY].hasQueuedThreads()) {
                    System.out.println("They have finished me off, Bastards AAAA");
                    Thread.currentThread().interrupt();
                }
                dest = board.getCells()[movment.stepNext()];
                source.cellInfo();
                dest.cellInfo();
                board.move(source, dest);
            } catch (InterruptedException e) {
                System.out.println("BomberMan game over");
                Thread.currentThread().interrupt();
            }
        }
    }
}
