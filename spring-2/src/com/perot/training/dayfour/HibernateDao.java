package com.perot.training.dayfour;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.perot.training.dayfour.model.Pet;


public class HibernateDao {

    private HibernateTemplate hibernateTemplate;

    public List<Pet> fetchPet(Pet pet) {
        return hibernateTemplate.find("Pet p where p.name = '" + pet.getName() + "'");
    }

    public List<Pet> fetchAllPets() {
        return hibernateTemplate.find("from Pet p");
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
//        hibernateTemplate.delete( + p.getName() + "'");
    	
    }


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
