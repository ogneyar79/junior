package ru.job4j.io.chat;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LogFileTest {

    LogFile logFile;
    String infoFirst;
    String infoTwo;
    ArrayList<String> infoListTest;

    @Before
    public void setUp() throws Exception {
        infoListTest = new ArrayList<>();
        logFile = new LogFile();
        infoFirst = new String("Stop");
        infoTwo = new String("GO");
    }

    @Test
    public void writeLogToArray() throws Exception {
        logFile.writeLogToArrayAndFile(infoFirst);
        logFile.writeLogToArrayAndFile(infoTwo);
        System.out.println(logFile.getLogList().get(0));
        assertThat(logFile.getLogList().size(), is(2));
    }

    @Test
    public void writeLogToFile() throws IOException {
        String pathTest = System.getProperty("java.io.tmpdir") + File.separator + "/testlogchat.txt";
        ArrayList<String> testList = new ArrayList();
        File testFile = new File(pathTest);
        testFile.createNewFile();
        LogFile testLog = new LogFile(pathTest, testList, testFile);
        testLog.writeLogToArrayAndFile(infoFirst);
        testLog.writeLogToArrayAndFile(infoTwo);
        assertThat(testLog.getFileOurLog().exists(), is(true));

        Files.lines(Paths.get(testLog.getFileOurLog().getAbsolutePath()), StandardCharsets.UTF_8).forEach(infoListTest::add);
        Files.lines(Paths.get(testLog.getFileOurLog().getAbsolutePath()), StandardCharsets.UTF_8).forEach(System.out::println);

        assertThat(testLog.getLogList().size(), is(infoListTest.size()));
        testLog.getFileOurLog().delete();
    }

}