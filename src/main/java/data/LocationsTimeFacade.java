/* Esben; DECK-CS */
package data;

import dto.LocationsTimeDTO;
import entity.LocationsTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import utility.PuSelector;

/**
 * @author Esben All rights belong to respective contributors.
 * 
 * Latitude - Longitude destinationer
 *55.629327 - 12.653356 KBH Lufthavn
 *55.695200 - 12.595645 KBH K
 *56.151684 - 10.199153 Århus
 *57.042907 - 9.922126 Aalborg
 * 
 */
public class LocationsTimeFacade {

    EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu");

    public static void main(String[] args) {
//        LocationsTimeFacade lt = new LocationsTimeFacade();
//        Collection<LocationsTime> aLT = lt.getByDateAndStatus(20180713, 20190112, "Available");
//        ArrayList<LocationsTimeDTO> dto = new ArrayList();
//        for(LocationsTime l : aLT){
//            dto.add(new LocationsTimeDTO(l));
//        }
//        
//        System.out.println(dto.get(0).getCarId());
        LocationsTimeFacade ltf = new LocationsTimeFacade();
        ltf.addLocTimeTest();

    }

    void addLocTimeTest() {
        LocationsTime lt = new LocationsTime();
        CarsFacade cf = new CarsFacade();

//        lt.setCarId(cf.getCarById(2));
//        lt.setStartsAt(20180505);
//        lt.setEndsAt(20190506);
//        lt.setStatus("Available");
//        lt.setLocLatitude(55.630171);
//        lt.setLocLongitude(12.654341);
//        addLocationsTime(lt);

        lt.setCarId(cf.getCarById(3));
        lt.setStartsAt(20190705);
        lt.setEndsAt(20190906);
        lt.setStatus("Available");
        lt.setLocLatitude(55.630171);
        lt.setLocLongitude(12.654341);
        addLocationsTime(lt);
        
//        LocationsTime lf = new LocationsTime();
//        lf.setCarId(cf.getCarById(5));
//        lf.setStartsAt(20170505);
//        lf.setEndsAt(20180930);
//        lf.setStatus("Available");
//        lf.setLocLatitude(55.630171);
//        lf.setLocLongitude(12.654341);
//        addLocationsTime(lf);
    }

    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Collection<LocationsTime> getAllLocationsTime() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("LocationsTime.findAll");
        Collection<LocationsTime> locationsTimeList = q.getResultList();
        return locationsTimeList;
    }

    public LocationsTime getById(int id) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("LocationsTime.findById");
        q.setParameter("id", id);
        LocationsTime lT = (LocationsTime) q.getResultList().get(0);
        return lT;
    }

    public Collection<LocationsTime> getByStatus(String status) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("LocationsTime.findByStatus");
        q.setParameter("status", status);
        Collection<LocationsTime> lTL = q.getResultList();
        return lTL;
    }

    public Collection<LocationsTime> getByDateAndStatus(int start, int end, String status) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("LocationsTime.findByTimeAndStatus");
        q.setParameter("startsAt", start);
        q.setParameter("endsAt", end);
        q.setParameter("status", status);
        Collection<LocationsTime> lTL = q.getResultList();
        return lTL;
    }

    public Collection<LocationsTime> getByLocationLatLon(int lattitude, int longitude) {
        EntityManager em = emf.createEntityManager();
        int approx = 1;
        Query q = em.createQuery("SELECT l FROM LocationsTime l WHERE l.locLatitude > :minLat AND l.locLatitude < :maxLat and l.locLongitude > minLon AND l.locLongitude < maxLon");
        q.setParameter("minLat", lattitude - approx);
        q.setParameter("maxLat", lattitude + approx);
        q.setParameter("minLon", longitude - approx);
        q.setParameter("maxLon", longitude + approx);
        Collection<LocationsTime> lTL = q.getResultList();
        return lTL;
    }

    /*
    Datamanipulation:
     */
    public LocationsTime addLocationsTime(LocationsTime lT) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(lT);
            em.getTransaction().commit();
            return lT;
        } finally {
            em.close();
        }
    }

    public LocationsTime deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            LocationsTime lT = em.find(LocationsTime.class, (Integer) id);
            em.remove(lT);
            em.getTransaction().commit();
            return lT;
        } finally {
            em.close();
        }
    }
}
