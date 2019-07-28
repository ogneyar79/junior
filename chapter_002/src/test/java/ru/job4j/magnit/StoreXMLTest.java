package ru.job4j.magnit;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StoreXMLTest {

    File target = new File("storeXml.xml");
    List<Entry> list = new ArrayList<>();
    Config config = new Config();

    StoreSQL mySql = new StoreSQL(config);
    StoreXML storeXml = new StoreXML(target);

    /**
     * Check StoreXML
     *
     * @throws Exception any exception
     */
    @Test
    public void whenConvertListEntriesToXML() throws Exception {
        mySql.setConnection(mySql.getConfig());
        mySql.createStructure();
        mySql.generate(2);

        list = mySql.load();
        System.out.println(list.get(0).getField());
        System.out.println(list.get(1).getField());

        storeXml.save(list);

    }

    @Test
    public void whenOutconsole() {
        System.out.println(target.getPath());
        this.storeXml.atMyToString();
    }


}