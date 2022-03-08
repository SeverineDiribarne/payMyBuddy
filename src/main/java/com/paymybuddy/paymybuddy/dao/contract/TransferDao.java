package com.paymybuddy.paymybuddy.dao.contract;

import java.util.Date;
import java.util.List;

import com.paymybuddy.paymybuddy.model.Customer;
import com.paymybuddy.paymybuddy.model.Transfer;
import com.paymybuddy.paymybuddy.model.TransferType;

public interface TransferDao {

	List<Transfer> getTransfers(int owner);

	void addPaiement(int owner, Date date, int friend, String description, double amount);

}
