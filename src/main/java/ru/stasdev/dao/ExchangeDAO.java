package ru.stasdev.dao;

import ru.stasdev.domain.Exchange;

import java.util.List;

public interface ExchangeDAO {

    Exchange getById(long id);

    void insert(Exchange exchange);

    List<Exchange> getAll();

    void update(Exchange exchange);

    void deleteById(long id);

}
