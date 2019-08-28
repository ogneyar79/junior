package ru.job4j.parserjob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.magnit.Config;


import java.sql.*;


public class ParserJobBaseDateWork {

    private static final Logger LOGGER = LogManager.getLogger(ParserJobSqlRu.class);

    private final Configjob config;


    public ParserJobBaseDateWork(Configjob config) {
        this.config = config;
    }

    /**
     * Connection to PSQl Date B.
     */
    private Connection connect = null;

    public Configjob getConfig() {
        return config;
    }

    /**
     * Creates a connection to the database.
     *
     * @param config with connection parameters.
     */
    public void setConnection(Configjob config) {
        config.init();
        this.connectDate();
        String url = String.valueOf(config.get("url"));
        try (Connection connect = DriverManager.getConnection(url)) {
            if (connect != null) {
                DatabaseMetaData meta = connect.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
    /**
     * Connect to  database
     */
    private void connectDate() {
        try {
            this.connect = DriverManager.getConnection(config.get("url"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Create a new Table in the database if it does not exists.
     * Each time creates a new table to remove old items.
     */
    public void createStructure() {
        try (Statement statement = connect.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS vacancy");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS  vacancy (field id serial,\n" +
                    "    name text unique,\n" +
                    "    description text,\n" +
                    "    link text,\n" +
                    "    updated timestamp )");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
    String sqlInsertItems = "";

    public void  addVacansy(Vacancy vacancy){
        try (PreparedStatement st = this.connect.prepareStatement(sqlInsertItems)) {
            st.setString(1, vacancy.getLinkJob());
            st.setString(2, vacancy.getEsqribishenJob());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                vacancy.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            this.LOGGER.error(e.getMessage(), e);
        }

    }

}
