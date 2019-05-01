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

    public Collection<Cars> getByDistDrivenMAX(int dist) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findByDistDrivenMAX");
        q.setParameter("distDriven", dist);
        Collection<Cars> carList = q.getResultList();
        return carList;
    }

    public Collection<Cars> getByDistDrivenMIN(int dist) {
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
}
