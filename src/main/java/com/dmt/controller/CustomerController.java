package com.dmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.model.Customer;
import com.dmt.service.CustomerService;

@Controller
public class CustomerController {

	@RequestMapping(value = "/manager-customer")
	public String managerCustomer(HttpServletRequest request) {
		CustomerService customerS = new CustomerService();
		try {
			List<Customer> list = customerS.getAllCustomer();
			if (list.isEmpty() == false && list != null) {
				request.setAttribute("listCustomer", list);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "customerManager";
	}

	@RequestMapping(value = "/add-customer", method = RequestMethod.GET)
	public String addNewCustomer() {
		return "AddNewCustomer";
	}

	@RequestMapping(value = "/add-customer", method = RequestMethod.POST)
	public String addNewCustomer(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address,
			HttpServletRequest request) {

		CustomerService customerS = new CustomerService();
		try {
			customerS.addNewCustomer(userName, password, fullName, email, phoneNumber, address);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/manager-customer";
	}

	@RequestMapping(value = "/update-customer", method = RequestMethod.GET)
	public String updateCustomer(@RequestParam("id") int id, @RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("fullName") String fullName,
			@RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address, HttpServletRequest request) {
		request.setAttribute("id", id);
		request.setAttribute("userName", userName);
		request.setAttribute("password", password);
		request.setAttribute("fullName", fullName);
		request.setAttribute("email", email);
		request.setAttribute("phoneNumber", phoneNumber);
		request.setAttribute("address", address);
		return "UpdateCustomer";
	}

	@RequestMapping(value = "/update-customer", method = RequestMethod.POST)
	public String updateNewCustomer(@RequestParam("id") int id, @RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("fullName") String fullName,
			@RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address, HttpServletRequest request) {
		CustomerService customerS = new CustomerService();
		try {
			customerS.updateCustomer(id, userName, password, fullName, email, phoneNumber, address);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/manager-customer";
	}

	@RequestMapping(value = "/delete-customer", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam("id") int id) {
		CustomerService customerS = new CustomerService();
		try {
			customerS.deleteCustomer(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/manager-customer";
	}

	@RequestMapping(value = "/search-customer", method = RequestMethod.POST)
	public String searchCustomer(@RequestParam("key") String key, HttpServletRequest request) {
		CustomerService customerS = new CustomerService();
		try {
			List<Customer> list = customerS.searchCustomer(key);
			request.setAttribute("listCustomer", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "customerManager";
	}

}
