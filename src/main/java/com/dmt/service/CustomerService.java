package com.dmt.service;

import java.util.List;

import com.dmt.dao.CustomerDao;
import com.dmt.model.Customer;

public class CustomerService {
	
	CustomerDao dao = new CustomerDao();

	public void addNewCustomer(String username, String password, String fullName, String email, String phoneNumber, String address) throws Exception {
		dao.addNewCustomer(username, password, fullName, email, phoneNumber, address);
	}

	public void updateCustomer(int id, String username, String password, String fullName, String email, String phoneNumber, String address) throws Exception {
		dao.updateCustomer(id, username, password, fullName, email, phoneNumber, address);
	}

	public void deleteCustomer(int id) throws Exception {
		dao.deleteCustomer(id);
	}

	public List<Customer> getAllCustomer() throws Exception {
		return dao.getAllCustomer();
	}
	
	public List<Customer> searchCustomer(String key) throws Exception {
		return dao.searchCustomer(key);
	}


}
