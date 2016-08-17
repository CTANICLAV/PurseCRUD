package ru.stasdev.dao;


import java.util.List;

public interface GenericDAO<T> {

    T getById(Long empId);

    List<T> getAll();

    void insert(T emp);

    void update(T emp);

    void deleteById(Long empId);
}
