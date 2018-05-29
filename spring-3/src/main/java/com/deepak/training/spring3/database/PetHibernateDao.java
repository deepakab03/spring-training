package com.deepak.training.spring3.database;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.deepak.training.spring3.exception.SpringTrainRuntimeException;
import com.deepak.training.spring3.model.Pet;

/**
 * Avoid usage of hibernateTemplate for new projects
 * 
 * @author abrahd2
 */
public class PetHibernateDao implements PetDao {

    private HibernateTemplate hibernateTemplate;
    
    public PetHibernateDao(HibernateTemplate hibernateTemplate) {
        super();
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<Pet> fetchPetByPetName(Pet pet) {
        return (List<Pet>) hibernateTemplate.find("from Pet p where p.name = '" + pet.getName() + "'");
    }

    public List<Pet> fetchAllPets() {
        return (List<Pet>) hibernateTemplate.find("from Pet p");
    }

    public void inserPet(Pet p) {
        hibernateTemplate.saveOrUpdate(p);
    }

    public void updatePet(Pet p) {
        hibernateTemplate.update(p);
    }

    public void deletePet(Pet p) {
        hibernateTemplate.delete(p);

    }

    public void deletePetUsingName(Pet p) {
        // hibernateTemplate.delete( + p.getName() + "'");

    }

    @Override
    public List<Map<String, Object>> fetchAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void exceptionCreation() {
        throw new SpringTrainRuntimeException("test ex");
    }

    @Override
    public Pet fetchPetById(long petId) {
        return (Pet) hibernateTemplate.find("from Pet p where p.id = ?", (long) petId).get(0);
    }

    //how to translate exceptions to Spring exceptions in code like this?
    //how to avoid the remaining bolierplate code of opening sessions etc.
    @Override
    public int updatePetOwner(long petId, String newPetOwner) {
        int updateCount = 0;
        Session session = hibernateTemplate.getSessionFactory().openSession();
        Transaction tran = null;
        try {
            Query query = session.createQuery("update Pet set owner = :owner where id = :id");
            query.setParameter("owner", newPetOwner);
            query.setParameter("id", petId);
            
            tran = session.beginTransaction();
            updateCount =  query.executeUpdate();
            tran.commit();
        } catch (HibernateException e) {
            if (tran != null) {
                tran.rollback();  
            }
            throw e;
        } finally {
            session.close();
        }
        
        return updateCount;
    }
}
