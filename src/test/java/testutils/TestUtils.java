/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testutils;

import entity.Cars;
import entity.Role;
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
            em.createQuery("delete from Cars").executeUpdate();

            Cars c = new Cars();
            c.setName("test");
            c.setBrand("Ford");
            c.setModel("Mondeo");
            c.setDistDriven(15000);
            c.setComments("Bule i højre dør");
            c.setPrice(100);
            em.persist(c);

            Cars c2 = new Cars();
            c2.setName("test2");
            c2.setBrand("VW");
            c2.setModel("Golf");
            c2.setDistDriven(20000);
            c2.setComments("Flænge i forrude");
            c2.setPrice(200);
            em.persist(c2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

}
