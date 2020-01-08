package calculator;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InteractCalcTest {
    char operationOne;
    char operationTwo;
    double numOne;
    double numTwo;
    CalculatorElementary calculatorElementary;
    InteractCalc interactCalc;
    ConsolReaderForCalc consolReader;
    ValidateOperator validation;

    @Before
    public void setUp() throws Exception {
        calculatorElementary = new CalculatorElementary();
        interactCalc = new InteractCalc(calculatorElementary, consolReader, validation);
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

    @Test
    public void checStartConsoleMethod() {
        ConsolReaderForCalc consolReader = mock(ConsolReaderForCalc.class);
        when(consolReader.getDouble()).thenReturn((double) 4);
        when(consolReader.getOperation()).thenReturn('+');
        calculatorElementary = new CalculatorElementary();
        validation = new ValidateOperator();
        interactCalc = new InteractCalc(calculatorElementary, consolReader, validation);
        interactCalc.startConsoleCalc();
        interactCalc.getResult();
        assertThat(interactCalc.getResult() == 8, is(true));
    }

}