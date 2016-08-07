package ru.stasdev.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stasdev.dao.ExchangeDAO;
import ru.stasdev.domain.Exchange;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeDAO exchangeDAO;

    @Override
    @Transactional
    public Exchange getById(long id) {
        return exchangeDAO.getById(id);
    }

    @Override
    @Transactional
    public void insert(Exchange exchange) {
        exchangeDAO.insert(exchange);
    }

    @Override
    @Transactional
    public List<Exchange> getAll() {
        List<Exchange> exchanges = exchangeDAO.getAll();
        return exchanges;
    }

    @Override
    @Transactional
    public void update(Exchange exchange) {
        exchangeDAO.update(exchange);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        exchangeDAO.deleteById(id);
    }
}
