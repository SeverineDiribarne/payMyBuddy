package com.paymybuddy.paymybuddy.dao.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.paymybuddy.paymybuddy.dao.contract.TransferDao;
import com.paymybuddy.paymybuddy.dao.impl.mapper.LastTransferIdRowMapper;
import com.paymybuddy.paymybuddy.dao.impl.mapper.TransferRowMapper;
import com.paymybuddy.paymybuddy.model.Connection;
import com.paymybuddy.paymybuddy.model.Transfer;
import com.paymybuddy.paymybuddy.model.TransferType;

@Repository
public class TransferDaoImpl implements TransferDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	private static final String GET_TRANSFERS_QUERY =  
			"SELECT con.connectionId, con.connectionSource, con.connectionRecipient, t.transferDate, t.description, t.amount "
			+ "FROM transfer t "
			+ "JOIN connection con ON t.connection = con.connectionId "
			+ "JOIN customer cust ON con.connectionSource = cust.id "
			+ "WHERE cust.id = ?;";
	/**
	 * Get all transfers in the list
	 */
	@Override
	public List<Transfer> getListOfTransfers(int mainUserId) {
	 return jdbcTemplate.query(GET_TRANSFERS_QUERY, new TransferRowMapper(), mainUserId);	
	}
	
	private static final String INSERT_TRANSFER = "INSERT INTO transfer "
			+ "(transferDate, connection, description, amount, transfer_type)"
			+ " VALUES (?,?,?,?,?);" ;
	/**
	 * add a payment in database
	 */
	@Override
	public void addPayment(Date date, Connection connection, String description, double amount) {
		jdbcTemplate.update(INSERT_TRANSFER, date, connection.getConnectionId(), description, amount, (amount < 0) ? TransferType.DEBIT.getValue() : TransferType.CREDIT.getValue());	 
	}
	
	public static final String GET_LAST_TRANSFER_ID_QUERY = "select max(t.transferId) AS transferId  FROM transfer t;";
	
	@Override
	public Transfer getLastTransferId() {
		return jdbcTemplate.queryForObject(GET_LAST_TRANSFER_ID_QUERY, new LastTransferIdRowMapper());
	}
}