package ru.stasdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stasdev.dao.DAOManager;
import ru.stasdev.dao.DAOManagerFactory;
import ru.stasdev.domain.Currency;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    private DAOManagerFactory daoManagerFactory;

    @Override
    public List<Currency> getAll() {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try{
                List<Currency> currencies = daoManager.getCurrencyDAO().getAll();
                daoManager.commitTransaction();
                return currencies;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException("Can't get all currencies.",e);
            }
        } catch (Exception e) {
            throw new ServiceException("Can't get all currencies.",e);
        }
    }

    @Override
    public void insert(Currency currency) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try{
                daoManager.getCurrencyDAO().insert(currency);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't insert currency (%s)",currency),e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't insert currency (%s)", currency),e);
        }
    }

    @Override
    public Currency getById(long id) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try{Currency currency = daoManager.getCurrencyDAO().getById(id);
            return currency;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't get currency by id (%s)",id),e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't get currency by id (%s)",id),e);
        }
    }

    @Override
    public void update(Currency currency) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try{
                daoManager.getCurrencyDAO().update(currency);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't update currency (%s)", currency),e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't update currency (%s)", currency),e);
        }
    }

    @Override
    public void deleteById(long id) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getCurrencyDAO().deleteById(id);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't delete currency by id (%s)", id),e);
                }
            } catch (Exception e) {
            throw new ServiceException(String.format("Can't delete currency by id (%s)", id), e);
        }
        }
    }
