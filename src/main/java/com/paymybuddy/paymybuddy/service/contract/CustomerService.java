package com.paymybuddy.paymybuddy.service.contract;

import java.util.List;

import com.paymybuddy.paymybuddy.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllFriends(int customerId);


}