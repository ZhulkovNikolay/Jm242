package ru.usersHibernate.dao;

import org.springframework.stereotype.Component;
import ru.usersHibernate.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDaoImp implements UserDao {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();

    static {
        User user1 = new User();
        user1.setId(AUTO_ID.getAndIncrement());
        user1.setName("Petya");
        user1.setAge(22);
        user1.setEmail("petya@milo.ru");
        users.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(AUTO_ID.getAndIncrement());
        user2.setName("Vasya");
        user2.setAge(33);
        user2.setEmail("vasya@milo.ru");
        users.put(user2.getId(), user2);
    }


    @Override
    public List<User> allUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    @Override
    public void delete(int id) {
        // users.remove(user.getId(id));
        users.remove(id);
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = getById(id);
        userToBeUpdated.setName(updatedUser.getName());
    }
}
