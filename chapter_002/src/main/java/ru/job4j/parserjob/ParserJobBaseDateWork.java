package ru.job4j.parserjob;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Class for work with our database.
 *
 * @version 0.2
 * @autor Sirotkin Maksim
 * @since 30.08.19
 */
public class ParserJobBaseDateWork implements Closeable {

    /**
     * Logger for info output.
     */
    private static final Logger LOGGER = LogManager.getLogger(ParserJobSqlRu.class);

    LocalDateTime defaultMaxDate = LocalDateTime.of(2019, Month.JANUARY, 1, 0, 0);


    /**
     * Field Configuration of connection to the database.
     */
    private final Configjob config;


    /**
     * Constructor of new object
     *
     * @param config
     * @see ParserJobBaseDateWork(Configjob)
     */
    public ParserJobBaseDateWork(Configjob config) {
        this.config = config;
    }

    public Connection getConnect() {
        return connect;
    }

    public String getCreatorStructure() {
        return creatorStructure;
    }

    public ParserJobBaseDateWork() {
        this.config = new Configjob();
        this.setConnection(config);
        this.createStructure(this.getCreatorStructure());
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
        this.connect = config.getConnection();

    }

//    /**
//     * Connect to  database
//     */
//    private void connectDate() {
//        try {
//            this.connect = DriverManager.getConnection(config.get("url"));
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }


    String creatorStructure = "\"CREATE TABLE IF NOT EXISTS  vacancy ( id integer unique,\\n\" +\n"
            +
            " \"    name text,\\n\" +\n"
            +
            "  \"    link text,\\n\" +\n"
            +
            "   \"    elTiempo timestamp )\")";

    /**
     * Create a new Table in the database if it does not exists.
     */
    public void createStructure(String creatorStructure) {
        try (Statement statement = connect.createStatement()) {
            statement.executeUpdate(creatorStructure);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private String sqlInsertItems = "INSERT INTO vacancy(id, name, link, elTiempo) values (?, ?, ?, ?)";

    /**
     * Procedure of adding vacancy to BaseData.
     *
     * @param vacanciesSet collection where we get objects 0f vacancy.
     */
    public void addVacansy(Set<Vacancy> vacanciesSet) {
        int added = 0;
        try (PreparedStatement st = this.connect.prepareStatement(sqlInsertItems)) {
            for (Vacancy vacancy : vacanciesSet) {
                st.setInt(1, vacancy.getId());
                st.setString(2, vacancy.getNameJob());
                st.setString(3, vacancy.getLinkJob());
                st.setTimestamp(4, Timestamp.valueOf(vacancy.getDateTime()));
                st.addBatch();
                added++;
            }
            st.executeBatch();
            LOGGER.info("Vacancies have recorded in the database");
        } catch (SQLException e) {
            e.getNextException();
            this.LOGGER.error(e.getMessage(), e);
        }
        this.LOGGER.info(String.format("Added %s new vacancies.", added));
    }

    /**
     * Function of getting objects of vacancy from DataBase.
     *
     * @return Vacancy vacancy from DataBase.
     */
    public List<Vacancy> getVacanciesFromBase() {
        Vacancy result = null;
        List<Vacancy> vacancyList = new ArrayList<>();

        try (Statement statement = this.connect.createStatement()) {
            try (ResultSet result1 = statement.executeQuery(
                    "SELECT * from  vacancy")) {
                if (result1.next()) {
                    result = new Vacancy(result1.getInt("id"), result1.getString("name"),
                            result1.getString("link"), (result1.getTimestamp("elTiempo")).toLocalDateTime());
                    System.out.println(result.toString());
                    vacancyList.add(result);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }

    String getterMaxDate = "SELECT max(elTiempo) as maxDate FROM vacancy";

    /**
     * Method gets the date of the last check from the database.
     *
     * @return date of last check.
     */
    public LocalDateTime getDateMaxFromBase() {
        Timestamp result = null;
        try (PreparedStatement st = this.connect.prepareStatement(getterMaxDate)) {
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    result = rs.getTimestamp("maxDate");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result == null ? this.defaultMaxDate : result.toLocalDateTime();
    }

    @Override
    public void close() throws IOException {
        if (this.connect != null) {
            try {
                this.connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}