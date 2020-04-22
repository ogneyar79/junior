package cash;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MySoftReferenseKashTest {


    CashMap<String, String> cashMap = new CashMap<>();
    String pathCatalog = "C:\\Users\\Дом\\IdeaProjects\\junior\\chapter_004G\\src\\main\\resources\\textcashfiles";
    File rootCatalog;

    File adress;
    String adressPath = "C:\\Users\\Дом\\IdeaProjects\\junior\\chapter_004G\\src\\main\\resources\\textcashfiles\\adress.txt";
    File names;
    File phone;
    MySoftReferenseKash mySoftRef;
    ArrayList<File> files = new ArrayList<>();

    @Before
    public void setUp() {
        rootCatalog = new File(pathCatalog);
        adress = new File(rootCatalog, adressPath);
        //  rootCatalog.mkdirs();
        mySoftRef = new MySoftReferenseKash(cashMap, pathCatalog);
    }

    /**
     * We lool for file at catalog.
     *
     * @throws NoFileExeption
     */
    @Test
    public void findFile() throws NoFileExeption {
        files.add(mySoftRef.findFile("adress.txt"));
        assertThat(files.size(), is(1));
    }

    /**
     * try get Exception when file is not catalog.
     */
    @Test
    public void findFileWhenFileNoAtCatalog() {
        try {
            mySoftRef.findFile(" Flight.txt");
            fail();
        } catch (NoFileExeption noFileExeption) {
            noFileExeption.printStackTrace();
        }
    }

    /**
     * Read text from file which find at catalog.
     *
     * @throws NoFileExeption
     * @throws IOException
     * @throws InvocationTargetException
     */
    @Test
    public void readFile() throws NoFileExeption, IOException, InvocationTargetException {
        files.add(mySoftRef.findFile("adress.txt"));

        File fileY = files.get(0);
        System.out.println(fileY);
        String mesageFile = mySoftRef.readFile(fileY);
        System.out.println(mesageFile);

        String expected = "[MATVIEVSKOGO]";
        assertEquals(expected, mesageFile);
    }


    /**
     * agregate method first find file if there no at our map and then find it our catalog and load to our cash(cashMap) and take text from our cash.
     *
     * @throws IOException
     * @throws InvocationTargetException
     */
    @Test
    public void getTextWhenFileNoAtMapAndThenWhenAlreadyFileIsAtMap() throws IOException, InvocationTargetException {
        String result = " ";
        try {
            result = mySoftRef.getTextFromFile("adress.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String expected = "[MATVIEVSKOGO]";
        assertEquals(expected, result);
        String resultSame = mySoftRef.getTextFromFile("adress.txt");
        assertEquals(expected, resultSame);
    }

}