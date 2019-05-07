/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacades;

import com.mysql.cj.util.TestUtils;
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
        testutils.TestUtils.setupTestCars(emf);
    }

    @AfterClass
    public static void tearDownClass() {
    }
//
//    @Test
//    public void getCarById() {
//        CarsFacade cf = setEMF();
//        Cars c = cf.getCarById(1);
//        assertTrue(!c.getName().isEmpty());
//        System.out.println("Car c= " + c.getName());
//
//    }
//
//    @Test
//    public void getCarByBrand() {
//        CarsFacade cf = setEMF();
//        String brand = "Volvo";
//        Collection<Cars> c = cf.getByBrand(brand);
//        assertTrue(c.equals(cf.getByBrand(brand)));
//    }
//
//    @Test
//    public void getCarsByMinPrice() {
//        CarsFacade cf = setEMF();
//        int price = 150;
//        Collection<Cars> c = cf.getByPriceMin(price);
//        assertTrue(c.equals(cf.getByPriceMin(price)));
//    }
//
//    @Test
//    public void getCarsByMaxPrice(){
//        CarsFacade cf = setEMF();
//        int price = 150;
//        Collection<Cars> c = cf.getByPriceMax(price);
//        assertTrue(c.equals(cf.getByPriceMax(price)));
//        System.out.println(c);
//    }
//    
//    @Test
//    public void addCarTest() {
//        CarsFacade cf = setEMF();
//        Cars c = new Cars();
//        c.setId(5);
//        c.setBrand("Ford");
//        c.setModel("Focus");
//        c.setDistDriven(15000);
//        c.setComments("Knækket sidespejl");
//        c.setPrice(75);
//        c.setName("addCarTest");
//        Cars tc = cf.addCar(c);
//        assertEquals(c.getId(), tc.getId());
//
//    }
//
//    @Test
//    public void deleteCarById(){
//        CarsFacade cf = setEMF();
//        List<Cars> cars = facade.getAllCars();
//        facade.deleteCarByID(cars.get(0).getId());
//        long count = facade.countCars();
//        Assert.assertEquals(1, count);
//    }
//        CarsFacade cf = new CarsFacade();
//        int id = 1;
//        Cars c = cf.getCarById(id);
//        cf.deleteCarByID(id);
//        assertEquals();
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
//
//    private CarsFacade setEMF() {
//        CarsFacade cf = new CarsFacade();
//        EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu-unit-test");
//        cf.addEntityManager(emf);
//        return cf;
//    }
}
