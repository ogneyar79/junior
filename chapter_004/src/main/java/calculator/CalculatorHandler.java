package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class for work with calculator.
 */
public class CalculatorHandler {

    Map<String, CalculatorM> calculatorMMap = new HashMap<String, CalculatorM>();

    /**
     * Field fo saving results operation.
     */
    private final ArrayList<Double> resultsCalculation = new ArrayList<Double>();

    /**
     * Constructor our class.
     */
    public CalculatorHandler(final Map<String, CalculatorM> calculatorMMap) {
        this.calculatorMMap = calculatorMMap;
    }

    /**
     * Function where we get appropriate calculator from our Map according to String key, that user's decision.
     *
     * @return this.calculatorMMap.get(operation) CalculatorM.
     */
    public CalculatorM getCalculator(String operation) {
        return this.calculatorMMap.get(operation);
    }

    /**
     * Function that  organise work calculating get appropriate calculator that make work according User's console decision
     * Scanner class here for imitation work users's Input. actually this method integrate all methods for calculating.
     *
     * @param  operation String.
     * @return result Double our calculating.
     */
    public double wannaCalculatingStart(String operation) {
        Scanner scanner = new Scanner(operation);
        String op = " ";
        if (scanner.hasNextLine()) {
            op = scanner.nextLine();
            scanner.close();
        }
        CalculatorM workingCalculator = this.getCalculator(op);

        return this.workWithCalculator(workingCalculator);
    }

    /**
     * Function for work calculator, we use CalculatorM class and his implementations  method for calculation
     * also write result at List.
     *
     * @return result Double.
     */
    public double workWithCalculator(CalculatorM calculatorM) {
        calculatorM.startConsoleCalc();
        double result = calculatorM.getResult();
        resultsCalculation.add(result);
        return result;
    }

    /**
     * Function getter.
     *
     * @return results ArrayList.
     */
    public ArrayList<Double> getResultsCalculation() {
        return resultsCalculation;
    }

    /**
     * Function getting Last result our Calculation.
     *
     * @return double result.
     */
    public double getLastResaltCalculation() {
        return this.resultsCalculation.get(this.resultsCalculation.size() - 1);
    }


}
