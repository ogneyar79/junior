package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.trackersql.TrackerSQL;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
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

    public Config getConfig() {
        return config;
    }

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

    /**
     * Create a new Table in the database if it does not exists.
     * Each time creates a new table to remove old items.
     */
    public void createStructure() {
        try (Statement statement = connect.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS entry");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS  entry (field INTEGER NOT NULL )");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Generates N items in a table from 1 to n.
     *
     * @param size number of items.
     * @throws SQLException if exception.
     */
    public void generate(int size) throws SQLException {
        System.out.println(String.format("Start inserting %s items into database", size));
        try (PreparedStatement statement = connect.prepareStatement("INSERT INTO entry(field) VALUES(?) ")) {
            for (int index = 1; index <= size; index++) {
                statement.setInt(1, index);
                statement.addBatch();
            }
            statement.executeBatch();
            connect.commit();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            connect.rollback();
        }
        System.out.println(String.format("%s elements inserted", size));

    }

    /**
     * List of all elements at the database.
     *
     * @return list.
     */
    public List<Entry> load() {
        List<Entry> result = new ArrayList<>();
        try (PreparedStatement statement = connect.prepareStatement("SELECT * FROM entry")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Entry entry = new Entry();
                entry.setField(rs.getInt("field"));
                result.add(entry);
            }
            rs.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}
