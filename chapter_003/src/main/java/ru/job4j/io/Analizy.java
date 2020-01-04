package ru.job4j.io;

import java.io.*;

/**
 * The class for analysis log file.
 *
 * @author Maksim Sirotkin(maksimus.s@mail.ru)
 * @version 0.1$
 * @since 0.1
 * 28.10.2019
 */
public class Analizy {

    /**
     * Field boolean that show, we hava data for analys or not.
     */
    private Boolean dataForAnalisIs = false;

    /**
     * Function returned from map value via key.
     *
     * @return Boolean dataForAnalisIs.
     */
    public Boolean getDataForAnalisIs() {
        return dataForAnalisIs;
    }

    /**
     * Function returned StringBuilder from  BufferedReader object.
     *
     * @param read BufferedReader.
     * @return StringBuilder result.
     */
    public StringBuilder createAnalizFromBuferReaderToSb(BufferedReader read) throws IOException {
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = read.readLine()) != null) {
            if (line.contains("400") | line.contains("500")) {
                dataForAnalisIs = true;
                int temp = line.contains("400") ? line.lastIndexOf("400") : line.lastIndexOf("500");
                result.append(" Begining Of Period ");
                result.append(line.substring(temp));

                line = read.readLine();
                while (true) {
                    if (!(line.contains("400") | line.contains("500"))) {
                        result.append(" End Of Period ");
                        result.append(line.substring(temp));
                        result.append(System.lineSeparator());
                        break;
                    }
                    line = read.readLine();
                }
            }
        }
        return result;
    }

    /**
     * procedure for sending StringBuilder to file on hard Disk.
     *
     * @param model  StringBuilder.
     * @param target String, where we want to write.
     */
    public void sendOutfileWriter(StringBuilder model, String target) throws IOException {
        File file = new File(target);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(file)) {
        }) {
            printWriter.write(model.toString());
        }
    }

    /**
     * procedure for sending StringBuilder to file on hard Disk.
     *
     * @param source String that is the path to file on hard disk file to transfer.
     * @param target String, where we want to write our file.
     */
    public void unavailable(String source, String target) throws IOException {

        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            StringBuilder ourLog = this.createAnalizFromBuferReaderToSb(read);
            if (dataForAnalisIs) {
                this.sendOutfileWriter(ourLog, target);
            } else {
                this.sendOutfileWriter(new StringBuilder("No ceaseTion working of Server"), target);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int a = 2;
        System.out.println(a);
        while (a < 10) {
            a++;
            System.out.println(a);
        }
        System.out.println(a);

        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
