/* Esben; DECK-CS */
package data;

import entity.Cars;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import utility.PuSelector;

/**
 * @author Esben All rights belong to respective contributors.
 */
public class CarsFacade {

    private static EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu");
    private static CarsFacade instance;

    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static CarsFacade getInstance(EntityManagerFactory factory) {
        if (instance == null) {
            emf = factory;
            instance = new CarsFacade();
        }
        return instance;
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

    public Collection<Cars> getMultiSearch(String brand, String model, int prmax, int prmin, Integer dstart, Integer dend, int distmax, int distmin) {
        EntityManager em = emf.createEntityManager();
           String resp = "SELECT c FROM Cars c";
        boolean flag = true;
        if (!((dstart == null) && (dend == null)) && flag) {
            resp += " NATURAL JOIN LocationsTime b WHERE c.b.starts_at >= :dstart AND c.b.ends_at <= :dend AND c.b.status = Available";
            flag = false;
        }
        if (!brand.isEmpty() && flag) {
            flag = false;
            resp += " WHERE c.brand = :brand";
        }else if(!brand.isEmpty()){
            resp += " AND c.brand = :brand";
        }
        if (!model.isEmpty() && flag) {
            resp += " WHERE c.model = :model";
            flag = false;
        } else if (!model.isEmpty()) {
            resp += " AND c.model = :model";
        }
        return null;
        
    }

    /*
    The Following method is used for data insertion.
     */
    public Cars addCar(Cars car) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            return car;
        } finally {
            em.close();
        }
    }

    public Cars deleteCarByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cars car = em.find(Cars.class, (Integer) id);
            em.remove(car);
            em.getTransaction().commit();
            return car;
        } finally {
            em.close();
        }
    }
}
