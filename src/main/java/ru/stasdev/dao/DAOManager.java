package ru.stasdev.dao;

public interface DAOManager extends AutoCloseable {

    UserDAO getUserDAO();

    PurseDAO getPurseDAO();

    CurrencyDAO getCurrencyDAO();

    ExchangeDAO getExchangeDAO();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();
}
