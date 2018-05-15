package com.talentandacquisition.sample.controller;

import com.talentandacquisition.sample.dao.CustomerService;
import com.talentandacquisition.sample.model.Customer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Controller
@Slf4j
public class CustomerInformationResource {

	private CustomerService customerService;

	@PostConstruct
	public void init() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.talentandacquisition.sample.dao");
		ctx.refresh();
		customerService = ctx.getBean("customerService", CustomerService.class);
	}

	@ResponseBody
	@RequestMapping(value = "/customer-id/{_id}", method = RequestMethod.GET, produces = "application/json")
	public Customer getCustomerInfoById(@PathVariable("_id") String id) {
		return customerService.getCustomerById(id);
	}

	@ResponseBody
	@RequestMapping(value = "/customer-name/{name}", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> getCustomerInfoByName(@PathVariable("name") String name) {
		return customerService.getCustomerByName(name);
	}

	@ResponseBody
	@RequestMapping(value = "/customer-zipcode", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> getCustomerInfoByName() {
		return customerService.getAllCustomerGroupedByZipCode();
	}

}
