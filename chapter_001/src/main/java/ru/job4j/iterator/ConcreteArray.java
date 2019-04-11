package ru.job4j.iterator;

import java.util.NoSuchElementException;

public class ConcreteArray implements IArrayIteratorTask {
    int[][] value = {
            {1, 2},
            {3, 4}
    };


    public ConcreteArray(int[][] value) {
        this.value = value;
    }

    @Override
    public IIterator getIterator() {
        return new IteratorArray();
    }

    public class IteratorArray implements IIterator {

        int index = 0;
        int innerIndex = 0;
        int meaning;
        int current = 0;


        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getInnerIndex() {
            return innerIndex;
        }

        public void setInnerIndex(int innerIndex) {
            this.innerIndex = innerIndex;
        }

        public int getMeaning() {
            return meaning;
        }

        public void setMeaning(int meaning) {
            this.meaning = meaning;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int valuesCountArray(int[][] value) {
            int count = 0;
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    count++;
                }
            }
            return count;
        }

        @Override
        public int next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            for (int i = index; i < value.length; i++) {
                for (int j = innerIndex; j < value[i].length;) {
                    meaning = value[i][j];
                    if (j < value[i].length - 1) {
                        current++;
                        innerIndex++;
                    } else {
                        current++;
                        innerIndex = 0;
                        index++;
                    }
                    break;
                }
                break;
            }
            return meaning;
        }

        @Override
        public boolean hasNext() {
            return current < valuesCountArray(value);
        }
    }
}



