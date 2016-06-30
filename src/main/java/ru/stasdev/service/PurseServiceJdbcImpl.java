package ru.stasdev.service;

import ru.stasdev.dao.ConnectionFactory;
import ru.stasdev.dao.PurseDaoJdbcImpl;
import ru.stasdev.domain.Purse;

import java.util.List;

public class PurseServiceJdbcImpl implements PurseService {

    @Override
    public Purse getById(long id) {
        return new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).getById(id);
    }

    @Override
    public void insert(Purse purse) {
        new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).insert(purse);
    }

    @Override
    public List<Purse> getAll() {
        return new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).getAll();
    }

    @Override
    public void update(Purse purse) {
        new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).update(purse);
    }

    @Override
    public void deleteById(long id) {
        new PurseDaoJdbcImpl(ConnectionFactory.getInstance()).deleteById(id);
    }
}
