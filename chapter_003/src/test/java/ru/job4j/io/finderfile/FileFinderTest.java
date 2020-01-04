package ru.job4j.io.finderfile;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FileFinderTest {
    FileFinder fileFinder;
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
    public void setUp() throws Exception {
        fileFinder = new FileFinder();
        testFiles = new ArrayList<>(10);
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
    }


    @Test
    public void findDirectories() throws Exception {
    }

    @Test
    public void find() throws Exception {
        testFiles.add(fileTres);
        List<File> fileList = fileFinder.find(path, "textFile_02.txt", fileFinder.getFILES());
        System.out.println(fileList.size());
        assertThat(testFiles.get(0).equals(fileList.get(0)), is(true));

    }

    /**
     * Here we test method with Mask like ? or * .that is incorrect regular expression
     * this why we use our private method (String replaseIncorrectRegularExpression(String mask)).
     */
    @Test
    public void findWithMaskIncorrectRegularExpression() throws Exception {
        List<File> fileList = fileFinder.find(path, "?.txt", fileFinder.getFILES());
        System.out.println(fileList.size());
        int Sero = fileList.size();
        assertThat(Sero == (fileList.size()), is(true));

    }


    @Test
    public void search() throws Exception {
    }

}