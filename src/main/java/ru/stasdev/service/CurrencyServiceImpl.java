package ru.stasdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stasdev.dao.CurrencyDAO;
import ru.stasdev.domain.Currency;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    private CurrencyDAO currencyDAO;

    @Override
    public List<Currency> getAll() {
        try {
            currencyDAO.beginTransaction();
            try{
                List<Currency> currencies = currencyDAO.getAll();
                currencyDAO.commitTransaction();
                return currencies;
            } catch (Exception e) {
                currencyDAO.rollbackTransaction();
                throw new ServiceException("Can't get all currencies.",e);
            }
        } catch (Exception e) {
            throw new ServiceException("Can't get all currencies.",e);
        }
    }

    @Override
    public void insert(Currency currency) {
        try {
            currencyDAO.beginTransaction();
            try{
                currencyDAO.insert(currency);
                currencyDAO.commitTransaction();
            } catch (Exception e) {
                currencyDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can't insert currency (%s)",currency),e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't insert currency (%s)", currency),e);
        }
    }

    @Override
    public Currency getById(long id) {
        try {
            currencyDAO.beginTransaction();
            try{
                Currency currency = currencyDAO.getById(id);
                currencyDAO.commitTransaction();
            return currency;
            } catch (Exception e) {
                currencyDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can't get currency by id (%s)",id),e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't get currency by id (%s)",id),e);
        }
    }

    @Override
    public void update(Currency currency) {
        try {
            currencyDAO.beginTransaction();
            try{
                currencyDAO.update(currency);
                currencyDAO.commitTransaction();
            } catch (Exception e) {
                currencyDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can't update currency (%s)", currency),e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't update currency (%s)", currency),e);
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            currencyDAO.beginTransaction();
            try {
                currencyDAO.deleteById(id);
                currencyDAO.commitTransaction();
            } catch (Exception e) {
                currencyDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can't delete currency by id (%s)", id),e);
                }
            } catch (Exception e) {
            throw new ServiceException(String.format("Can't delete currency by id (%s)", id), e);
        }
        }
    }
