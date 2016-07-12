package ru.stasdev.service;

import ru.stasdev.domain.User;

import java.util.List;

public interface UserService {

    User getById(long id);

    void insert(User user);

    List<User> getAll();

    void update(User user);

    void deleteById(long id);
}
