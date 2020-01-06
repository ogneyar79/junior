package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateOperatorTest {

    ValidateOperator validateOperator;
    char operation = '*';
    char operationNonCorrect = '2';

    @Before
    public void setUp() throws Exception {
        validateOperator = new ValidateOperator();
    }

    @Test
    public void checkOperation() throws Exception {

        assertThat(validateOperator.checkOperation(operation), is(true));
        assertThat(validateOperator.checkOperation(operationNonCorrect), is(false));
    }
}