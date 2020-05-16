package concurrent.limitdownload;

import java.io.EOFException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseArg {

    private final String[] arr;
    private String url;
    // private String fileName;
    private int speed;


    public String getUrl() {
        return url;
    }

//    public String getFileName() {
//        return fileName;
//    }

    public int getSpeed() {
        return speed;
    }

    public ParseArg(String[] arr) throws EOFException {
        this.arr = arr;
        url = findUrl();
        speed = findSpeed();
        if (url.equals(null) | speed == 0) {
            throw new EOFException(" Problem With args might Null");
        }
    }


    private String findUrl() {
        String res = null;
        Pattern patternDir = Pattern.compile("(https?)");
        Matcher url = patternDir.matcher(arr[0]);
        if (url.find()) {
            res = arr[0];
        }
        return res;
    }

    private Integer findSpeed() {
        Integer res = null;
        try {
            res = Integer.parseInt(arr[1]);
        } catch (NumberFormatException ne) {
            System.err.println("Второй аргумент должен быть числом ");
        }
        return res;
    }

}
