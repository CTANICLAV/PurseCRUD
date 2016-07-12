package ru.stasdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stasdev.dao.PurseDao;
import ru.stasdev.dao.UserDao;
import ru.stasdev.domain.Purse;
import ru.stasdev.domain.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PurseDao purseDao;

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(long id) {
        List<Purse> purses = purseDao.getAll();
        for(Purse purse : purses){
            if (purse.getOwnerId() == id) {
                purseDao.deleteById(purse.getOwnerId());
            }
        }
        userDao.deleteById(id);
    }
}
