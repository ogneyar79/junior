package ru.job4j.io.chat;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ChatBrain {

    /**
     * Field logFile object for write events To log.
     */
    private LogFile logFile;

    /**
     * Field sins that need to cease answering.
     */
    private final int STOP = 0;

    /**
     * Field sins that need to finish work of chat.
     */
    private final int FINISHWORK = 1;

    /**
     * Field sins that need go on chat after STOP.
     */
    private final int GOON = 2;

    /**
     * Field that shows need to continue in usual chat work.
     */
    private final int USUALCONTINUER = 3;

    /**
     * Field where we keep Strings from file.
     */
    private List<String> basePhreases;

    /**
     * Function that fill array from file at field our object and return the same result.
     *
     * @param file File.
     * @return ArrayList<String></> result.
     */
    public List<String> fillInArray(File file) throws IOException {
        ArrayList<String> result = new ArrayList<>();

        Files.lines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8).forEach(result::add);
        this.setBasePhreases(result);

        return result;
    }

    /**
     * Function that get massage by Random Way from array and send it to chat how answer.
     *
     * @return String random result.
     */
    public String sendMassage() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.basePhreases.size());
        return getBasePhreases().get(randomIndex);
    }

    /**
     * Function that get message from console.
     *
     * @return String result that equals message from console.
     */
    public String getMassageFromChatPerson() {
        System.out.println("?????");
        Scanner scanner = new Scanner(System.in);

        String result = scanner.nextLine();
        scanner.close();
        return result;
    }

    /**
     * Function that check String dialog from console and if gives one of 4 commands set according to int Signal
     *
     * @param command String.
     * @return int result.
     */
    public int checkCommand(String command) {
        int result = 3;
        if (command.equalsIgnoreCase("Stop")) {
            result = 0;
        }
        if (command.equalsIgnoreCase("Finish")) {
            result = 1;
        }
        if ((command.equalsIgnoreCase("Continue") | command.equalsIgnoreCase(" go on"))) {
            result = 2;
        }
        return result;
    }

    /**
     * Procedure that handle work with chat accord to dialog and command.
     *
     * @param command String.
     * @return ArrayList<String></> result.
     */
    public void worckChat(String command) throws IOException {
        this.logFile.writeLogToArrayAndFile(command + "Start");
        while (!(checkCommand(command) == FINISHWORK)) {

            System.out.println(" Your Question");
            command = getMassageFromChatPerson();

            if (checkCommand(command) == USUALCONTINUER) {
                System.out.println(command);
                System.out.println(sendMassage());
            }
            if (checkCommand(command) == STOP) {
                System.out.println(command);
                logFile.writeLogToArrayAndFile(command);
                while (!(checkCommand(command) == GOON)) {
                    command = getMassageFromChatPerson();
                    System.out.println(command);
                    if (checkCommand(command) == FINISHWORK) {
                        logFile.writeLogToArrayAndFile(command);
                        return;
                    }
                }
                logFile.writeLogToArrayAndFile(command);
            }
        }
        logFile.writeLogToArrayAndFile(command);
    }

    /**
     * Function getter get field.
     *
     * @return ArrayList<String> basePhreases.
     */
    public List<String> getBasePhreases() {
        return basePhreases;
    }

    /**
     * Procedure setter out field.
     */
    public void setBasePhreases(List<String> basePhreases) {
        this.basePhreases = basePhreases;
    }


    public LogFile getLogFile() {
        return logFile;
    }

    public int getSTOP() {
        return STOP;
    }

    public int getFINISHWORK() {
        return FINISHWORK;
    }

    public int getGOON() {
        return GOON;
    }

    public int getUSUALCONTINUER() {
        return USUALCONTINUER;
    }

    public static void main(String[] args) {
        ChatBrain chatBrain = new ChatBrain();
        chatBrain.getMassageFromChatPerson();
    }
}
