package com.perot.training.dayfour.tran;

 import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.perot.training.dayfour.DayFourDao;
import com.perot.training.dayfour.HibernateDao;
import com.perot.training.dayfour.model.Pet;

/**
 * Using annotations to implement transactions
 * @author abrahade
 *
 */
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class TransactionServiceImpl2 implements TransactionService {

    private HibernateTemplate   hibernateTemplate;
    private SimpleJdbcTemplate  SimpleJdbcTemplate;
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
        
                Pet p = new Pet();
                p.setOwner("Ashok");
                hibernateDao.deletePet(p);
                if (true) throw new RuntimeException("test exception 3");
    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public void save() {
        Pet p = new Pet();
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

    public SimpleJdbcTemplate getSimpleJdbcTemplate() {
        return SimpleJdbcTemplate;
    }

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
        SimpleJdbcTemplate = simpleJdbcTemplate;
    }

    public HibernateDao getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDao hibernateDao) {
        this.hibernateDao = hibernateDao;
    }

}
