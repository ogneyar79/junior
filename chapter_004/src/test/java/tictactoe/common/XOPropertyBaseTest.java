package tictactoe.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class XOPropertyBaseTest {
    @Test
    public void generateInstance() throws Exception {
        final IXOProperty testInstance = XOPropertyBase.generateInstance();
        assertNotNull(testInstance);
    }

    @Test
    public void getSeparatorCharacter() throws Exception {
        final Character expected = '~';
        final IXOProperty test = XOPropertyBase.generateInstance();
        final Character result = test.getSeparatorCharacter();
        assertEquals(expected, result);
    }

}