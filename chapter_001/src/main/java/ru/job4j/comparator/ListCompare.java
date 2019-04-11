package ru.job4j.comparator;

import java.util.Comparator;
import java.util.List;

public class ListCompare implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        return left.equals(right) ? 0 : left.size() - right.size() == 0 ? 1 : -1;
    }


    public class ListCorrectCompare implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            ListCompare first = new ListCompare();
            int compareNumber;
            int result = 0;
            compareNumber = first.compare(o1, o2);
            if (compareNumber == 0) {
                result = 0;
            } else if (compareNumber == 1) {
                int i = 0;
                for (Integer o : o1) {
                    if (o > o2.get(i)) {
                        result = 1;
                        break;
                    } else if (o < o2.get(i)) {
                        result = -1;
                        break;
                    } else {
                        i++;
                    }

                    result = 0;
                }
            } else {
                int s = Math.abs(o1.size() - o2.size());
                for (int i = 0; i < s - 1; i++) {
                    if (o1.get(i) > o2.get(i)) {
                        result = 1;
                        break;
                    } else if (o1.get(i) > o2.get(i)) {
                        result = -1;
                        break;
                    } else if (o1.get(i) == o2.get(i)) {
                        return o1.size() > o2.size() ? 1 : -1;
                    }
                }

            }


            return result;
        }
    }
}