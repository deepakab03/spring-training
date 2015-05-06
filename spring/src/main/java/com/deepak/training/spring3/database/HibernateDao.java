package com.deepak.training.spring3.database;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.deepak.training.spring3.model.Pet;

/**
 * Avoid usage of hibernateTemplate for new projects
 * 
 * @author abrahd2
 */
public class HibernateDao {

    private HibernateTemplate hibernateTemplate;

    public List<Pet> fetchPet(Pet pet) {
        return (List<Pet>) hibernateTemplate.find("Pet p where p.name = '" + pet.getName() + "'");
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

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
