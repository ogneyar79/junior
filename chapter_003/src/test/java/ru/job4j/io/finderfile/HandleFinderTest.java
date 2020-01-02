package ru.job4j.io.finderfile;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.io.chat.LogFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HandleFinderTest {

    FileFinder fileFinder;
    List<File> testFiles;
    String path;
    File rootCatalog;     // create object for our Root Catalog at temp folder

    LogFile logFile;
    String infoFirst;
    String infoTwo;
    ArrayList<String> infoListTest;


    File firstFolder;   //   first folder and  file at there
    File fileUno;       // file at first folder( it will be txt)
    File fileDos;          //   file at first folder( it will be bmp)

    File secondFolder;
    File fileTres;       //   file at second folder( it will be bmp)

    File fileRootfolder;  // file at root Catalog (it will be txt)

    ParserStringFinder parserStringFinder;
    ParametrTaskParsing parametrTaskParsing;
    HandleFinder handleFinder;

    @Before
    public void setUp() throws Exception {
        fileFinder = new FileFinder();
        testFiles = new ArrayList<>(10);


        infoFirst = new String("Stop");
        infoTwo = new String("GO");
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
    public void findFileFromComandString() throws Exception {
    }

    @Test
    public void writeFileResultToanotherFileOnHardDisk() throws Exception {
        String[] argv = new String[]{"-d", path, "-n", "textFile_02.txt", "-m", "-o", "log.txt"};
        ArrayList<String> testList = new ArrayList();
        infoListTest = new ArrayList<>();
        parametrTaskParsing = new ParametrTaskParsing();
        parserStringFinder = new ParserStringFinder(parametrTaskParsing);
        String pathTest = System.getProperty("java.io.tmpdir") + File.separator + "/" + parametrTaskParsing.getNameSaveResultTxt();
        File testFile = new File(pathTest);
        testFile.createNewFile();
        LogFile testLog = new LogFile(pathTest, testList, testFile);

        handleFinder = new HandleFinder(fileFinder, parserStringFinder, testLog);

        handleFinder.findFileFromComandString(parametrTaskParsing, argv, fileFinder.getFILES());
        assertThat(testLog.getFileOurLog().exists(), is(true));
        System.out.println(infoListTest.size());

        System.out.println(testLog.getLogList().size());

        Files.lines(Paths.get(testLog.getFileOurLog().getAbsolutePath()), StandardCharsets.UTF_8).forEach(infoListTest::add);
        Files.lines(Paths.get(testLog.getFileOurLog().getAbsolutePath()), StandardCharsets.UTF_8).forEach(System.out::println);
        assertThat(testLog.getLogList().size(), is(infoListTest.size()));

        testLog.getFileOurLog().delete();

    }

}