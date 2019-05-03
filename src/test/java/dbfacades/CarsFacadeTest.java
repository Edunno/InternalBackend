/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacades;

import data.CarsFacade;
import entity.Cars;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author caspe
 */
public class CarsFacadeTest {

    public CarsFacadeTest() {
    }

    @BeforeClass
    public static void setupClass() {
        CarsFacadeTest t1 = new CarsFacadeTest();
        CarsFacade cf = t1.setEMF();

        Cars c = new Cars();
        c.setId(1);
        c.setBrand("Ford");
        c.setModel("Mondeo");
        c.setDistDriven(15000);
        c.setComments("Bule i højre dør");
        c.setPrice(100);
        cf.addCar(c);

        Cars c2 = new Cars();
        c2.setId(2);
        c.setBrand("VW");
        c.setModel("Golf");
        c.setDistDriven(20000);
        c.setComments("Flænge i forrude");
        c.setPrice(200);
        cf.addCar(c2);
    }

    @AfterClass
    public static void tearDownClass() {
        CarsFacadeTest t1 = new CarsFacadeTest();
        CarsFacade cf = t1.setEMF();
        int id = 1;
        Cars c = cf.getCarById(id);
        cf.deleteCarByID(id);
        int id2 = 2;
        Cars c2 = cf.getCarById(id2);
        cf.deleteCarByID(id2);

    }


    @Test
    public void getCarById() {
        CarsFacade cf = setEMF();
        int id = 1;
        Cars c = cf.getCarById(id);
        assertEquals((int) id, (int) c.getId());

    }

    @Test
    public void getCarByBrand() {
        CarsFacade cf = setEMF();

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void addEntityManager() {
        CarsFacade cf = new CarsFacade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        try {
            cf.addEntityManager(emf);
        } catch (Exception e) {
            assertTrue(false);
        }
        assertTrue(true);
    }

    private CarsFacade setEMF() {
        CarsFacade cf = new CarsFacade();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        cf.addEntityManager(emf);
        return cf;
    }
}
