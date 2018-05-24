package com.perot.training.dayfour.tran;

 import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.perot.training.dayfour.DayFourDao;
import com.perot.training.dayfour.HibernateDao;
import com.perot.training.dayfour.model.Pet;


public class TransactionServiceImpl implements TransactionService {

    private TransactionTemplate transactionTemplate;
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

	public void dojob() {
        transactionTemplate.execute(new TransactionCallback() {

            public Object doInTransaction(TransactionStatus arg0) {
//                try {
                    Pet p = new Pet();
                    p.setOwner("Ashok");
                    hibernateDao.deletePet(p);
                    if (true) throw new RuntimeException("test exception");
                    return null;
//                } catch (Exception e) {
//                    arg0.setRollbackOnly();
//                    e.printStackTrace();
//                }
//                return null;
            }

        });
    }

    public void save() {
        Pet p = new Pet();
        p.setOwner("Ashok");
        hibernateDao.deletePet(p);
        if (true) throw new RuntimeException("test exception 2");
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
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
