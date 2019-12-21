package ru.job4j.io.chat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogFile {

    private final String path;
    private ArrayList<String> logList;
    private File fileOurLog;


    public LogFile(String path, ArrayList<String> logList, File fileOurLog) {
        this.path = path;
        this.logList = logList;
        this.fileOurLog = fileOurLog;
    }

    /**
     * The konstructor create object and init in them
     */
    public LogFile() {
        logList = new ArrayList<>();
        this.path = System.getProperty("java.io.tmpdir") + File.separator + "/logchat.txt";
        fileOurLog = this.create(path);
    }

    public LogFile(String path) {
        this.path = path;
    }

    /**
     * procedure create new File at our object with this.path.
     *
     * @param path String
     */
    private File create(String path) {
        File creator = new File(path);
        try {
            creator.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return creator;
    }

    public void setLogList(ArrayList<String> logList) {
        this.logList = logList;
    }

    /**
     * Function wrete String to log File and This.ArrayList.
     *
     * @param info String that we want to write To log.
     */
    public Boolean writeLogToArrayAndFile(String info) throws IOException {
        Boolean result = false;
        StringBuilder stringBuilder = new StringBuilder(info);

        String intern = String.valueOf(stringBuilder.append("  current datetime : " + LocalDateTime.now()));
        this.logList.add(intern);
        stringBuilder.append("Number at Array : " + logList.indexOf(intern) + "\n");
        String logPlusNumerAtList = String.valueOf(stringBuilder);
        Files.write(this.fileOurLog.toPath(), logPlusNumerAtList.getBytes(), StandardOpenOption.APPEND);
        return result;
    }

    public String getPath() {
        return path;
    }

    public List<String> getLogList() {
        return logList;
    }

    public File getFileOurLog() {
        return fileOurLog;
    }

    public void setFileOurLog(File fileOurLog) {
        this.fileOurLog = fileOurLog;
    }

}
