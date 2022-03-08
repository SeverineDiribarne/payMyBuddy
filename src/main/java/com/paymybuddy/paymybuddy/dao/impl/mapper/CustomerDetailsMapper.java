package com.paymybuddy.paymybuddy.dao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.paymybuddy.paymybuddy.model.Customer;

public class CustomerDetailsMapper implements RowMapper<Customer> {

	/**
	 * transform the query FIND_BY_EMAIL into a java object
	 * @return new Customer
	 */
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	return new Customer (rs.getInt("id"),rs.getString("email"),rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"));
	}
}
