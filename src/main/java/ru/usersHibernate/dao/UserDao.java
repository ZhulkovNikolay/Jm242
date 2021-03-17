package ru.usersHibernate.dao;

import ru.usersHibernate.model.User;

import java.util.List;

public interface UserDao {

    List<User> allUsers();

    void add(User user);

    void delete(int id);

    void edit(User user);

    User getById(int id);

    void update(int id, User updatedUser);
}
