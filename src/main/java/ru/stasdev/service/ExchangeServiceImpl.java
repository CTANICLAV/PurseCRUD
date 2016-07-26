package ru.stasdev.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stasdev.dao.DAOManager;
import ru.stasdev.dao.DAOManagerFactory;
import ru.stasdev.domain.Currency;
import ru.stasdev.domain.Exchange;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    DAOManagerFactory daoManagerFactory;

    @Override
    public Exchange getById(long id) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                Exchange exchange = daoManager.getExchangeDAO().getById(id);
                daoManager.commitTransaction();
                return exchange;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't getById(%s)", id),e);
            }
        }catch (Exception e) {
            throw new ServiceException(String.format("Can't getById(%s)",id),e);
        }
    }

    @Override
    public void insert(Exchange exchange) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getExchangeDAO().insert(exchange);
                daoManager.commitTransaction();
            } catch (Exception e){
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't insert exchange(%s)", exchange), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't insert exchange(%s)", exchange), e);
        }
    }

    @Override
    public List<Exchange> getAll() {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                List<Currency> currencies = daoManager.getCurrencyDAO().getAll();
                List<Exchange> exchanges = daoManager.getExchangeDAO().getAll();
                for (Exchange exchange : exchanges) {
                    for(Currency currency : currencies) {
                        if (exchange.getSourceCurrencyId() == currency.getId()) {
                            exchange.setSourceCurrencyShortName(currency.getName());
                        }
                        if (exchange.getTargetCurrencyId() == currency.getId()) {
                            exchange.setTargetCurrencyShortName(currency.getName());
                        }
                    }
                }
                daoManager.commitTransaction();
                return exchanges;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException("Can't get all exchanges.",e);
            }
        }catch (Exception e) {
            throw new ServiceException("Can't get all exchanges",e);
        }
    }

    @Override
    public void update(Exchange exchange) {
        try (DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getExchangeDAO().update(exchange);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't update exchange(%s)",exchange), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't update exchange(%s)", exchange),e);
        }
    }

    @Override
    public void deleteById(long id) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getExchangeDAO().deleteById(id);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw  new ServiceException(String.format("Can't delete exchange by id(%s)", id), e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't delete exchange by id(%s)",id), e);
        }
    }
}
