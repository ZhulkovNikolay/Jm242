package ru.usersHibernate.Service;

import ru.usersHibernate.model.User;

import java.util.List;

public interface UserService {

    List<User> allUsers();

    void add(User user);

    void delete(User user);

    void edit(User user);

    User getById(int id);

    void update(int id, User updatedUser);
}
