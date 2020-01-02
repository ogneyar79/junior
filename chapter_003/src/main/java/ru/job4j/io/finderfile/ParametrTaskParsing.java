package ru.job4j.io.finderfile;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for handover parameters for searching.
 */
public class ParametrTaskParsing {

    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = {"-d", "-directorySearch"}, description = "Directory Where from we begin searching")
    private String directorySearch;

    @Parameter(names = {"-n", "-nameFile"}, description = "Name file that we look for")
    private String nameFile;

    @Parameter(names = {"-o", "-nameSaveResultTxt"}, description = "File Where we write result")
    private String nameSaveResultTxt;


    public List<String> getParameters() {
        return parameters;
    }

    public String getDirectorySearch() {
        return directorySearch;
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getNameSaveResultTxt() {
        return nameSaveResultTxt;
    }

    public static void main(String... args) {
        ParametrTaskParsing parametrTaskParsing = new ParametrTaskParsing();

        System.out.println(parametrTaskParsing.getNameFile());


    }


}
