package ru.stasdev.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stasdev.domain.Exchange;

import java.util.List;

@Component
public class ExchangeDAOImpl implements ExchangeDAO {


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
    public Exchange getById(long id) {
        return (Exchange) sessionFactory.getCurrentSession().get(Exchange.class, id);
    }

    @Override
    public List<Exchange> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Exchange.class).list();
    }

    @Override
    public void insert(Exchange exchange) {
        sessionFactory.getCurrentSession().save(exchange);
    }

    @Override
    public void update(Exchange exchange) {
        sessionFactory.getCurrentSession().update(exchange);
    }

    @Override
    public void deleteById(long id) {
        Exchange exchange = (Exchange) sessionFactory.getCurrentSession().get(Exchange.class, id);
        sessionFactory.getCurrentSession().delete(exchange);
    }

}