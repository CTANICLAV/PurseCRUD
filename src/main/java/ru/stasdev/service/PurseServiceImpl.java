package ru.stasdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stasdev.dao.*;
import ru.stasdev.domain.Purse;

import java.util.List;
@Service
public class PurseServiceImpl implements PurseService {

    @Autowired
    private PurseDAO purseDAO;

    @Override
    @Transactional
    public Purse getById(long id) {
        return purseDAO.getById(id);

    }

    @Override
    @Transactional
    public void insert(Purse purse) {
        purseDAO.insert(purse);
    }

    @Override
    @Transactional
    public List<Purse> getAll() {
            return purseDAO.getAll();
    }

    @Override
    @Transactional
    public void update(Purse purse) {
        purseDAO.update(purse);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        purseDAO.deleteById(id);

    }
}
