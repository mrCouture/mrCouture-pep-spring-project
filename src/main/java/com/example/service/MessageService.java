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
public class MessageService {

@Autowired AccountRepository accountDAO;
@Autowired MessageRepository messageDAO;

public ResponseEntity<Message> endMessagesPOST(Message incoming)
{
	// if(incoming==null) //<--Spring is checking this
	// return ResponseEntity.status(400).build();
	if(incoming.getMessage_text()==null
	|| incoming.getMessage_text().isBlank()
	|| incoming.getMessage_text().length()>=255)
	return ResponseEntity.status(400).build();

	//Check that posted_by matches an existing user
	Account existingAccount=accountDAO.findAccountByAccountId(incoming.getPosted_by());

	if(existingAccount==null)
	return ResponseEntity.status(400).build();//no rows given posted_by account_id

	Message newMessage=messageDAO.save(incoming);

	//incoming.setMessage_id(newMessage.getMessage_id());
	return ResponseEntity.ok(newMessage);
}


public ResponseEntity<List<Message>> endMessagesGET_ALL()
{
	return ResponseEntity.ok(messageDAO.findAll());
}

}//end class
