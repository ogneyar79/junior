package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.trackersql.TrackerSQL;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Class for creating a new SQLite database and inserting N items into it.
 *
 * @author Maksimus Sirotkin(maksimus.S@mail.ru)
 * @version 0.1$
 * @since 0.1
 * 20.05.2019
 */
public class StoreSQL implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(StoreSQL.class);

    private final Config config;

    /**
     * Connection to SQLite database.
     */
    private Connection connect = null;

    /**
     * Creates a connection to the database.
     *
     * @param config with connection parameters.
     */
    public void setConnection(Config config) {
        config.init();
        String url = String.valueOf(config.get("url"));
        try (Connection conn = DriverManager.getConnection(config.get(url))) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


    public StoreSQL(Config config) {
        this.config = config;
    }

    public void generate(int size) {

    }

    public List<Entry> load() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }


}
