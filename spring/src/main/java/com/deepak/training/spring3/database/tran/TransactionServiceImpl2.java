package com.deepak.training.spring3.database.tran;

 import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deepak.training.spring3.database.DayFourDao;
import com.deepak.training.spring3.database.HibernateDao;
import com.deepak.training.spring3.model.PetOld;

/**
 * Using annotations to implement transactions
 * @author abrahade
 *
 */
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class TransactionServiceImpl2 implements TransactionService {

    private HibernateTemplate   hibernateTemplate;
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;
    private HibernateDao        hibernateDao;
    private DayFourDao          dayFourDao;

    public DayFourDao getDayFourDao() {
		return dayFourDao;
	}

	public void setDayFourDao(DayFourDao dayFourDao) {
		this.dayFourDao = dayFourDao;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void dojob() {
        
                PetOld p = new PetOld();
                p.setOwner("Ashok");
                hibernateDao.deletePet(p);
                if (true) throw new RuntimeException("test exception 3");
    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void save() {
        PetOld p = new PetOld();
        p.setOwner("Ashok");
        hibernateDao.deletePet(p);
        if (true) throw new RuntimeException("test exception 4");
    }
    
    public void find() {
        hibernateDao.fetchAllPets();
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateDao getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDao hibernateDao) {
        this.hibernateDao = hibernateDao;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

}
