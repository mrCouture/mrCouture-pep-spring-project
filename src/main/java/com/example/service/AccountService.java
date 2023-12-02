package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class AccountService {

@Autowired AccountRepository accountDAO;
@Autowired MessageRepository messageDAO;

public ResponseEntity<Account> endRegister(Account incoming)
{
	if(incoming.getUsername()==null)		return ResponseEntity.status(400).build();
	if(incoming.getUsername().isBlank())	return ResponseEntity.status(400).build();
	if(incoming.getPassword()==null)		return ResponseEntity.status(400).build();
	if(incoming.getPassword().length()<4)	return ResponseEntity.status(400).build();

	//Check if an account with this username already exists
	Account existingAccount=accountDAO.findAccountByUsername(incoming.getUsername());
	if(existingAccount!=null && existingAccount.getAccount_id()>=0) return ResponseEntity.status(409).build();

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

public ResponseEntity<Account> endLogin(Account incoming)
{
	Account existingAccount=accountDAO.findAccountByUsernameAndPassword(incoming.getUsername(),incoming.getPassword());

	if(existingAccount==null)
	return ResponseEntity.status(401).build();

	return ResponseEntity.ok(existingAccount);
}

public ResponseEntity<List<Message>> endMessagesGivenAccountId(Integer searchAccountId)
{
	// if(searchAccountId==null)
	// {ctx.status(400);return;}
	// if(searchAccountId<0)
	// {ctx.status(400);return;}
	// int searchAccountId=Integer.parseInt(ctx.pathParam("account_id"));

	//select messages posted by this account_id
	return ResponseEntity.ok(messageDAO.findAllMessageByPostedBy(searchAccountId));
}

}//end class
