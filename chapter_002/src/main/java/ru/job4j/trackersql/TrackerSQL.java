package ru.job4j.trackersql;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private static final Logger LOGER = LogManager.getLogger(TrackerSQL.class.getName());

    Connection connection;


    public TrackerSQL(Connection connection) {
        this.connection = connection;
        this.init();
        this.inicializationDateTable();
    }

    private void inicializationDateTable() {
        try (PreparedStatement ps = this.connection.prepareStatement(
                "CREATE table if not exists Items (id serial primary key, name character varying(2000), description text)")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            this.LOGER.error(e.getMessage(), e);
        }
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql:/localhost:5432/itemss",
                    "postgres",
                    "apsala");
            System.out.println("Connection");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    @Override
    public void close() throws Exception {

    }

    String sqlInsertItems = "insert into items(name, description) values(?, ?) returning id";

    public ItemS add(ItemS itemS) {
        try (PreparedStatement st = this.connection.prepareStatement(sqlInsertItems)) {
            st.setString(1, itemS.getName());
            st.setString(2, itemS.getDescription());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                itemS.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            this.LOGER.error(e.getMessage(), e);
        }
        return itemS;
    }


    String redactorSqlUpdate = " UPDATE items SET name = ?, description = ? WHERE id = ?";

    /**
     * metod for replace Item for another Item by id.
     *
     * @param id    id item.
     * @param itemS item.
     * @return true and false.
     */
    @Override
    public boolean replace(int id, ItemS itemS) {
        boolean result = false;
        try (PreparedStatement st = this.connection.prepareStatement(redactorSqlUpdate)) {
            st.setString(1, itemS.getName());
            st.setString(2, itemS.getDescription());
            st.setInt(3, id);
            int row = st.executeUpdate();
            if (row != 0) {
                result = true;
            }
        } catch (SQLException e) {
            this.LOGER.error(e.getMessage(), e);
        }

        return result;
    }

    String killerDateSqlQuery = "DELETE FROM items where id = ?";

    /**
     * Метод удаления item из бд.
     *
     * @param id id item.
     * @return true and false.
     */
    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement st = this.connection.prepareStatement(killerDateSqlQuery)) {
            st.setInt(1, id);
            int row = st.executeUpdate();
            if (row != 0) {
                result = true;
            }
        } catch (SQLException e) {
            this.LOGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Метод дастает все items из бд.
     *
     * @return список всех items.
     */
    @Override
    public List<ItemS> getAll() {
        List<ItemS> result = new ArrayList<>();
        try (PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM items returning id")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new ItemS(rs.getString("name"), rs.getString("description"), rs.getInt(1)));
            }
        } catch (SQLException e) {
            this.LOGER.error(e.getMessage(), e);
        }
        return result;

    }

    @Override
    public List<ItemS> findByName(String key) {
        return null;
    }

    String finderSqlQById = "select from items where id = ?";

    /**
     * Метод ищет заявку в БД по ID.
     *
     * @param id item.
     * @return item.
     */
    @Override
    public ItemS findById(int id) {
        ItemS item = null;
        try (PreparedStatement st = this.connection.prepareStatement(finderSqlQById)) {
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                item = new ItemS(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("id"));
            }

        } catch (SQLException e) {
            this.LOGER.error(e.getMessage(), e);
        }
        return item;
    }
}







