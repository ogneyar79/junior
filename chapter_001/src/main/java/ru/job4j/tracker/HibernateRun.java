package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateRun {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

            ItemS item = create(new ItemS("Learn Hibernate"), sf);

            item.setName("Learn Hibernate 5.");
            update(item, sf);
            System.out.println(item);
            ItemS rsl = findById(item.getId(), sf);
            System.out.println(rsl);
            delete(rsl.getId(), sf);
            List<ItemS> list = findAll(sf);
            for (ItemS it : list) {
                System.out.println(it);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static ItemS create(ItemS item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();

        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static void update(ItemS item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(int id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        ItemS item = new ItemS(null);
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    public static List<ItemS> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.ItemS").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static ItemS findById(int id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        ItemS result = session.get(ItemS.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
