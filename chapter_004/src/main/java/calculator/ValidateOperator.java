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

    /**
     * function check validation operation Trig.
     *
     * @return result boolean.
     */
    public boolean checkOperationTrig(String operation) {
        boolean result = false;
        if (TrigComands.LIST_TRIG_COMANDS.contains(operation)) {
            result = true;
        }
        return result;
    }
}
