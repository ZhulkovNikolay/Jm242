package ru.usersHibernate.dao;

import ru.usersHibernate.model.User;

import java.util.List;

public interface UserDao {

    List<User> allUsers();

    void add(User user);

    void delete(int id);

    User getById(int id);

    void update(User updatedUser);
}
