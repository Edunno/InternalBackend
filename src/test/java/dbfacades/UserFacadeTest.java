/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacades;

import data.UserFacade;
import entity.Users;
import exceptions.AuthenticationException;
import javax.persistence.EntityManagerFactory;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import testutils.TestUtils;
import utility.PuSelector;

/**
 *
 * @author caspe
 */
public class UserFacadeTest {
    
      private static UserFacade facade;
  
  @BeforeClass
  public static void setUpClass() {
    EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu-unit-test");
    facade = UserFacade.getInstance(emf);
    TestUtils.setupTestUsers(emf);
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
 
//  @Test
//   public void getUserValid() throws AuthenticationException {
//     Users u = facade.getVeryfiedUser("test", "test");
//     assertEquals("user", u.getUserName());
//   }
// 
//   @Test(expected = AuthenticationException.class)
//   public void getUserInValid() throws AuthenticationException {
//     Users u = facade.getVeryfiedUser("test", "testxxxx");
//     assertEquals("user", u.getUserName());
//   }
    
}
