package com.deepak.training.spring3.database;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.deepak.training.spring3.model.PetOld;

/**
 * Avoid usage of hibernateTemplate for new projects
 * 
 * @author abrahd2
 */
public class HibernateDao {

    private HibernateTemplate hibernateTemplate;

    public List<PetOld> fetchPet(PetOld petOld) {
        return (List<PetOld>) hibernateTemplate.find("PetOld p where p.name = '" + petOld.getName() + "'");
    }

    public List<PetOld> fetchAllPets() {
        return (List<PetOld>) hibernateTemplate.find("from PetOld p");
    }

    public void inserPet(PetOld p) {
        hibernateTemplate.saveOrUpdate(p);
    }

    public void updatePet(PetOld p) {
        hibernateTemplate.update(p);
    }

    public void deletePet(PetOld p) {
        hibernateTemplate.delete(p);

    }

    public void deletePetUsingName(PetOld p) {
        // hibernateTemplate.delete( + p.getName() + "'");

    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
