package utility;

import entity.Cars;
import entity.Role;
import entity.Users;
import javax.persistence.EntityManager;

public class SetupTestUsers {

  public static void main(String[] args) {
      SetupTestUsers su = new SetupTestUsers();
     // su.createCarForDB();
      su.createUsers();


   
  }
  
//  void createCarForDB(){
//      EntityManager em = PuSelector.getEntityManagerFactory("pu").createEntityManager();
//      em.getTransaction().begin();
//      Cars car = new Cars();
//      car.setPriceClass("E");
//      car.setBrand("Mercedes");
//      car.setComments("Experience tranquility");
//      car.setDistDriven(10240);
//      car.setModel("E200");
//      car.setYear("2015");
//      em.persist(car);
//      em.getTransaction().commit();
//      
//      
//  }
  
  void createUsers(){
          EntityManager em = PuSelector.getEntityManagerFactory("pu").createEntityManager();
       
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    
    //throw new UnsupportedOperationException("REMOVE THIS LINE, WHEN YOU HAVE READ WARNING");
    
    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    Users user = new Users("user", "test");
    user.addRole(userRole);
    Users admin = new Users("admin", "test");
    admin.addRole(adminRole);
    Users both = new Users("user_admin", "test");
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
  }

}
