package ru.stasdev.dao;

import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.stasdev.domain.Currency;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CurrencyDaoJdbcImpl implements CurrencyDao {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM currency WHERE id = ?";
    public static final String INSERT_CURRENCY = "INSERT INTO currency (name) VALUES (?)";
    public static final String SELECT_FROM_ALL_CURRENCY = "SELECT * FROM currency";
    public static final String UPDATES_CURRENCY = "UPDATE currency SET name = ? WHERE id = ?";
    public static final String DELETE_CURRENCY = "DELETE FROM currency WHERE id = ?";

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Currency getById(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new Currency(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME));

                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public List<Currency> getAll() {
        List<Currency> currency = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_FROM_ALL_CURRENCY);) {
                while (resultSet.next()) {
                    currency.add(new Currency(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll Currency; has throw an exception."), e);
        }
        return currency;
    }

    @Override
    public void insert(Currency currency) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CURRENCY);) {
            statement.setString(1, currency.getName());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new DaoException("Table 'Purses' was not updated", null);
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method insert(currency: '%d') has throw an exception.", currency), e);
        }
    }

    @Override
    public void update(Currency currency) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATES_CURRENCY);) {
            statement.setString(1, currency.getName());
            statement.setLong(2, currency.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method update(currency: '%d') has throw an exception.", currency), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CURRENCY);) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(String.format("Method deleteById(id: '%d') has throw an exception.", id), e);
        }
    }
}