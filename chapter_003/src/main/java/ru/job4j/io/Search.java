package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {

    /**
     * Function  returning List files from catalog without folders
     *
     * @param parent String The way to catalog
     * @return result is List files is found as result.
     */
    private List<File> filesAll(String parent) {
        List<File> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                System.out.println(file.listFiles().length);
                System.out.println(file.getName() + "  \t folder");
                for (File deep : file.listFiles()) {
                    queue.offer(deep);
                }
            } else if (file.isFile()) {
                result.add(file);
            }
        }
        return result;
    }




    /**
     * Function of looking for a list of files with expansion inner  method we use private method filesAll() returning files from catalog without folder
     *
     * @param parent    String The way to catalog
     * @param expansion List expansion our files that we looking for.
     * @return result is List files is found as result.
     */
    public List<File> filesNewVersion(String parent, List<String> expansion) {
        List<File> listFiles = filesAll(parent);
        List<File> result = new ArrayList<>();
        for (File file : listFiles) {
            if (checkIdentityExts(file, expansion)) {
                result.add(file);
            }
        }
        return result;
    }

    /**
     * Function of looking for a list of files withOut expansion inner  method we use private method filesAll() returning files from catalog without folder
     *
     * @param parent    String The way to catalog
     * @param expansion String expansion file with this we need to except.
     * @return result is List files is found as result.
     */
    public List<File> filesWithOutExpansion(String parent, String expansion) {
        List<File> listFiles = filesAll(parent);
        List<File> result = new ArrayList<>();
        for (File file : listFiles) {
            List<String> arrayExpansion = new ArrayList<>(1);
            arrayExpansion.add(expansion);
            if (file.isFile() && !(checkIdentityExts(file, arrayExpansion))) {
                result.add(file);
            }
        }
        return result;
    }


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
                System.out.println(file.listFiles().length);
                //    System.out.println(file.getName() + "  \t folder");
                for (File deep : file.listFiles()) {
                    queue.offer(deep);
                }
            } else if (this.checkIdentityExts(file, expansion)) {
                result.add(file);
                //       System.out.println(file.getName() + "\t file");
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
        if (file.isFile()) {
            for (String eXp : expansion) {
                if (file.getName().endsWith(eXp)) {
                    result = true;
                }
            }
        }
        return result;
    }
}
