/* Esben; DECK-CS */
package data;

import entity.Cars;
import java.util.ArrayList;
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

//    public static void main(String[] args) {
//        CarsFacade cF = new CarsFacade();
//        Collection<Cars> cL = cF.getMultiSearch("", "", "", 20190506, 20190506, 0, 0);
//        ArrayList<Cars> cA = new ArrayList();
//        for (Cars c : cL) {
//            cA.add(c);
//        }
//        for (Cars c : cA) {
//            System.out.println(c.getBrand());
//        }
//    }

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

    public Collection<Cars> getByPriceClass(String priceClass) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Cars.findByPriceClass");
        q.setParameter("priceClass", priceClass);
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

    public Collection<Cars> getMultiSearch(String brand, String model, String pClass, Integer dstart, Integer dend, int distmax, int distmin, double latitude, double longitude) {
        EntityManager em = emf.createEntityManager();
        String resp = "SELECT c FROM Cars c";
        boolean flag = true;
        if (!((dstart == null) && (dend == null)) && flag) {
            resp += " JOIN c.locationsTimeCollection a WHERE NOT (a.endsAt >= :dstart AND a.startsAt <= :dend)";//Add AND a.(status) = Occupied
            flag = false;
        }
        System.out.println(resp);
        if(!((latitude == 0) &&(longitude == 0)) && flag){
            resp += " JOIN c.locationsTimeCollection a WHERE a.locLongitude = :longitude AND a.locLatitude >= :latitude";
            flag = false;
        }else if(!((latitude == 0) &&(longitude == 0))){
            resp += " AND a.locLongitude = :longitude AND a.locLatitude >= :latitude";
        }
        if (!(brand == null) && flag) {
            flag = false;
            resp += " WHERE c.brand = :brand";
        } else if (!(brand == null)) {
            resp += " AND c.brand = :brand";
        }
        if (!(model == null) && flag) {
            resp += " WHERE c.model = :model";
            flag = false;
        } else if (!(model == null)) {
            resp += " AND c.model = :model";
        }
        if (!(pClass == null) && flag) {
            resp += " WHERE c.priceClass = :priceClass";
        } else if (!(pClass == null)) {
            resp += " AND c.priceClass = :priceClass";
        }
        System.out.println(resp);
        Query q = em.createQuery(resp);
        if (!(model == null)) {
            q.setParameter("model", model);
        }
        if (!(brand == null)) {
            q.setParameter("brand", brand);
        }
        if (!(pClass == null)) {
            q.setParameter("priceClass", pClass);
        }
        if (!((dstart == null) && (dend == null))) {
            q.setParameter("dend", dend);
            q.setParameter("dstart", dstart);
        }
        if(!((latitude == 0) &&(longitude == 0))){
            q.setParameter("longitude", longitude);
            q.setParameter("latitude", latitude);
        }
        Collection<Cars> cRes = q.getResultList();
        return cRes;

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
