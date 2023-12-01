package com.example.service;

import javax.naming.Context;

@Service
public class AccountService {

public ResponseEntity<Account> endRegister(Account incoming) throws Exception
{
	if(incoming.getUsername()==null)		return new ResponseEntity<>(400);
	if(incoming.getUsername().isBlank())	return new ResponseEntity<>(400);
	if(incoming.getPassword()==null)		return new ResponseEntity<>(400);
	if(incoming.getPassword().length()<4)	return new ResponseEntity<>(400);

	//Check if an account with this username already exists
	int existingAccountId=accountDAO.selectAccountIdByUsername(incoming.getUsername());
	if(existingAccountId>=0) return new ResponseEntity<>(400);

	//create new account
	int newAccountId=accountDAO.insertNew(incoming.getUsername(),incoming.getPassword());
	if(newAccountId<0)
	{
		System.err.println("newAccountId less than 0");
		return new ResponseEntity<>(400);
	}

	//re-using existing Account object, could also re-select it back out of the db
	incoming.setAccount_id(newAccountId);
	return new ResponseEntity<>(incoming);
}

}//end class
