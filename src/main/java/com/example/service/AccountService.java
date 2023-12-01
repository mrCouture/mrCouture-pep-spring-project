package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {

@Autowired AccountRepository accountDAO;

public ResponseEntity<Account> endRegister(Account incoming) throws Exception
{
	if(incoming.getUsername()==null)		return ResponseEntity.status(400).build();
	if(incoming.getUsername().isBlank())	return ResponseEntity.status(400).build();
	if(incoming.getPassword()==null)		return ResponseEntity.status(400).build();
	if(incoming.getPassword().length()<4)	return ResponseEntity.status(400).build();

	//Check if an account with this username already exists
	int existingAccountId=accountDAO.findAccountIdByUsername(incoming.getUsername());
	if(existingAccountId>=0) return ResponseEntity.status(400).build();

	//create new account
	Account newAccount=accountDAO.save(new Account(incoming.getUsername(),incoming.getPassword()));
	if(newAccount.getAccount_id()<0)
	{
		System.err.println("newAccount.getAccount_id() less than 0");
		return ResponseEntity.status(400).build();
	}

	//incoming.setAccount_id(newAccountId);
	return ResponseEntity.ok(newAccount);
}

}//end class
