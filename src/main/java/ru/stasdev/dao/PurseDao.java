package ru.stasdev.dao;

import ru.stasdev.domain.Purse;
import java.util.List;

//Этот интерфейс содержит все элементарные операции связанные с классом Purse

public interface PurseDAO {

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    Purse getById(long id);

    void insert(Purse purse);

    List<Purse> getAll();

    void update(Purse purse);

    void deleteById(long id);
}
