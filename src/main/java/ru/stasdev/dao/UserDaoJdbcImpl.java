package ru.stasdev.dao;

import ru.stasdev.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJdbcImpl implements UserDAO {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM user WHERE id = ?";
    public static final String INSERT_USER = "INSERT INTO user (firstName, lastName) VALUES (?,?)";
    public static final String SELECT_FROM_ALL_USER = "SELECT * FROM user";
    public static final String UPDATES_USER = "UPDATE user SET firstName = ?, lastName = ? WHERE id = ?";
    public static final String DELETE_USER = "DELETE FROM user WHERE id = ?";

    private Connection connection;

    public UserDAOJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getById(long id) {
        try(PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery();){
                while(resultSet.next()){
                    return new User(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_FIRST_NAME),
                            resultSet.getString(COLUMN_LAST_NAME));
                }
            }
        } catch (Exception e) {
            throw new DAOException(String.format("Method getById(id: '%d has thrown an exception.",id ),e);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> user = new ArrayList<>();
        try(Statement statement = connection.createStatement();){
            try(ResultSet resultSet = statement.executeQuery(SELECT_FROM_ALL_USER);) {
                while(resultSet.next()) {
                    user.add(new User (resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_FIRST_NAME),
                            resultSet.getString(COLUMN_LAST_NAME)));
                }
            }
        }catch (Exception e) {
            throw new DAOException(String.format("Method getAll User; has thrown an exception."),e);
        }
        return user;
    }

    @Override
    public void insert(User user) {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_USER);){
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            int i = statement.executeUpdate();
            if(i == 0) {
                throw new DAOException("Table 'Purses' was not updated", null);
            }
        }catch (Exception e) {
            throw  new DAOException(String.format("Method insert(user: '%d') has thrown an exception.", user),e);
        }
    }

    @Override
    public void update(User user) {
        try(PreparedStatement statement = connection.prepareStatement(UPDATES_USER)) {
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setLong(3, user.getId());
            statement.executeUpdate();
        }catch (Exception e) {
            throw new DAOException(String.format("Method update(user: '%d') has throw an exception.",user),e);
        }
    }

    @Override
    public void deleteById(long id) {
        try(PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(String.format("Method deleteById(id:'%id) has thrown an exception.",id),e);
        }
    }
}
