package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maksi on 16.12.2017.
 * pablic class for convert ArrayList to array and back
 */
public class ConvertList {

    /**
     * @ param int field for size array[][]
     */
    private int cizeA;

    /**
     * @ param int field for size array [][]
     */
    private int cizeB;

    /**
     * @ param int field for size array[][]
     */
    public int rows;

    /**
     * @ param int field for size array[][]
     */
    public int cells;

    /**
     * @ param List</Integer>field for ArrayList
     */
    List<Integer> listLoop = new ArrayList<Integer>();

    List<int[]> list = new ArrayList<>();

    /**
     * method for creaction ConvertList object.
     *
     * @param cizeA int
     * @param cizeB int
     */
    public ConvertList(int cizeA, int cizeB) {
        this.cizeA = cizeA;
        this.cizeB = cizeB;
    }

    /**
     * @ param field int aaray2.
     */
    public int[][] array2;

    /**
     * method for fill int[][] array by meaning.
     *
     * @return the  [][]
     */
    public int[][] fill() {
        int number = 0;
        int cizeA = this.cizeA;
        int cizeB = this.cizeB;
        int[][] array = new int[cizeA][cizeB];
        for (int i = 0; i < cizeA; i++) {
            for (int j = 0; j < cizeB; j++) {
                array[i][j] = number++;
                System.out.println(array[i][j]);
            }
        }
        array2 = array;
        return array2;
    }

    /**
     * method for convert int[][] to ArrayList.
     *
     * @param array2 int[][]
     * @return the listLoop List <Integer> Array
     */
    public List<Integer> toList(int[][] array2) {
        List<Integer> listLoop = new ArrayList<Integer>();
        for (int[] row : array2) {
            for (int cell : row) {
                listLoop.add(cell);
            }
        }
        return listLoop;
    }

    /**
     * method for convert ArrayList to int[][] array.
     *
     * @param list<Integer>
     * @param rows          \
     * @return the array2 int[][]
     */
    public int[][] toArray(List<Integer> list, int rows) {

        List<Integer> listForConvert = new ArrayList<>();
        listForConvert = list;
        int cizeLoop = listForConvert.size();
        if (cizeLoop % rows == 0) {
            int q = 0;
            int cells = cizeLoop / rows;
            int[][] array2 = new int[rows][cells];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cells; j++) {
                    array2[rows][cells] = listForConvert.get(q);
                    q++;
                }
            }
        } else {
            int q = 0;
            int partRows = cizeLoop / rows;
            int newCizeLoop = partRows * rows + rows;
            int cells = newCizeLoop / rows;
            array2 = new int[rows][cells];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cells - (newCizeLoop - cizeLoop); j++) {
                    array2[rows][cells] = listForConvert.get(q);
                }
            }
        }
        return array2;
    }

    public List<Integer> convert(List<int[]> list) {
        List<int[]> list1 = new ArrayList<>();
        List<Integer> listLoop = new ArrayList<>();
        int[] array;
        list1 = list;
        for (int[] row : list) {
            for (int arrayIndex : row) {
                listLoop.add(arrayIndex);
            }
        }
        return listLoop;
    }

    public static void main(String[] args) {
        ConvertList forFiling = new ConvertList(4, 4);
        forFiling.fill();
        forFiling.array2 = forFiling.toArray(forFiling.listLoop, 4);
        for (int i = 0; i < forFiling.array2.length; i++) {
            for (int j = 0; j < forFiling.array2[i].length; j++) {
                System.out.print(forFiling.array2[i][j]);

            }
            System.out.println("");
        }
    }

}
