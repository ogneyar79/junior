package ru.job4j.trackersql;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Properties;

public class SQLStorage {

    public static final Logger log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/car_factory";
        String username = "postgres";
        String password = "apsala";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT from car_body");
            while (rs.next()) {
                System.out.println(String.format("%s %s", rs.getString("name"), rs.getTimestamp("date_made")));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();

                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }


    }

}
