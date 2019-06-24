package ru.job4j.magnit;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParserCountSumBySaxTest {

    File file = new File("C:\\projects\\sirotkinmaksim\\chapter_002\\src\\main\\resources\\convertedFile.xml");
    ParserCountSumBySax parserSum = new ParserCountSumBySax();

    @Test
    public void CheckParseSumBySax() throws Exception {
        parserSum.parseCountSumFromXmlBySax(file);

        Long sum =parserSum.parseCountSumFromXmlBySax(file);

        assertThat(sum, is(3L));

    }
}