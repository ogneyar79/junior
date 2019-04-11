package ru.job4j.tasksortdeparament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class DepartmentTask {

    public static class Depart {
        List<String> names = new ArrayList<>();

        public Depart(List<String> names) {
            this.names = names;
        }

        public static void main(String[] args) {
            Depart left = new Depart(
                    Arrays.asList("k2")
            );
            Depart right = new Depart(
                    Arrays.asList("k2", "sk2")
            );
            compare(left, right);
        }

        public static int compare(Depart left, Depart right) {
            int res = 0;

            while (!left.equals(right)) {
                int s = Math.abs(left.names.size() - right.names.size());

                for (int i = 0; i < s - 1; i++) {
                    if (left.names.get(i).compareTo(right.names.get(i)) == 1) {
                        res = 1;
                        break;
                    } else if (left.names.get(i).compareTo(right.names.get(i)) == -1) {
                        res = -1;
                        break;
                    } else {
                        if (i == s - 1 && left.names.get(i).compareTo(right.names.get(i)) == 0) {
                            return left.names.size() > right.names.size() ? 1 : -1;
                        }
                        i++;
                    }
                }
            }
            return res;
        }

    }
}

