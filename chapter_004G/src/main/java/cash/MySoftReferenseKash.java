package cash;


import java.io.File;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import ru.job4j.io.Search;


public class MySoftReferenseKash {

    final private CashMap cashMap;
    final private String pathCatalog;

    public MySoftReferenseKash(CashMap cashMap, String pathCatalog) {
        this.cashMap = cashMap;
        this.pathCatalog = pathCatalog;
    }

    /**
     * method look for file from apropriate folder.
     *
     * @param name String File name.
     * @return result File.
     * @throws NoFileExeption
     */
    public File findFile(String name) throws NoFileExeption {
        File result = null;
        List<File> files = new Search().filesAll(pathCatalog);
        for (File file : files) {
            if (file.getName().equals(name)) {
                result = file;
            }
        }
        if (result == null) {
            throw new NoFileExeption(" No FILEwithTHISnAME");
        }
        return result;
    }

    /**
     * Method reading from Text file and input to console.
     *
     * @param file File .
     * @return String result.
     */
    public String readFile(File file) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(String.valueOf(file.toPath())), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            System.out.println(line);
        }

        return lines.toString();
    }

    /**
     * metod getting text from text file. if file no cashMap we look for folder if no there Exception.
     *
     * @param name String, File name.
     * @return String result.
     * @throws IOException
     * @throws InvocationTargetException
     */
    public String getTextFromFile(String name) throws IOException, InvocationTargetException {
        String result = "";
        if (cashMap.get(name) == null) {
            try {
                File file = this.findFile(name);
                cashMap.put(name, readFile(file));
                result = (String) cashMap.get(name);
            } catch (NoFileExeption noFileExeption) {
                noFileExeption.printStackTrace();
            }
        } else {
            result = (String) cashMap.get(name);
        }
        return result;
    }

}
