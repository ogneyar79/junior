package calculator;

/**
 * Class for checking operation.
 */
public class ValidateOperator {

    /**
     * function check validation operation like '+','-','/','*'.
     *
     * @return result boolean.
     */
    public boolean checkOperation(char operation) {
        boolean result = false;
        if (operation == '+' | operation == '-' | operation == '/' | operation == '*') {
            result = true;
        }
        return result;
    }
}
