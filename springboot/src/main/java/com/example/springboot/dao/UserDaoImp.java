package com.example.springboot.dao;

import com.example.springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        String queryString = "SELECT u FROM User u";
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void editUser(User user) {
        User existingUser = entityManager.find(User.class, user.getId());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setSurname(user.getSurname());
            existingUser.setAge(user.getAge());
        }
    }

    @Override
    public void removeUser(long id) {
        User existingUser = entityManager.find(User.class, id);
        entityManager.remove(existingUser);
    }
}
