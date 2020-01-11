package calculator;

import java.util.Scanner;

/**
 * Class for console reading calculating users input for trig function.
 */
public class ConsoleReadTrig implements IConsoleTrigReaderC {

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
            this.scanner.next();
            num = getDouble();
        }
        return num;
    }

    /**
     * Function for getting operation from console.
     *
     * @return result String.
     */
    public String getOperation() {
        System.out.println("Введите операцию:");
        String operation;
        if (this.scanner.hasNextLine()) {
            operation = this.scanner.nextLine();
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            this.scanner.next();
            operation = getOperation();
        }
        return operation;
    }

}

