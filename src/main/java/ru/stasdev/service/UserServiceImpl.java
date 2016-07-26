package ru.stasdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stasdev.dao.DAOManager;
import ru.stasdev.dao.DAOManagerFactory;
import ru.stasdev.dao.PurseDAO;
import ru.stasdev.dao.UserDAO;
import ru.stasdev.domain.Purse;
import ru.stasdev.domain.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DAOManagerFactory daoManagerFactory;

    @Override
    public User getById(long id) {
        try {
            try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
                daoManager.beginTransaction();
                try {
                    User user =daoManager.getUserDAO().getById(id);
                    daoManager.commitTransaction();
                    return user;
                }catch (Exception e) {
                    daoManager.rollbackTransaction();
                    throw new ServiceException(String.format("Can't get user by id (%s)", id), e);
                }
            }
        } catch(Exception e) {
            throw new ServiceException(String.format("Can't get user by id (%s)", id),e);
        }
    }

    @Override
    public void insert(User user) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                daoManager.getUserDAO().insert(user);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't insert (%s)",user), e);
            }
        }catch (Exception e) {
            throw new ServiceException(String.format("Can't inser (%s)",user),e);
        }
    }

    @Override
    public List<User> getAll() {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                List<User> users = daoManager.getUserDAO().getAll();
                daoManager.commitTransaction();
                return users;
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't get all users"),e);
            }
        }catch (Exception e) {
            throw new ServiceException("Can't get all users", e);
        }
    }

    @Override
    public void update(User user) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()){
            daoManager.beginTransaction();
            try {
                daoManager.getUserDAO().update(user);
                daoManager.commitTransaction();
            } catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't update user (%s)",user),e);
            }
        } catch (Exception e) {
            throw new ServiceException(String.format("Can't update user (%s)", user),e);
        }
    }

    @Override
    public void deleteById(long id) {
        try(DAOManager daoManager = daoManagerFactory.getDAOManager()) {
            daoManager.beginTransaction();
            try {
                List<Purse> purses = daoManager.getPurseDAO().getAll();
                for (Purse purse : purses) {
                    if(purse.getOwnerId() == id) {
                        daoManager.getPurseDAO().deleteById(purse.getId());
                    }
                }
                daoManager.getUserDAO().deleteById(id);
                daoManager.commitTransaction();
            }catch (Exception e) {
                daoManager.rollbackTransaction();
                throw new ServiceException(String.format("Can't delete user by id (%s)",id), e);
            }
        } catch (Exception e){}
    }
}
