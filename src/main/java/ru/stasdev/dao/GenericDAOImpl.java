package ru.stasdev.dao;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> type;

    public void setType(Class<T> type) {
        this.type = type;
    }

    @Override
    public T getById(Long empId) {
        return entityManager.find(type, empId);
    }

    @Override
    public void insert(Object emp) {
        entityManager.persist(emp);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(type);
        Root<T> currency = cq.from(type);
        CriteriaQuery<T> all = cq.select(currency);
        TypedQuery<T> q = entityManager.createQuery(all);
        List<T> tList = q.getResultList();
        return tList;
    }

    @Override
    public void update(Object emp) {
        entityManager.merge(emp);
    }

    @Override
    public void deleteById(Long empId) {
        T emp = entityManager.find(type, empId);
        entityManager.remove(emp);
    }
}
