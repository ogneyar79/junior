package ru.job4j.io.finderfile;

import ru.job4j.io.chat.LogFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for manage other classes package With search file.
 */
public class HandleFinder {

//    /**
//     * Fields for constants that marker Tipe of file, that we want to find.
//     */
//    private final int FILES = 0;
//    private final int DIRECTORIES = 1;
//    private final int ALL = 2;

    LogFile logFile;

    /**
     * Field object major class.
     */
    FileFinder fileFinder;

    /**
     * Field for collecting result(different files) one or a few.
     */
    List<File> fileListFounded;

    /**
     * Field show that find file or not.
     */
    boolean fileFounded;

    /**
     * Field for handover parameters of searching(parsing).
     */
    ParametrTaskParsing parametrTaskParsing;

    /**
     * Field for parsing.
     */
    ParserStringFinder parserStringFinder;

    public HandleFinder(FileFinder fileFinder, ParserStringFinder parserStringFinder, LogFile logFile) {
        this.fileFinder = fileFinder;
        this.fileListFounded = new ArrayList<>();
        this.fileFounded = false;
        this.logFile = logFile;
        this.parserStringFinder = parserStringFinder;
    }

    /**
     * procedure searching file from directory use String[], like imitation command line.
     * if we successful set boolean fileListFounded 'true'. and fill our instance variable fileListFounded (list )found  files or file.
     *
     * @param parametrTaskParsing
     * @param argv
     * @param objectType
     */
    public void findFileFromComandString(ParametrTaskParsing parametrTaskParsing, String[] argv, int objectType) throws Exception {
        this.parserStringFinder.parseString(parametrTaskParsing, argv);
        this.fileListFounded = this.fileFinder.find(parametrTaskParsing.getDirectorySearch(), parametrTaskParsing.getNameFile(), objectType);
        if (fileListFounded.size() > 0) {
            this.setFileFounded(true);
            String pathTest = System.getProperty("java.io.tmpdir") + File.separator + "/" + parametrTaskParsing.getNameSaveResultTxt();
            this.writeFileResultToLog(pathTest);
        }
    }

//    public boolean writeFileResultToanotherFileOnHardDisk(File nameLogFile) throws IOException {
//        boolean result = false;
//        if (fileFounded) {
//            for (File file : fileListFounded) {
//                Files.lines(file.toPath(), StandardCharsets.UTF_8).forEach((String oneStringFromFile) -> {
//                    try {
//                        Files.write(nameLogFile.toPath(), oneStringFromFile.getBytes(), StandardOpenOption.APPEND);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                });
//                result = true;
//            }
//        }
//        return result;a
//    }

    public void writeFileResultToLog(String pathLog) throws IOException {

        if (this.fileFounded) {
            int quantityFiles = this.getFileListFounded().size();
            this.logFile.writeLogToArrayAndFile(" It was found " + quantityFiles + " File(s)");
        }
    }

    /**
     * function getter.
     *
     * @return fileListFounded
     */
    public List<File> getFileListFounded() {
        return fileListFounded;
    }

    /**
     * function returning boolean meaning  found file or not.
     *
     * @return isFileFounded()
     */
    public boolean isFileFounded() {
        return fileFounded;
    }

    /**
     * procedure setting.
     *
     * @param fileFounded
     */
    public void setFileFounded(boolean fileFounded) {
        this.fileFounded = fileFounded;
    }
}
