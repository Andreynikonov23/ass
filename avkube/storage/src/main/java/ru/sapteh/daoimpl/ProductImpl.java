package ru.sapteh.daoimpl;

import ru.sapteh.dao.DAO;
import ru.sapteh.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductImpl implements DAO<Product, Integer> {

    private final SessionFactory factory;

    public ProductImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Product product) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Product product) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Product product) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Product.class, id);
        }
    }

    @Override
    public List<Product> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Product ", Product.class).list();
        }
    }
}
