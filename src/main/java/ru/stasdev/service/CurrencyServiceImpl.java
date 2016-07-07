package ru.stasdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.stasdev.dao.CurrencyDao;
import ru.stasdev.domain.Currency;

import java.util.List;

@Repository
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    private CurrencyDao currencyDao;

    public void setCurrencyDao(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }


    @Override
    public List<Currency> getAll() {
        return currencyDao.getAll();
    }

    @Override
    public void insert(Currency currency) {
        currencyDao.insert(currency);
    }

    @Override
    public Currency getById(long id) {
        return currencyDao.getById(id);
    }

    @Override
    public void update(Currency currency) {
        currencyDao.update(currency);
    }

    @Override
    public void deleteById(long id) {
        currencyDao.deleteById(id);
    }

}
