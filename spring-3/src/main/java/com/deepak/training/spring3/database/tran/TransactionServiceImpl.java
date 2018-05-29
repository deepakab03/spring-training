package com.deepak.training.spring3.database.tran;

 import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.deepak.training.spring3.database.PetDao;
import com.deepak.training.spring3.database.PetHibernateDao;
import com.deepak.training.spring3.model.Pet;


public class TransactionServiceImpl implements TransactionService {

    private TransactionTemplate transactionTemplate;
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

	@SuppressWarnings("unchecked")
    public void dojob() {
        transactionTemplate.execute(new TransactionCallback() {

            public Object doInTransaction(TransactionStatus arg0) {
//                try {
                    Pet p = new Pet();
                    p.setOwner("Ashok");
                    petHibernateDao.deletePet(p);
//                    if (true) throw new RuntimeException("test exception");
//                    return null;
//                } catch (Exception e) {
//                    arg0.setRollbackOnly();
//                    e.printStackTrace();
//                }
                return null;
            }

        });
    }

    public void save() {
        Pet p = new Pet();
        p.setOwner("Ashok");
        petHibernateDao.deletePet(p);
//        if (true) throw new RuntimeException("test exception 2");
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
