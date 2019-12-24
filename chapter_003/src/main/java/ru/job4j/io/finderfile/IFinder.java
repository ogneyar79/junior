package ru.job4j.io.finderfile;

import java.io.File;

public interface IFinder {

    public boolean lookFor(String fileName, String parent);

    public File lookingFor(String fileName, String parent);

    public File findFileByMaska(String startPath, String mask);

}
