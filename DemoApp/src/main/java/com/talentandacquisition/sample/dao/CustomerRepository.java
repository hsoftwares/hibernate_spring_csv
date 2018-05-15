package com.talentandacquisition.sample.dao;

import com.talentandacquisition.sample.model.Customer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CustomerRepository {

	private final HibernateTemplate hibernateTemplate;

	@Autowired
	public CustomerRepository(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<Customer> getAllCustomers() {
		return this.hibernateTemplate.loadAll(Customer.class);
	}

	public Customer getCustomerById(String id) {
		return this.hibernateTemplate.get(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomerByName(String name) {
		Customer customer = new Customer();
		customer.setName(name);
		return (List<Customer>) this.hibernateTemplate.findByExample(customer);
		/*
		 * return
		 * this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria
		 * (Customer.class) .add(Restrictions.like("name", name, MatchMode.ANYWHERE))
		 * .setProjection(Projections.projectionList()) .list();
		 */
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomerGroupedByZipCode() {

		return this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Customer.class)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("zipcode"))).list();

	}

}
