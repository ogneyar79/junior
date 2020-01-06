package calculator;

import org.junit.Before;
import org.junit.Test;

import static java.lang.System.out;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;


public class CalculatorHandlerTest {
    CalculatorHandler calculatorHandler;
    ICalculatorConsole calc;
    CalculatorElementary calculatorElementary;
    ValidateOperator validateOperator;
    //  ConsolReaderForCalc consolReaderForCalc;


    @Before
    public void setUp() throws Exception {
        ConsolReaderForCalc consoleReaderImitator = mock(ConsolReaderForCalc.class);
        when(consoleReaderImitator.getDouble()).thenReturn((double) 4);
        when(consoleReaderImitator.getOperation()).thenReturn('+');

        validateOperator = new ValidateOperator();
        calculatorElementary = new CalculatorElementary();
        calc = new InteractCalc(calculatorElementary);
        calculatorHandler = new CalculatorHandler(calc, validateOperator, consoleReaderImitator);
    }

    @Test
    public void workWithCalculator() throws Exception {
        calculatorHandler.workWithCalculator();
        assertThat(calculatorHandler.workWithCalculator() == 8, is(true));

    }

    @Test
    public void getLastResaltCalculation() throws Exception {
        calculatorHandler.workWithCalculator();
        double result = calculatorHandler.getLastResaltCalculation();
        assertThat(calculatorHandler.workWithCalculator() == result, is(true));

    }

}