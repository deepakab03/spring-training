package com.deepak.training.spring3.database.tran;

 import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.training.spring3.database.PetDao;
import com.deepak.training.spring3.database.PetHibernateDao;
import com.deepak.training.spring3.model.Pet;

/**
 * Using annotations to implement transactions
 * @author abrahade
 *
 */
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class TransactionServiceImpl2 implements TransactionService {

    private HibernateTemplate   hibernateTemplate;
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;
    private PetHibernateDao        petHibernateDao;
    private PetDao          petDao;

    public PetDao getDayFourDao() {
		return petDao;
	}

	public void setDayFourDao(PetDao petDao) {
		this.petDao = petDao;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void dojob() {
        
                Pet p = new Pet();
                p.setOwner("Ashok");
                petHibernateDao.deletePet(p);
                if (true) throw new RuntimeException("test exception 3");
    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void save() {
        Pet p = new Pet();
        p.setOwner("Ashok");
        petHibernateDao.deletePet(p);
        if (true) throw new RuntimeException("test exception 4");
    }
    
    public void find() {
        petHibernateDao.fetchAllPets();
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public PetHibernateDao getHibernateDao() {
        return petHibernateDao;
    }

    public void setHibernateDao(PetHibernateDao petHibernateDao) {
        this.petHibernateDao = petHibernateDao;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

}
