package ru.job4j.magnit;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StoreSQLTest {

    Config config = new Config();
    StoreSQL sql = new StoreSQL(config);

    @Test
    public void setConnection() throws Exception {

        sql.setConnection(sql.getConfig());
        sql.createStructure();
        try {
            sql.generate(10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Entry> result = sql.load();
        sql.close();

        List<Entry> expected = new ArrayList<>();
        for (int index = 1; index <= 10; index++) {
            Entry toAdd = new Entry();
            toAdd.setField(index);
            expected.add(toAdd);
        }
        assertThat(result, is(expected));
    }

    @Test
    public void generate() throws Exception {
    }

    @Test
    public void load() throws Exception {
    }

    @Test
    public void close() throws Exception {
    }

}