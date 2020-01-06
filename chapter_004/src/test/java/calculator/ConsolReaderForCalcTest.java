package calculator;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConsolReaderForCalcTest {
    ConsolReaderForCalc consolReaderForCalc;
    Scanner scanner;
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void getDouble() throws Exception {
        ByteArrayInputStream input = new ByteArrayInputStream(Joiner.on(LN).join("s",
                "1").getBytes());
        System.setIn(input);
        scanner = new Scanner(System.in);
        consolReaderForCalc = new ConsolReaderForCalc();
        System.out.println(scanner);
        System.out.println(consolReaderForCalc.getScanner().toString());
        double result = consolReaderForCalc.getDouble();

        assertThat(result == 1, is(true));

    }
    @Test
    public void getOperation() throws Exception {
        ByteArrayInputStream input = new ByteArrayInputStream(Joiner.on(LN).join('*',
                '*').getBytes());
        System.setIn(input);
        scanner = new Scanner(System.in);
        consolReaderForCalc = new ConsolReaderForCalc();
        char result = consolReaderForCalc.getOperation();
        assertThat(result == '*', is(true));
    }

}