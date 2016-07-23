package ru.stasdev.dao;

import ru.stasdev.domain.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDAOJdbcImpl implements CurrencyDAO {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM currency WHERE id = ?";
    public static final String INSERT_CURRENCY = "INSERT INTO currency (name) VALUES (?)";
    public static final String SELECT_FROM_ALL_CURRENCY = "SELECT * FROM currency";
    public static final String UPDATES_CURRENCY = "UPDATE currency SET name = ? WHERE id = ?";
    public static final String DELETE_CURRENCY = "DELETE FROM currency WHERE id = ?";

    private Connection connection;

    public CurrencyDAOJdbcImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public Currency getById(long id) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new Currency(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME));

                }
            }
        } catch (Exception e) {
            throw new DAOException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public List<Currency> getAll() {
        List<Currency> currency = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_FROM_ALL_CURRENCY);) {
                while (resultSet.next()) {
                    currency.add(new Currency(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME)));
                }
            }
        } catch (Exception e) {
            throw new DAOException(String.format("Method getAll Currency; has throw an exception."), e);
        }
        return currency;
    }

    @Override
    public void insert(Currency currency) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_CURRENCY);) {
            statement.setString(1, currency.getName());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new DAOException("Table 'Purses' was not updated", null);
            }
        } catch (Exception e) {
            throw new DAOException(String.format("Method insert(currency: '%d') has throw an exception.", currency), e);
        }
    }

    @Override
    public void update(Currency currency) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATES_CURRENCY);) {
            statement.setString(1, currency.getName());
            statement.setLong(2, currency.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(String.format("Method update(currency: '%d') has throw an exception.", currency), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_CURRENCY);) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(String.format("Method deleteById(id: '%d') has throw an exception.", id), e);
        }
    }
}