/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testutils;

import entity.Cars;
import entity.Role;
import entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author caspe
 */
public class TestUtils {

    public static void setupTestCars(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            //System.out.println("XXXXXXXXXXXXXXXX  Creating Test users for TESTING XXXXXXXXXXXXXXXXXXXXXX");
            em.getTransaction().begin();
            //Delete existing users and roles to get a "fresh" database
//            em.createQuery("delete from Cars").executeUpdate();

            Cars c = new Cars();
            c.setPriceClass("A");
            c.setBrand("Ford");
            c.setModel("Mondeo");
            c.setDistDriven(15000);
            c.setYear("2000");
            c.setComments("Bule i højre dør");
            em.persist(c);

            Cars c2 = new Cars();
            c2.setPriceClass("E");
            c2.setBrand("VW");
            c2.setModel("Golf");
            c2.setDistDriven(20000);
            c2.setYear("2001");
            c2.setComments("Flænge i forrude");

            em.persist(c2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public static void setupTestUsers(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            //System.out.println("XXXXXXXXXXXXXXXX  Creating Test users for TESTING XXXXXXXXXXXXXXXXXXXXXX");
            em.getTransaction().begin();
            //Delete existing users and roles to get a "fresh" database
            em.createQuery("delete from Users").executeUpdate();
            em.createQuery("delete from Role").executeUpdate();

            Role userRole = new Role("user");
            Role adminRole = new Role("admin");
            Users user = new Users("user", "test");
            user.setId(1);
            user.addRole(userRole);
            Users admin = new Users("admin", "test");
            admin.setId(2);
            admin.addRole(adminRole);
            Users both = new Users("user_admin", "test");
            both.setId(3);
            both.addRole(userRole);
            both.addRole(adminRole);
            em.persist(userRole);
            em.persist(adminRole);
            em.persist(user);
            em.persist(admin);
            em.persist(both);
            System.out.println("Saved test data to database");
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
