package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    /**
     * Constructor of  Config's class.
     *
     * @param path
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * procedure load to Map key  and value from file.
     */
    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String line;
            while ((line = read.readLine()) != null) {
                if (line.contains("=")) {

                    String[] tempStringArray = line.split("=");
                    this.values.put(tempStringArray[0], tempStringArray[1]);
                }
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function returned from map value via key.
     *
     * @param key String.
     * @return String value.
     */
    public String value(String key) {

        return values.containsKey(key) & key != null ? values.get(key) : "";
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Config(Config.class.getResource("/app.properties.").getFile()));
    }
}
