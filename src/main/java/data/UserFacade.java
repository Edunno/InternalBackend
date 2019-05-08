/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import exceptions.AuthenticationException;

/**
 *
 * @author caspe
 */
public class UserFacade {
  
    private static EntityManagerFactory emf;
    private static UserFacade instance;
    
    private UserFacade(){}
    
    public static UserFacade getInstance(EntityManagerFactory factory){
        if(instance == null){
          emf = factory;
          instance = new UserFacade();
        }
        return instance;
    }
    
    public Users getVeryfiedUser(int id, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        Users user;
        try {
            user = em.find(Users.class, id);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

}
