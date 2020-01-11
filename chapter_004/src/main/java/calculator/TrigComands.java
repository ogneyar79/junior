package calculator;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Class that user's trig commands and keep it.
 */
public class TrigComands {

    public TrigComands() {
    }

    /**
     * field where we have our trig operators for users and checking at our List.
     */
    static final List<String> listTrigComandsAndKeys = new ArrayList();
    /**
     * field where we have map with keys trig commands  String like sin, cos i.t.c.
     * and function realisation these  commands.
     */
    static Map<String, BiFunction<String, Double, Double>> actions = new HashMap<>();

    /**
     * заполенение Map ключами-операциями.
     */
    public void init() {
        listTrigComandsAndKeys.add(SIN);
        actions.put(SIN, this::sin);
        listTrigComandsAndKeys.add(COS);
        actions.put(COS, this::cos);
        listTrigComandsAndKeys.add(TAN);
        actions.put(TAN, this::tan);
        listTrigComandsAndKeys.add(ASIN);
        actions.put(ASIN, this::asin);
        listTrigComandsAndKeys.add(ACOS);
        actions.put(ACOS, this::acos);
        listTrigComandsAndKeys.add(ATAN);
        actions.put(ATAN, this::atan);
        listTrigComandsAndKeys.add(ATAN2);
        actions.put(ATAN2, this::atan2);
    }

    /**
     * fields where we have our trig operators for users and checking.
     */
    static final String SIN = "sin";
    static final String COS = "cos";
    static final String TAN = "tan";
    static final String ASIN = "asin";
    static final String ACOS = "acos";
    static final String ATAN = "atan";

    static final String ATAN2 = "atan2";

    public double atan2(String atan2Key, Double radian) {
        Double first = Double.valueOf(0);
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            first = scanner.nextDouble();
        }
        return Math.atan2(radian, first);
    }

    /**
     * function calculating trig atan inner we use Math.atan(radian).
     *
     * @param atan   String
     * @param radian String angle.
     * @return result Double our Calculating.
     */
    public double atan(String atan, Double radian) {
        return Math.atan(radian);
    }

    public double sin(String sinKey, Double radian) {
        return Math.sin(radian);
    }

    public double cos(String cosKey, Double radian) {
        return Math.cos(radian);
    }


    public double tan(String tanKey, Double radian) {
        return Math.tan(radian);
    }

    public double asin(String asinKey, Double radian) {
        return Math.asin(radian);
    }

    public double acos(String acosKey, Double radian) {
        return Math.acos(radian);
    }

    public static List<String> getListTrigComandsAndKeys() {
        return listTrigComandsAndKeys;
    }

    public static Map<String, BiFunction<String, Double, Double>> getActions() {
        return actions;
    }
}
