package ru.job4j.io.finderfile;

import com.beust.jcommander.JCommander;

/**
 * Class for parsing command line or her imitation via JCommander jCommander.
 */
public class ParserStringFinder implements IParserStringF {

    /**
     * Field for handover parameters of searching(parsing).
     */
    ParametrTaskParsing parametrTaskParsing;


    public ParserStringFinder(ParametrTaskParsing parametrTaskParsing) {
        this.parametrTaskParsing = parametrTaskParsing;

    }

    @Override
    public void parseString(ParametrTaskParsing parametTaskParsing, String[] argv) {
        JCommander jCommander = JCommander.newBuilder().addObject(this.parametrTaskParsing).build();
        jCommander.parse(argv);

    }

    public static void main(String... args) {
        ParametrTaskParsing parametrTaskParsing = new ParametrTaskParsing();
        String[] argv = new String[]{"-d", "c:/", "-n", "*.txt", "-m", "-o", "log.txt"};
        ParserStringFinder parserStringFinder = new ParserStringFinder(parametrTaskParsing);
        parserStringFinder.parseString(parametrTaskParsing, argv);
        System.out.println(parametrTaskParsing.getNameFile() + "  " + parametrTaskParsing.getDirectorySearch());
    }
}
