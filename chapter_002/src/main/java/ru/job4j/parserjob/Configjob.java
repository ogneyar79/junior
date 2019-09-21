package ru.job4j.parserjob;

import ru.job4j.magnit.Config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Configjob {

    private final Properties values = new Properties();

  Connection connection;

    public Configjob() {
        connection = null;
        this.init();
    }

    public Connection getConnection() {
        return connection;
    }

    public void init() {
        try (InputStream in = ParserJobBaseDateWork.class.getClassLoader().getResourceAsStream("jobSql.properties")) {
            values.load(in);
            Class.forName(values.getProperty("driver"));
            this.connection = DriverManager.getConnection(
                    values.getProperty("url"),
                    values.getProperty("username"),
                    values.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }


}
