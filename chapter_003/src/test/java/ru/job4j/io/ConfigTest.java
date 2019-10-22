package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ConfigTest {

    Map<String, String> val;
    Config config;
    String name;

    @Before
    public void init() {
        name = "/app.properties.";
        config = new Config(Config.class.getResource(name).getFile());
        val = new HashMap<>();
    }

    @Test
    public void whenPairKeyGetValue() {

        config.load();
        System.out.println(config);
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }

    @Test
    public void value() throws Exception {
        config.load();
        String value = config.value("hibernate.dialect");
        System.out.println(value);
        assertEquals(value, "org.hibernate.dialect.PostgreSQLDialect");

    }

}