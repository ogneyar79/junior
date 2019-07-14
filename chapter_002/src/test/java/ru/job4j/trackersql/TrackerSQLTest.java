package ru.job4j.trackersql;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TrackerSQLTest {

    private ItemS item;
    Connection connection;

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (TrackerSQL tracker = TrackerSQL.getTrackerSQLwithConection(ConnectionRollback.create(this.init()))) {
            tracker.add(new ItemS("name", "desc"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBefore() {
        item = new ItemS("TestName", "TestDescription");

        TrackerSQL trackerSQL = new TrackerSQL(connection);
        trackerSQL.init();
    }


    private static final Logger LOGGER = LogManager.getLogger(TrackerSQLTest.class);

    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL(connection);
        assertThat(sql.init(), is(true));
    }
}