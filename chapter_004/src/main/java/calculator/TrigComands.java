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
    static final List<String> LIST_TRIG_COMANDS = new ArrayList();

    /**
     * field where we have map with keys trig commands  String like sin, cos i.t.c.
     * and function realisation these  commands.
     */
    static Map<String, BiFunction<String, Double, Double>> actions = new HashMap<>();

    /**
     * заполенение Map ключами-операциями.
     */
    public void init() {
        LIST_TRIG_COMANDS.add(SIN);
        actions.put(SIN, this::sin);
        LIST_TRIG_COMANDS.add(COS);
        actions.put(COS, this::cos);
        LIST_TRIG_COMANDS.add(TAN);
        actions.put(TAN, this::tan);
        LIST_TRIG_COMANDS.add(ASIN);
        actions.put(ASIN, this::asin);
        LIST_TRIG_COMANDS.add(ACOS);
        actions.put(ACOS, this::acos);
        LIST_TRIG_COMANDS.add(ATAN);
        actions.put(ATAN, this::atan);
        LIST_TRIG_COMANDS.add(ATAN2);
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

    public double sin(String sinKey, double radian) {
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

    public static List<String> getListTrigComands() {
        return LIST_TRIG_COMANDS;
    }

    public static Map<String, BiFunction<String, Double, Double>> getActions() {
        return actions;
    }
}
