package ru.stasdev.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stasdev.domain.Purse;

import java.util.List;

@Component
public class PurseDAOImpl implements PurseDAO {


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
    public Purse getById(long id) {
        return (Purse) sessionFactory.getCurrentSession().get(Purse.class, id);
    }

    @Override
    public List<Purse> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Purse.class).list();
    }

    @Override
    public void insert(Purse purse) {
        sessionFactory.getCurrentSession().save(purse);
    }

    @Override
    public void update(Purse purse) {
        sessionFactory.getCurrentSession().update(purse);
    }

    @Override
    public void deleteById(long id) {
        Purse purse = (Purse) sessionFactory.getCurrentSession().get(Purse.class, id);
        sessionFactory.getCurrentSession().delete(purse);
    }
}
