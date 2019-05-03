/* Esben; DECK-CS */
package data;

import entity.Cars;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Esben All rights belong to respective contributors.
 */
public class CarsFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Collection<Cars> getAllCars() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findAll");
        Collection<Cars> carList = q.getResultList();
        return carList;
    }

    public Cars getCarById(int id) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findById");
        q.setParameter("id", id);
        Cars car = (Cars) q.getResultList().get(0);
        return car;
    }

    public Collection<Cars> getByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("");
        q.setParameter("name", name);
        Collection<Cars> carList = q.getResultList();
        return carList;
    }

    public Collection<Cars> getByDistDrivenMax(int dist) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findByDistDrivenMAX");
        q.setParameter("distDriven", dist);
        Collection<Cars> carList = q.getResultList();
        return carList;
    }

    public Collection<Cars> getByDistDrivenMin(int dist) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findByDistDrivenMIN");
        q.setParameter("distDriven", dist);
        Collection<Cars> carList = q.getResultList();
        return carList;
    }

    public Collection<Cars> getByBrand(String brand) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findByBrand");
        q.setParameter("brand", brand);
        Collection<Cars> carList = q.getResultList();
        return carList;
    }

    public Collection<Cars> getByModel(String model) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findByModel");
        q.setParameter("model", model);
        Collection<Cars> carList = q.getResultList();
        return carList;
    }

    public Collection<Cars> getByPriceMax(int price) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findByPriceMAX");
        q.setParameter("price", price);
        Collection<Cars> carList = q.getResultList();
        return carList;
    }

    public Collection<Cars> getByPriceMin(int price) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findByPriceMin");
        q.setParameter("price", price);
        Collection<Cars> carList = q.getResultList();
        return carList;
    }

    /*
    The Following method is used for data insertion.
     */
    
    public Cars addCar(Cars car){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            return car;
        }
        finally{
            em.close();
        }
    }
    
    public Cars deleteCarByID(int id){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cars car = em.find(Cars.class,(Integer) id);
            em.remove(car);
            em.getTransaction().commit();
            return car;
        } finally{
            em.close();
        }
    }
}
