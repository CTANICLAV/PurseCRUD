package ru.stasdev.service;

public class CanNotDeleteCurrencyException extends ServiceException {

    public CanNotDeleteCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }
}
