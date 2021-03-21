package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class HbmTrackerT implements IStore, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    @Override
    public ItemS add(ItemS item) {
        Session session = sf.openSession();
        session.beginTransaction();
        Serializable id = session.save(item);
        session.getTransaction().commit();
        ItemS it = session.get(ItemS.class, id);
        session.close();
        return it;
    }

    @Override
    public boolean replace(ItemS item) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            ItemS it = new ItemS();
            it.setId(id);
            session.delete(it);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public List<ItemS> findAll() {
        List<ItemS> result;
        Session session = sf.openSession();
        session.beginTransaction();
        result = session.createQuery("from ru.job4j.tracker.ItemS").list();

        return result.isEmpty() ? Collections.emptyList() : result;
    }


    @Override
    public List<ItemS> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.ItemS where name='" + key + "'").list();
        session.getTransaction().commit();
        session.close();
        return result.isEmpty() ? Collections.emptyList() : result;
    }

    @Override
    public ItemS findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        ItemS item = session.get(ItemS.class, id);
        session.getTransaction().commit();
        session.close();

        return item == null ? new ItemS("Ziro") : item;
    }


}
