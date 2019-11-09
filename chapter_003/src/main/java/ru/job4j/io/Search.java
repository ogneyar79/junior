package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {

    /**
     * Function of looking for a list of files with expansion
     *
     * @param parent    String The way to catalog
     * @param expansion List expansion our files that we looking for.
     * @return result is List files is found as result.
     */
    public List<File> files(String parent, List<String> expansion) {
        List<File> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                System.out.println(file.getName() + "  \t folder");
                for (File deep : file.listFiles()) {
                    queue.offer(deep);
                }
            }
            if (file.isFile() && this.checkIdentityExts(file, expansion)) {
                result.add(file);
                System.out.println(file.getName() + "\t file");
            }
        }
        return result;
    }

    /**
     * Function check equivalence file to desired by check expansion
     *
     * @return result boolean if desired expansion is at file or not.
     */
    private boolean checkIdentityExts(File file, List<String> expansion) {

        boolean result = false;
        for (String eXp : expansion) {
            if (file.getName().endsWith(eXp)) {
                result = true;
            }
        }
        return result;
    }
}
