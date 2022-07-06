package com.greatlearning.crm.Service;

import java.util.List;


import javax.transaction.Transactional;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.crm.Model.CustomerRelationshipManager;

@Service
public class CRMServiceImplementation implements CRMService{
	SessionFactory sessionFactory;
	Session session;
	@Autowired
	public CRMServiceImplementation(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = sessionFactory.getCurrentSession();
		}
		catch (HibernateException e) {
			this.session=sessionFactory.openSession();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CustomerRelationshipManager> listAllData() {
		return (List<CustomerRelationshipManager>)session.createQuery("from CustomerRelationshipManager").list();
	}

	@Override
	public void save(CustomerRelationshipManager crm) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(crm);
		transaction.commit();
	}

	@Override
	@Transactional
	public CustomerRelationshipManager delete(int id) {
		Transaction transaction = session.beginTransaction();
		CustomerRelationshipManager crm = session.get(CustomerRelationshipManager.class,id);
		session.delete(crm);
		transaction.commit();
		return crm;
	}

	@Override
	public CustomerRelationshipManager getCustomer(int id) {
		return session.get(CustomerRelationshipManager.class,id);
	}

}
