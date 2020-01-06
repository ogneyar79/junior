package calculator;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class InteractCalcTest {
    char operationOne;
    char operationTwo;
    double numOne;
    double numTwo;
    CalculatorElementary calculatorElementary;
    InteractCalc interactCalc;

    @Before
    public void setUp() throws Exception {
        calculatorElementary = new CalculatorElementary();
        interactCalc = new InteractCalc(calculatorElementary);
        operationOne = '+';
        operationTwo = '/';
    }

    @Test
    public void checkCalkAdd() {
        numOne = 4;
        numTwo = 8;

        double result = interactCalc.calc(numOne, numTwo, operationOne);
        assertThat(result == 12, is(true));
    }
    @Test
    public void checkCalkDivide() {
        numOne = 8;
        numTwo = 2;
        double result = interactCalc.calc(numOne, numTwo, operationTwo);
        assertThat(result == 4, is(true));
    }
}