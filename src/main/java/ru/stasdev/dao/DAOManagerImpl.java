package ru.stasdev.dao;

import java.sql.Connection;

public class DAOManagerImpl implements DAOManager {

    private Connection connection;

    private UserDAO userDAO;
    private PurseDAO purseDAO;
    private CurrencyDAO currencyDAO;
    private ExchangeDAO exchangeDAO;

    public DAOManagerImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOJdbcImpl(getConnection());
        }
        return userDAO;
    }

    public ExchangeDAO getExchangeDAO() {
        if (exchangeDAO == null) {
            exchangeDAO = new ExchangeDAOJdbcImpl(getConnection());
        }
        return exchangeDAO;
    }

    @Override
    public PurseDAO getPurseDAO() {
        if (purseDAO == null) {
            purseDAO = new PurseDAOJdbcImpl(getConnection());
        }
        return purseDAO;
    }

    @Override
    public CurrencyDAO getCurrencyDAO() {
        if (currencyDAO == null) {
            currencyDAO = new CurrencyDAOJdbcImpl(getConnection());
        }
        return currencyDAO;
    }

    @Override
    public void beginTransaction() {
        try {
            getConnection().setAutoCommit(false);
        } catch(Exception e) {
            throw new DAOException(String.format("Can't begin transaction"),e);
        }

    }

    @Override
    public void commitTransaction() {
        try {
            getConnection().commit();
        } catch (Exception e) {
            throw new DAOException(String.format("Can't commit transaction"),e);
        }
    }

    @Override
    public void rollbackTransaction() {
        try {
            getConnection().rollback();
        } catch (Exception e) {
            throw new DAOException(String.format("Can't rollback transaction"),e);
        }

    }

    @Override
    public void close() throws Exception {
        if (getConnection() !=null) {
            try {
                getConnection().close();
            } catch (Exception e) {
                throw new DAOException(String.format("Can't close connection"), e);
            }
        }
    }

    private Connection getConnection() {
        return connection;
    }
}
