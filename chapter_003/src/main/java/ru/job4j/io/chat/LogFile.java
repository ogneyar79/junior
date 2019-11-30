package ru.job4j.io.chat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogFile {

    private final String path;
    private ArrayList<String> logList;
    private File fileOurLog;

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
    public Boolean writeLogToArrayAndFile(String info) {
        Boolean result = false;
        String logPlusTime = " info " + " current datetime : " + LocalDateTime.now();
        this.logList.add(logPlusTime);
        String logPlusNumerAtList = logPlusTime + "Number at Array : " + logList.indexOf(logPlusTime);
        try {
            new FileWriter(this.getFileOurLog()).write(logPlusNumerAtList);
            System.out.println("Successfully wrote to the file.");
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
