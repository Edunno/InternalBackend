/* Esben; DECK-CS */

package data;

import entity.Cars;
import entity.Rentals;
import entity.Users;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import utility.PuSelector;

/**
 * @author Esben
 * All rights belong to respective contributors.
 */
public class RentalsFacade {
    
    public static void main(String[] args) {
        RentalsFacade rf = new RentalsFacade();
        rf.addTestRental();
        
    }
    
    EntityManagerFactory emf = PuSelector.getEntityManagerFactory("pu");
    
    void addTestRental(){
        CarsFacade cf = new CarsFacade();
        UserFacade uf = new UserFacade();
        
        Rentals newR = new Rentals();
        Collection<Cars> hygge = new ArrayList<Cars>();
        hygge.add(cf.getCarById(1));
        newR.setCarsCollection(hygge);
        newR.setStartsAt(20190520);
        newR.setEndsAt(20190620);
        Users u = uf.getUserByUsername("user");
        newR.setUserName(u);
        addRental(newR);
    }

    public void addEntityManager(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public Collection<Rentals> getAll(){
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Rentals.findAll");
        Collection<Rentals> rL = q.getResultList();
        return rL;
    }
    public Rentals getById(int id){
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Rentals.findById").setParameter("id", id);
        Rentals r = (Rentals) q.getResultList().get(0);
        return r;
    }
    public Collection<Rentals> getByStatus(String status){
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery("Rentals.findByStatus").setParameter("status", status);
        Collection<Rentals> rL = q.getResultList();
        return rL;
    }
    
    /*
    Datamanipulation:
    */

    public Rentals addRental(Rentals r){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            return r;
        }finally{
            em.close();
        }
    }
    
    public Rentals deleteById(int id){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Rentals r = em.find(Rentals.class,(Integer) id);
            em.remove(r);
            em.getTransaction().commit();
            return r;
        }finally{
            em.close();
        }
    }
}
