/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacades;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import unit.createData;
import data.CarsFacade;

/**
 *
 * @author Esben
 */
public class XFacadeTest {

    public XFacadeTest() {
    }

    @BeforeClass
    public static void setUp() {
        createData.makeHappen();
    }

    @After
    public void tearDown() {
    }

  
}
