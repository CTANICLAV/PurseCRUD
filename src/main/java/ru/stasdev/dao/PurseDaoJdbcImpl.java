package ru.stasdev.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.stasdev.domain.Purse;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PurseDaoJdbcImpl implements PurseDao {

    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM purse WHERE id = ?";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER = "ownerId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CURRENCY = "currencyId";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String INSERT_PURSE = "INSERT INTO purse (ownerId, currencyId, name, amount) VALUES (?, ?, ?, ?)";
    public static final String SELECT_FROM_ALL_PURSE = "SELECT * FROM purse";
    public static final String UPDATES_PURSE = "UPDATE purse SET ownerId = ?, currencyId = ?, name = ?, amount = ? WHERE id = ?";
    public static final String DELETE_PURSE = "DELETE FROM purse WHERE id = ?";

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Purse getById(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new Purse(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME),
                            resultSet.getInt(COLUMN_CURRENCY),
                            resultSet.getInt(COLUMN_USER),
                            resultSet.getInt(COLUMN_AMOUNT));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public void insert(Purse purse) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PURSE);) {
            statement.setLong(1, purse.getOwnerId());
            statement.setLong(2, purse.getCurrencyId());
            statement.setString(3, purse.getName());
            statement.setLong(4,purse.getAmount());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new DaoException("Table 'Purses' was not updated", null);
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method insert(purse: '%d') has throw an exception.", purse), e);
        }
    }

    @Override
    public List<Purse> getAll() {
        List<Purse> purse = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_FROM_ALL_PURSE);) {
                while (resultSet.next()) {
                    purse.add(new Purse(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME),
                            resultSet.getInt(COLUMN_CURRENCY),
                            resultSet.getInt(COLUMN_USER),
                            resultSet.getInt(COLUMN_AMOUNT)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll Purses; has throw an exception."), e);
        }
        return purse;
    }


    @Override
    public void update(Purse purse) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATES_PURSE);) {
            statement.setLong(1, purse.getOwnerId());
            statement.setLong(2, purse.getCurrencyId());
            statement.setString(3, purse.getName());
            statement.setLong(4, purse.getAmount());
            statement.setLong(5, purse.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method update(purse: '%d') has throw an exception.", purse), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PURSE);) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method deleteById(id: '%d') has throw an exception.", id), e);
        }
    }

}
