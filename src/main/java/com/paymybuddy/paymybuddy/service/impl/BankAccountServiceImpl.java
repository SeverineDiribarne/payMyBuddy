package com.paymybuddy.paymybuddy.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.paymybuddy.dao.contract.BankAccountDao;
import com.paymybuddy.paymybuddy.dao.impl.BankAccountDaoImpl;
import com.paymybuddy.paymybuddy.model.BankAccount;
import com.paymybuddy.paymybuddy.service.contract.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountDao bankAccountDao = new BankAccountDaoImpl();
	
	@Override
	public int getBankAccountId(int customerId) {
		return bankAccountDao.getBankAccountId(customerId);
	}
	@Override
	public List<BankAccount> getAllElementsOfBankAccount(int customerId) {
		return bankAccountDao.getAllElementsOfBankAccount(customerId);
	}
}