/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dto.UsersDTO;
import entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import exceptions.AuthenticationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Query;
import utility.PuSelector;

/**
 *
 * @author caspe
 */
public class UserFacade {

    private static EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu");
    private static UserFacade instance;

    public UserFacade() {
    }

    public static UserFacade getInstance(EntityManagerFactory factory) {
        if (instance == null) {
            emf = factory;
            instance = new UserFacade();
        }
        return instance;
    }

    public Users getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        Users user;
        try {
            user = em.find(Users.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public List<Users> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Users.findAll");
        List<Users> userList = q.getResultList();
        return userList;
    }

    public Users getUserByUsername(String username) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Users.findByUserName");
        q.setParameter("userName", username);
        Users u = (Users) q.getResultList().get(0);
        return u;
    }

//    public Users getUserById(int id) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Users u = em.find(Users.class, (Integer) id);
//            return u;
//        } finally {
//            em.close();
//        }
//    }
}
