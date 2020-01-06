package calculator;

import java.util.Scanner;

/**
 * Class for make operation with Console Input for our Calculator.
 */
public class ConsolReaderForCalc {

    /**
     * Field object for work with console input.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Function for getting operand from console.
     *
     * @return result Double.
     */
    public double getDouble() {
        System.out.println("Введите число:");
        double num;
        if (this.scanner.hasNextDouble()) {
            num = this.scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            this.scanner.next();//рекурсия
            num = getDouble();
        }
        return num;
    }

    /**
     * Function for getting operation from console.
     *
     * @return result Char.
     */
    public char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (this.scanner.hasNext()) {
            operation = this.scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            this.scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
