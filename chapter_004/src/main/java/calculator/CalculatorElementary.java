package calculator;

import java.util.Scanner;

/**
 * Class elementary calculator.
 */
public class CalculatorElementary {

    private double result;

    /**
     * procedure that add number
     *
     * @param first  String.
     * @param second String.
     */
    public void add(double first, double second) {
        double result = first + second;
        System.out.println(first + "+" + second + " = " + result);
        this.result = result;
    }

    /**
     * procedure that subtract number
     *
     * @param first  String.
     * @param second String.
     */
    public void subtract(double first, double second) {
        double result = first - second;
        this.result = result;
        System.out.println(first + "-" + second + " = " + result);
    }

    /**
     * procedure that divide number
     *
     * @param first  String.
     * @param second String.
     */
    public void div(double first, double second) {
        if (second == 0) {
            System.out.println(" We can't divide by Zero");
            Scanner in = new Scanner(System.in);
            System.out.println(" Ask change second and Input another number ");
            second = in.nextDouble();
            in.close();
            if (second == 0) {
                return;
            }
            div(first, second);
        }
        double result = first / second;
        this.result = result;
        System.out.println(first + "/" + second + " = " + result);
    }

    /**
     * procedure that multiply number
     *
     * @param first  String.
     * @param second String.
     */
    public void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + "*" + second + " = " + result);
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public static void main(String[] args) {
        CalculatorElementary calculatorElementary = new CalculatorElementary();
        calculatorElementary.div(8, 0);
        calculatorElementary.add(1, 1);
        calculatorElementary.div(5, 2);
        calculatorElementary.subtract(4, 2);
        calculatorElementary.multiply(2, 2);
    }


}
