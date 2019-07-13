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
import java.util.Properties;

public class TrackerSQLTest {

    private ItemS item;
    Connection connection;


@Test
public void connect(){

}

    @Test
    public void testBefore() {
        item = new ItemS("TestName", "TestDescription");

        TrackerSQL trackerSQL = new TrackerSQL(connection);
        trackerSQL.init();
        trackerSQL.inicializationDateTable();
    }


    private static final Logger LOGGER = LogManager.getLogger(TrackerSQLTest.class);

    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL(connection);
        assertThat(sql.init(), is(true));
    }
}