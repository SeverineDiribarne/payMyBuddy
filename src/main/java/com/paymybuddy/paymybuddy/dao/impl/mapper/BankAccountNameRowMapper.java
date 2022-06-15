package com.paymybuddy.paymybuddy.dao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.paymybuddy.paymybuddy.model.BankAccount;

public class BankAccountNameRowMapper implements RowMapper<BankAccount> {

	/**
	 * retrieves the information of the bankAccountName in the database
	 */
	@Override
	public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new BankAccount(rs.getString("bankAccountName"));
	}
}