package ru.stasdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stasdev.dao.PurseDAO;
import ru.stasdev.dao.UserDAO;
import ru.stasdev.domain.Purse;
import ru.stasdev.domain.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PurseDAO purseDAO;

    @Override
    public User getById(long id) {
        try {
                userDAO.beginTransaction();
                try {
                    User user = userDAO.getById(id);
                    userDAO.commitTransaction();
                    return user;
                }catch (Exception e) {
                    userDAO.rollbackTransaction();
                    throw new ServiceException(String.format("Can't get user by id (%s)", id), e);
                }
        } catch(Exception e) {
            throw new ServiceException(String.format("Can't get user by id (%s)", id),e);
        }
    }

    @Override
    public void insert(User user) {
        try {
            userDAO.beginTransaction();
            try {
                userDAO.insert(user);
                userDAO.commitTransaction();
            } catch (Exception e) {
                userDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can't insert (%s)",user), e);
            }
        }catch (Exception e) {
            throw new ServiceException(String.format("Can't inser (%s)",user),e);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            userDAO.beginTransaction();
            try {
                List<User> users = userDAO.getAll();
                userDAO.commitTransaction();
                return users;
            } catch (Exception e) {
                userDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can't get all users"),e);
            }
        }catch (Exception e) {
            throw new ServiceException("Can't get all users", e);
        }
    }

    @Override
    public void update(User user) {
        try {
            userDAO.beginTransaction();
            try {
                userDAO.update(user);
                userDAO.commitTransaction();
            } catch (Exception e) {
                userDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can't update user (%s)",user),e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't update user (%s)", user),e);
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            userDAO.beginTransaction();
            try {
                List<Purse> purses = purseDAO.getAll();
                for (Purse purse : purses) {
                    if(purse.getOwner().getId() == id) {
                        purseDAO.deleteById(purse.getId());
                    }
                }
                userDAO.deleteById(id);
                userDAO.commitTransaction();
            }catch (Exception e) {
                userDAO.rollbackTransaction();
                throw new ServiceException(String.format("Can't delete user by id (%s)",id), e);
            }
        } catch (Exception e){}
    }
}
