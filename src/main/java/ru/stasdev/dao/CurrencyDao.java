package ru.stasdev.dao;

import ru.stasdev.domain.Currency;

import java.util.List;

public interface CurrencyDao {

    Currency getById(long id);

    List<Currency> getAll();

    void insert(Currency currency);

    void update(Currency currency);

    void deleteById(long id);
}
