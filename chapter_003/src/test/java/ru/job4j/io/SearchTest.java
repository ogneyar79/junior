package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchTest {

    Search search;
    List<String> lookingForExpansion;
    List<File> testFiles;
    String path;

    File rootCatalog;     // create object for our Root Catalog at temp folder

    File firstFolder;   //   first folder and  file at there
    File fileUno;       // file at first folder( it will be txt)
    File fileDos;          //   file at first folder( it will be bmp)

    File secondFolder;
    File fileTres;       //   file at second folder( it will be bmp)

    File fileRootfolder;  // file at root Catalog (it will be txt)

    @Before
    public void init() {
        search = new Search();
        lookingForExpansion = new ArrayList<>();
        lookingForExpansion.add("txt");
        testFiles = new ArrayList<>(6);
    }

    @Before
    public void createRootCatalogAndFelesAtThemAndFillUpTestFiles() throws IOException {
        path = System.getProperty("java.io.tmpdir");
        rootCatalog = new File(path);
        rootCatalog.mkdirs();

        fileRootfolder = new File(rootCatalog, "textFile_03.txt");
        fileRootfolder.createNewFile();

        firstFolder = new File(rootCatalog, "first");
        firstFolder.mkdirs();

        fileUno = new File(firstFolder, "textFile_01.txt");
        fileUno.createNewFile();
        fileDos = new File(firstFolder, "draw.bmp");
        fileDos.createNewFile();

        secondFolder = new File(rootCatalog, "secondF");
        secondFolder.mkdirs();
        fileTres = new File(secondFolder, "textFile_02.txt");
        fileTres.createNewFile();

        testFiles.add(fileRootfolder);
        testFiles.add(fileUno);
        testFiles.add(fileTres);
    }

    @Test
    public void checkReturnOurListWithFiles() {

        List<File> filesWithLookingForEX = search.files(path, lookingForExpansion);
        assertThat(filesWithLookingForEX.containsAll(testFiles), is(true));
    }
}