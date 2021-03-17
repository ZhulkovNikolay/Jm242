package ru.usersHibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.usersHibernate.model.User;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDaoImp implements UserDao {
   // private static Map<Integer, User> users = new HashMap<>();
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").getResultList();
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
    }

    @Override
    public void add(User user) {
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(User user) {
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = getById(id);
        userToBeUpdated.setName(updatedUser.getName());
    }
}
