package calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class CalculatorHandlerTest {
    Map<String, CalculatorM> calculatorMMap = new HashMap<String, CalculatorM>();
    CalculatorHandler calculatorHandler;
    CalculatorM calc;
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
        calc = new InteractCalc(calculatorElementary, consoleReaderImitator, validateOperator);
        calculatorHandler = new CalculatorHandler(calculatorMMap);
    }

    @Test
    public void workWithCalculator() throws Exception {
        calculatorHandler.workWithCalculator(calc);
        assertThat(calculatorHandler.workWithCalculator(calc) == 8, is(true));
    }
    @Test
    public void work(){
        calculatorMMap.put(InteractCalc.getNAME(), calc);
        String operator = InteractCalc.getNAME();
       calculatorHandler.wannaCalculatingStart(operator);
       calculatorHandler.getLastResaltCalculation();
        assertThat(calculatorHandler.getLastResaltCalculation() == 8, is(true));
    }

//    @Test
//    public void getLastResaltCalculation() throws Exception {
//        calculatorHandler.workWithCalculator(calc);
//        double result = calculatorHandler.getLastResaltCalculation();
//        assertThat(calculatorHandler.workWithCalculator() == result, is(true));
//
//    }

}