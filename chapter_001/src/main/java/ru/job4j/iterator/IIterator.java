package ru.job4j.iterator;



public interface IIterator {

     int next();
     boolean hasNext();
     int valuesCountArray(int[][] value);
     int getInnerIndex();
     int getCurrent();
     void setCurrent(int current);


}