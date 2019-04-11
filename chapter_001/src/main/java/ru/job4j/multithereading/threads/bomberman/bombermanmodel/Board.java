package ru.job4j.multithereading.threads.bomberman.bombermanmodel;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * класс Игрового поля для бомберменов.
 */
public class Board {

    /**
     * Внутренние поля класса, координаты
     */
    int sizeLine;
    int sizeColumn;


    /**
     * Внутренние поле класса, сколько монстрев создать
     */
    final int monsterNumber;


    /**
     * клетка на доске.
     */
    Cell cellOnBoard;

    /**
     * движущая модель на доске.
     */

    /**
     * препятствие на доске.
     */
    private Wall wall;

    /**
     * фигура игрока бомбермана.
     */
    final PlayerUno playerUno;


    /**
     * Внутренние поля класса, массив где храняться потоки с монстрами.
     */
    final Thread[] monsterThread;

    /**
     * поле-одномерный массив, где храняться наши клетки, связанные с блокирующими клетками.
     */
    final Cell[] cells;

    /**
     * Игровое поле.
     */
    final ReentrantLock[][] boardRlForGame;

    /**
     * Конструктор размерности игрового поля.
     *
     * @param sizeLine      Размер по оси X.
     * @param sizeColumn    Размер по оси Y.
     * @param monsterNumber количество монсторов в игре
     * @param monsterThread массив для хранения монстров
     */
    public Board(final int sizeLine, final int sizeColumn, int monsterNumber, Thread[] monsterThread) {
        this.sizeLine = sizeLine;
        this.sizeColumn = sizeColumn;
        this.monsterNumber = monsterNumber;
        this.monsterThread = monsterThread;
        cells = new Cell[sizeLine * sizeColumn];
        this.boardRlForGame = new ReentrantLock[sizeLine][sizeColumn];
        int z = 0;
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                boardRlForGame[i][j] = new ReentrantLock();
                final Cell cellOnBoard = new Cell(this.boardRlForGame, i, j);
                cellOnBoard.setNumKoord(z);
                this.cells[z] = cellOnBoard;
                z++;
            }
        }
        playerUno = new PlayerUno("TEROR", "RED", cells[36]);
        playerUno.getInformationFigure();
    }

    /**
     * Передвижение игрока.
     *
     * @param source Начальная клетка движения.
     * @param dist   Конечная клетка движения.
     * @return результат операции.
     * @throws InterruptedException Выбрасывается при прерывании потока.
     */
    Boolean move(Cell source, Cell dist) throws InterruptedException {
        System.out.println(String.format("BomberMan пытается сделать ход из %s в %s", source, dist));

        boolean resultMovment;

        if (this.boardRlForGame[dist.getKoordinateLineX()][dist.koordinateLinecolumneY].tryLock(500, TimeUnit.MILLISECONDS)) {
            this.boardRlForGame[source.getKoordinateLineX()][source.getKoordinateLinecolumneY()].unlock();

            this.playerUno.setMyPlace(dist);
            resultMovment = true;
            System.out.println(" Bomberman has steped into");
        } else {
            System.out.println(" Esta occupada)) Позиция ЗАНЯТА");
            resultMovment = false;
            System.out.println(" The Cell is occupied");
        }
        System.out.println(resultMovment);
        return resultMovment;
    }

    /**
     * метод для определения случайного положения на доске.
     *
     * @return результат операции.
     */
    public int selectPlaceOnBoard() {
        int result;
        Random random = new Random();
        result = random.nextInt(this.cells.length);
        if (result == 36) {
            selectPlaceOnBoard();
        }
        return result;
    }

    /**
     * метод для создания фигуры препятствия.
     *
     * @param cell , клетка в которой будет созданно препятствие
     * @return результат операции.
     */
    public Wall createWall(Cell cell) {
        return new Wall("Wall", "Black", cell);
    }


    /**
     * метод для создания фигур препятствий в соответствии с заданным количеством.
     */
    public void createWallOnBoard(int quantity) {
        int limitCreation = 0;
        while (limitCreation < quantity) {
            int a;
            a = selectPlaceOnBoard();
            if (!this.getCells()[a].getCellLock().isLocked()) {
                createWall(this.getCells()[a]);
                System.out.println("препятствие созано в " + this.getCells()[a] + " информация о клетке");
                this.getCells()[a].cellInfo();
                limitCreation++;
            }
        }
    }

    /**
     * Метод создает монстров.
     *
     * @param monsterNumber колличество монстров.
     * @throws InterruptedException
     */
    void createMonsterS(int monsterNumber) throws InterruptedException {

        int a;
        for (int index = 0; index != monsterNumber; index++) {
            do {
                a = selectPlaceOnBoard();
            }
            while (!this.getCells()[a].getCellLock().isLocked());
            MonsterMoveThrread creationMOnster = new MonsterMoveThrread(new Monster(String.format("Создан Монстр с индексом %s в клетке %s", index, this.getCells()[a]), " Green", this.getCells()[a], this));
            this.getCells()[a].cellInfo();
            Thread momsterThread = new Thread(creationMOnster, "Monster" + index);
            this.getMonsterThread()[index] = momsterThread;
        }
    }

    public PlayerUno getPlayerUno() {
        return playerUno;
    }

    /**
     * Получение массива клетко.
     *
     * @return массив клеток.
     */
    public Cell[] getCells() {
        return cells;
    }

    public int getMonsterNumber() {
        return monsterNumber;
    }

    public Thread[] getMonsterThread() {
        return monsterThread;
    }

    /**
     * Получение двухмерного массива блокирующих клеток объектов.
     *
     * @return двухмерный массив с блокирующиими объектами.
     */
    public ReentrantLock[][] getBoardRlForGame() {
        return boardRlForGame;
    }

    /**
     * Получение размера по оси X.
     *
     * @return размер по оси X.
     */
    public int getSizeLine() {
        return sizeLine;
    }

    /**
     * Получение размера по оси Y.
     *
     * @return размер по оси Y.
     */
    public int getSizeColumn() {
        return sizeColumn;
    }
}
