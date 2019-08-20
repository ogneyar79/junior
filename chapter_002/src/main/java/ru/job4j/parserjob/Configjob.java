package ru.job4j.parserjob;

import ru.job4j.magnit.Config;

import java.io.InputStream;
import java.util.Properties;

public class Configjob {

    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("jobSql.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }


}
