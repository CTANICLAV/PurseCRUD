package ru.stasdev.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stasdev.domain.User;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    public SessionFactory sessionFactory;


    @Override
    public void beginTransaction() {
        sessionFactory.getCurrentSession().beginTransaction();
    }

    @Override
    public void commitTransaction() {
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void rollbackTransaction() {
        sessionFactory.getCurrentSession().getTransaction().rollback();
    }


    @Override
    public User getById(long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public void insert(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteById(long id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }
}