package ru.sapteh.daoimpl;

import ru.sapteh.dao.DAO;
import ru.sapteh.model.CategoryProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CategoryProductImpl implements DAO<CategoryProduct, Integer> {

    private final SessionFactory factory;

    public CategoryProductImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(CategoryProduct categoryProduct) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(categoryProduct);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(CategoryProduct categoryProduct) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(categoryProduct);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(CategoryProduct categoryProduct) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(categoryProduct);
            session.getTransaction().commit();
        }
    }

    @Override
    public CategoryProduct findById(Integer id) {
        try (Session session = factory.openSession()){
          return session.get(CategoryProduct.class, id);
        }
    }

    @Override
    public List<CategoryProduct> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM CategoryProduct ", CategoryProduct.class).list();
        }
    }
}
