package com.talentandacquisition.sample.dao;

import com.talentandacquisition.sample.model.Customer;

import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getAllCustomers() {

		return this.customerRepository.getAllCustomers();
	}

	public Customer getCustomerById(String id) {
		return customerRepository.getCustomerById(id);
	}

	public List<Customer> getCustomerByName(String name) {
		return customerRepository.getCustomerByName(name);
	}

	public List<Customer> getAllCustomerGroupedByZipCode() {
		return this.customerRepository.getAllCustomerGroupedByZipCode();
	}
}
