package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class AnalizyTest {

    public Analizy analizy;

    String source = Analizy.class.getResource("/serverLog.txt").getFile();
    String target = "C:\\projects\\sirotkinmaksim\\chapter_003\\src\\main\\resources\\target.csv";
    String empty = Analizy.class.getResource("/empty.txt").getFile();

    StringBuilder checkingSBuilder;

    public StringBuilder createStingBulderForChecking() {
        StringBuilder rezult = new StringBuilder(50);
        rezult.append(" Begining Of Period 400 10:58:01 End Of Period 200 10:59:01");
        rezult.append(System.lineSeparator());
        rezult.append(" Begining Of Period 500 11:01:02 End Of Period 200 11:02:02");
        rezult.append(System.lineSeparator());
        rezult.append(" Begining Of Period 500 11:02:04 End Of Period 200 11:02:08");
        rezult.append(System.lineSeparator());
        System.out.println(rezult.toString());
        return rezult;
    }

    @Before
    public void init() {
        analizy = new Analizy();
        checkingSBuilder = createStingBulderForChecking();
    }

    @Test
    public void createStringBuilderFromBuferReader() {
        String line;
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            StringBuilder builder = analizy.createAnalizFromBuferReaderToSb(read);
            assertEquals(checkingSBuilder.toString(), builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkRiteOut() throws IOException {
        StringBuilder model = checkingSBuilder;
        System.out.println(model.toString());
        analizy.sendOutfileWriter(model, target);
    }

    @Test
    public void unvailableConsistTwoConecteMethodChectedTheirConection() throws IOException {

        analizy.unavailable(empty, target);

        assertThat(false, is(analizy.getDataForAnalisIs()));

    }

}