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
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import utility.PuSelector;
import testutils.TestUtils;

/**
 *
 * @author caspe
 */
public class CarsFacadeTest {

    public CarsFacadeTest() {
    }

    private static CarsFacade facade;

    @BeforeClass
    public static void setupClass() {
        EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu-unit-test");
        facade = CarsFacade.getInstance(emf);
        TestUtils.setupTestCars(emf);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void getCarById() {
        Cars c = facade.getCarById(1);
        assertTrue(!c.getPriceClass().isEmpty());
        System.out.println("Car c= " + c.getPriceClass());

    }

    @Test
    public void getCarByBrand() {
        String brand = "Volvo";
        Collection<Cars> c = facade.getByBrand(brand);
        assertTrue(c.equals(facade.getByBrand(brand)));
    }

    @Test
    public void addCarTest() {
        Cars c = new Cars();
        c.setId(5);
        c.setBrand("Ford");
        c.setModel("Focus");
        c.setDistDriven(15000);
        c.setComments("Knækket sidespejl");
        c.setYear("2000");
        c.setPriceClass("A");
        Cars tc = facade.addCar(c);
        assertEquals(c.getId(), tc.getId());

    }

//    @Test
//    public void deleteCarById() {
//        Collection<Cars> cars = facade.getAllCars();
//        facade.deleteCarByID(cars.get(0).getId());
//        long count = facade.countCars();
//        Assert.assertEquals(1, count);
//    }
//    CarsFacade cf = new CarsFacade();
//    int id = 1;
//    Cars c = cf.getCarById(id);
//
//    cf.deleteCarByID (id);
//
//    assertEquals();


//    @Test
//    public void addEntityManager() {
//        CarsFacade cf = new CarsFacade();
//        EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu-unit-test");
//        try {
//            cf.addEntityManager(emf);
//        } catch (Exception e) {
//            assertTrue(false);
//        }
//        assertTrue(true);
//    }
    

//    private CarsFacade setEMF() {
//        CarsFacade cf = new CarsFacade();
//        EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu-unit-test");
//        cf.addEntityManager(emf);
//        return cf;
//    }

}