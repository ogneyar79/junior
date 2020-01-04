package ru.job4j.io.finderfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFinder {

    /**
     * Fields for object of Class for Regular expression.
     */
    private Pattern p = null;
    private Matcher m = null;

    /**
     * Fields for constants that marker Tipe of file, that we want to find.
     */
    private static final int FILES = 0;
    private static final int DIRECTORIES = 1;
    private static final int ALL = 2;

    /**
     * Creator that producing new example of our class.
     */
    public FileFinder() {
    }

//    private List find(String startPath, String mask, int objectType){
//        List <File> listResult = new ArrayList<>();
//        listResult.isEmpty();
//
//        return listResult;
//    }
//    private void search(File topDirectory, List res, int objectType){
//
//    }

    /**
     * Function realize lookingFor All object (files and directories), from given start directory(startPath).
     *
     * @param startPath String  beginning search directory.
     * @return List найденных объектов
     * @throws java.lang.Exception
     */
    public List findAll(String startPath) throws Exception {
        return find(startPath, "", ALL);
    }

    /**
     * Function realize lookingFor All object (files and directories), from given start directory(startPath),
     * with according to regress expression (mask).
     *
     * @param startPath start directory.
     * @param mask      regress expression about file.
     * @return List that we find.
     * @throws java.lang.Exception если возникли ошибки в процессе поиска
     */
    public List findAll(String startPath, String mask)
            throws Exception {
        return find(startPath, mask, ALL);
    }

    /**
     * Function realize lookingFor All directories from given start directory(startPath).
     *
     * @param startPath start directory.
     * @return List that we find.
     * @throws java.lang.Exception
     */
    public List findDirectories(String startPath)
            throws Exception {
        return find(startPath, "", DIRECTORIES);
    }

    /**
     * Function realize lookingFor All directories(folders) from given start directory(startPath).
     * with according to regress expression (mask).
     *
     * @param startPath start directory.
     * @param mask      regress expression about directories.
     * @return List that we find.
     * @throws java.lang.Exception если возникли ошибки в процессе поиска
     */
    public List findDirectories(String startPath, String mask)
            throws Exception {
        return find(startPath, mask, DIRECTORIES);
    }

    /**
     * Function check,Equivalence of file's name to regress expression.
     *
     * @return true or false.
     */
    private boolean accept(String name) {
        boolean result = true;
        if (p == null) {   //if there no regress expression
            return result; //...it means object according to
        } else {
            m = p.matcher(name); //create Matcher and check it's true if name is Equivalent.
            return m.matches();
        }
    }

    /**
     * Function that substitute mask like *or ?.txt on correct regular expression.
     *
     * @param mask String  that need be checked if at first part name file we have *or? in that we change it.
     * @return result String corrected
     */
    private String replaseIncorrectRegularExpression(String mask) {
        String result = mask;
        String delimeter = "\\.";
        String[] substring = mask.split(delimeter);
        System.out.println(substring.length);
        System.out.println(substring[0]);
        System.out.println(substring[1]);
        if (substring[0].contains("*") || substring[0].contains("?")) {
            result = ".*." + substring[1];
            System.out.println(result);
        }
        return result;
    }

    /**
     * Function make search at beginning, then set method search for ending search.
     *
     * @param startPath   start directory for searching.
     * @param mask        regress expression about file
     * @param objectType, marker type of object, file, or folder, or all from them
     * @return result  List
     */
    public List find(String startPath, String mask, int objectType) throws Exception {
        //проверка параметров
        if (startPath == null || mask == null) {
            throw new Exception("Ошибка: не заданы параметры поиска");
        }
        File topDirectory = new File(startPath);
        if (!topDirectory.exists()) {
            throw new Exception("Ошибка: указанный путь не существует");
        }
        //если задано регулярное выражение, создаем Pattern
        if (!mask.equals("")) {
            mask = this.replaseIncorrectRegularExpression(mask);
            p = Pattern.compile(mask,
                    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        }
        ArrayList result = new ArrayList(100);  //   //создаем список результатов  // and searching
        search(topDirectory, result, objectType);

        p = null;   //присваиваем null шаблону, т.к. при следующем вызове find... //регулярное выражение может быть не задано

        if (result.size() < 1) {
            System.out.println(" File has not found");
        }
        return result;
    }

    /**
     * Function realize lookingFor object that we want at found directories.
     * if, we run into nested directory (folder) we use recursion, results we save  at List result.
     * The current directory - topDirectory.
     * type of objects (file or directory) - objectType.
     */
    public void search(File topDirectory, List res, int objectType) {
        File[] list = topDirectory.listFiles();   // getting list of all objects in current directory
        //looking through all objects
        for (File fileF : list) {

            //if it's directory (folder)...
            if (fileF.isDirectory()) {
                //...check на equivalence of type object and regular expression
                if (objectType != FILES && accept(fileF.getName())) {

                    res.add(fileF);  //add current objects at LIst of result a
                }
                search(fileF, res, objectType);    //выполняем поиск во вложенных директориях
            } else {  //if It's file
                // check на equivalence of type object and regular expression
                if (objectType != DIRECTORIES && accept(fileF.getName())) {
                    res.add(fileF);  //add current objects at LIst of result a
                }
            }
        }
    }


    public int getFILES() {
        return FILES;
    }

    public int getDIRECTORIES() {
        return DIRECTORIES;
    }

    public int getALL() {
        return ALL;
    }
}
