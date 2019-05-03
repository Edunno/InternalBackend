/* Esben; DECK-CS */

package data;

import entity.Rentals;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
public class RentalsFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public Collection<Rentals> getAll(){
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Rentals.findAll");
        Collection<Rentals> rL = q.getResultList();
        return rL;
    }

}
