package ru.sapteh.daoimpl;

import ru.sapteh.dao.DAO;
import ru.sapteh.model.Warehouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class WarehouseImpl implements DAO<Warehouse, Integer> {

    private final SessionFactory factory;

    public WarehouseImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Warehouse warehouse) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(warehouse);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Warehouse warehouse) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(warehouse);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Warehouse warehouse) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(warehouse);
            session.getTransaction().commit();
        }
    }

    @Override
    public Warehouse findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Warehouse.class, id);
        }
    }

    @Override
    public List<Warehouse> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Warehouse ", Warehouse.class).list();
        }
    }
}
