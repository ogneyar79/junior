package cash;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CashMapTest {

    CashMap<String, String> cashMap = new CashMap();
    String key = "Files.txt";
    String vulue = "Files.txt";
    String keyNull = "";
    @Before
    public void setUp() {
        cashMap.put(key, vulue);
        cashMap.put(keyNull, null);
    }

    @Test
    public void checkGetValue() {
        String actual = cashMap.get(key);
        String expected = "Files.txt";
        assertThat(expected, is(actual));
    }

    @Test
    public void checkGetIfValueNull() {
        String actual = cashMap.get(keyNull);
        assertThat(null, is(actual));
    }
}