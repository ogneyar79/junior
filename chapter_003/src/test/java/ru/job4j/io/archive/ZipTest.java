package ru.job4j.io.archive;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ZipTest {

    List<File> source;
    Zip zipClass;
    String[] arguuments;

    String path;
    String exceptionExpension;
    String outDerictoryDestination;

    File rootCatalog;

    // File includes textFile_03.txt.
    File fileRootfolder;

    File zipFile;

    File firstFolder;
    File fileUno;
    File fileDos;

    File secondFolder;
    File fileTres;

    List<File> testFiles;

    @Before
    public void setUp() throws Exception {
        outDerictoryDestination = (System.getProperty("java.io.tmpdir") + File.separator + "/pr.zip");
        path = (System.getProperty("java.io.tmpdir") + File.separator + "/testcaseFirst");
        rootCatalog = new File(path);
        rootCatalog.mkdirs();
        zipFile = new File(outDerictoryDestination);
        zipFile.mkdirs();


        exceptionExpension = "zip";

        fileRootfolder = new File(rootCatalog, "textFile_03.txt");
        fileRootfolder.createNewFile();

        firstFolder = new File(rootCatalog, "first");
        firstFolder.mkdirs();

        fileUno = new File(firstFolder, "textFile_01.txt");
        fileUno.createNewFile();
        fileDos = new File(firstFolder, "abc.zip");
        fileDos.createNewFile();

        secondFolder = new File(rootCatalog, "secondF");
        secondFolder.mkdirs();
        fileTres = new File(secondFolder, "textFile_02.txt");
        fileTres.createNewFile();


        testFiles = new ArrayList<>(8);
        testFiles.add(fileRootfolder);
        testFiles.add(fileUno);
        testFiles.add(fileTres);

        arguuments = new String[]{"-d", path, "-e", exceptionExpension, "-o", outDerictoryDestination};

        zipClass = new Zip(new Args(arguuments));
        source = zipClass.seekBy(zipClass.argument.getDirectorySource(), zipClass.argument.getExceptionExpension());

    }

    @Test
    public void seekBy() throws Exception {
    }

    @Test
    public void pack() throws Exception {
    }

    @Test
    public void packZip() throws Exception {
      zipClass.packZip(zipClass.argument.getDirectorySource(), zipClass.argument.getOutDerictoryDestination());

    }


}