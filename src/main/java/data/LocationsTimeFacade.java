/* Esben; DECK-CS */
package data;

import entity.LocationsTime;
import java.util.Collection;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Esben All rights belong to respective contributors.
 */
public class LocationsTimeFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

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

    public Collection<LocationsTime> getByDateAndStatus(Date start, Date end, String status) {
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
        q.setParameter("minLat", lattitude-approx);
        q.setParameter("maxLat", lattitude+approx);
        q.setParameter("minLon", longitude-approx);
        q.setParameter("maxLon", longitude+approx);
        Collection<LocationsTime> lTL = q.getResultList();
        return lTL;
    }
}
