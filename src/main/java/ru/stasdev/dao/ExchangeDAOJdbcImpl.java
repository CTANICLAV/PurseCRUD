package ru.stasdev.dao;

import ru.stasdev.domain.Exchange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExchangeDAOJdbcImpl implements ExchangeDAO {

    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM exchange WHERE id = ?";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DOMESTIC_PRICE = "sourceCurrencyId";
    public static final String COLUMN_FOREIGN_PRICE = "targetCurrencyId";
    public static final String COLUMN_EXCHANGE_RATE = "exchangeRate";
    public static final String INSERT_EXCHANGE = "INSERT INTO exchange (sourceCurrencyId, targetCurrencyId, exchangeRate) VALUES (?, ?, ?)";
    public static final String SELECT_FROM_ALL_EXCHANGE = "SELECT * FROM exchange";
    public static final String UPDATES_EXCHANGE = "UPDATE exchange SET sourceCurrencyId = ?, targetCurrencyId = ?, exchangeRate = ? WHERE id = ?";
    public static final String DELETE_EXCHANGE = "DELETE FROM exchange WHERE id = ?";

    private Connection connection;

    public ExchangeDAOJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Exchange getById(long id) {
        try(PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Exchange(resultSet.getLong(COLUMN_ID),
                            resultSet.getLong(COLUMN_DOMESTIC_PRICE),
                            resultSet.getLong(COLUMN_FOREIGN_PRICE),
                            resultSet.getDouble(COLUMN_EXCHANGE_RATE));
                }
            }
        } catch (Exception e) {
            throw new DAOException(String.format("Method getById(%s) has thrown an exception", id), e);
        }
        return null;
    }

    @Override
    public void insert(Exchange exchange) {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_EXCHANGE)) {
            statement.setLong(1, exchange.getSourceCurrencyId());
            statement.setLong(2, exchange.getTargetCurrencyId());
            statement.setDouble(3, exchange.getExchangeRate());
            int i = statement.executeUpdate();
            if (i<0) {
                throw new DAOException("Table 'Purses' was not updated",null);
            }
        } catch (Exception e) {
            throw new DAOException(String.format("Method insert(%s) has thrown an exception",exchange), e);
        }
    }

    @Override
    public List<Exchange> getAll() {
        List<Exchange> exchanges = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            try(ResultSet resultSet = statement.executeQuery(SELECT_FROM_ALL_EXCHANGE)) {
                while (resultSet.next()) {
                    exchanges.add(new Exchange(resultSet.getLong(COLUMN_ID),
                            resultSet.getLong(COLUMN_DOMESTIC_PRICE),
                            resultSet.getLong(COLUMN_FOREIGN_PRICE),
                            resultSet.getDouble(COLUMN_EXCHANGE_RATE)));
                }
            }
        } catch (Exception e) {
            throw new DAOException(String.format("Method getAll has thrown an exception"), e);
        }
        return exchanges;
    }

    @Override
    public void update(Exchange exchange) {
        try(PreparedStatement statement = connection.prepareStatement(UPDATES_EXCHANGE)) {
            statement.setLong(1, exchange.getSourceCurrencyId());
            statement.setLong(2, exchange.getTargetCurrencyId());
            statement.setDouble(3, exchange.getExchangeRate());
            statement.setLong(4, exchange.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(String.format("Method update exchange(%s)has thrown an Exception",exchange), e);
        }
    }

    @Override
    public void deleteById(long id) {
        try(PreparedStatement statement = connection.prepareStatement(DELETE_EXCHANGE)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            throw  new DAOException(String.format("Method deleteById(%s) has thrown an exception.", id), e);
        }
    }
}
