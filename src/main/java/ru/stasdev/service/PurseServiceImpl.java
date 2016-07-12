package ru.stasdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stasdev.dao.CurrencyDao;
import ru.stasdev.dao.PurseDao;
import ru.stasdev.domain.Purse;

import java.util.List;

@Service
public class PurseServiceImpl implements PurseService {

    @Autowired
    private PurseDao purseDao;

    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public Purse getById(long id) {
        return purseDao.getById(id);
    }

    @Override
    public void insert(Purse purse) {
        purseDao.insert(purse);
    }

    @Override
    public List<Purse> getAll() {
        List<Purse> purses = purseDao.getAll();
       for(Purse purse : purses) {
           purse.setCurrencyShortName(currencyDao.getById(purse.getCurrencyId()).getName());
       }
        return purses;
    }

    @Override
    public void update(Purse purse) {
        purseDao.update(purse);
    }

    @Override
    public void deleteById(long id) {
        purseDao.deleteById(id);
    }
}
