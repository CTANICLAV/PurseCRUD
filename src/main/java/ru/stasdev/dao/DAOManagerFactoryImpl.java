package ru.stasdev.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DAOManagerFactoryImpl implements DAOManagerFactory {

    @Autowired
    private DataSource dataSource;

    @Override
    public DAOManager getDAOManager() {
        try {
            return new DAOManagerImpl(dataSource.getConnection());
        } catch(Exception e){
            throw new DAOException(String.format("Can't get DAO Manager"),e);
        }
    }
}
