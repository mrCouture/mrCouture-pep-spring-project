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

public ResponseEntity<Message> endMessageGET_BY_ID(Integer searchMessageId)
{
	//Spring checks these now
	// if(ctx.pathParam("message_id")==null)
	// {ctx.status(400);return;}
	// if(ctx.pathParam("message_id").isBlank())
	// {ctx.status(400);return;}
	// int searchMessageId=Integer.parseInt(ctx.pathParam("message_id"));

	Message messageFound=messageDAO
	.findById(searchMessageId)
	.orElse(null);//no messages found. Business logic is to respond with 200 empty body
	// if(messageFound==null)
	// {ctx.json("");return;}//no messages found

	return ResponseEntity.ok(messageFound);
}

public ResponseEntity<Integer> endMessageDELETE_BY_ID(Integer searchMessageId)
{
	// if(ctx.pathParam("message_id")==null)
	// {ctx.status(400);return;}
	// if(ctx.pathParam("message_id").isBlank())
	// {ctx.status(400);return;}
	// int searchMessageId=Integer.parseInt(ctx.pathParam("message_id"));

	Message messageToDelete=messageDAO.findById(searchMessageId).orElse(null);
	// if(messageToDelete==null)
	// {ctx.json("");return;}

	if(messageToDelete==null) 
		return ResponseEntity.ok(null);//0 rows deleted. Respond with empty body

	messageDAO.delete(messageToDelete);
	return ResponseEntity.ok(1);//1 row deleted

	// if(messageDAO.deleteAllByMessageId(searchMessageId)==0)
	// {ctx.status(500);return;}//could not delete for some reason
}

public ResponseEntity<Integer> endMessagePATCH_BY_ID(Integer searchMessageId,Message incoming)
{
	// if(ctx.pathParam("message_id")==null)
	// {ctx.status(400);return;}
	// if(ctx.pathParam("message_id").isBlank())
	// {ctx.status(400);return;}
	// int searchMessageId=Integer.parseInt(ctx.pathParam("message_id"));

	// Message incoming=ctx.bodyAsClass(Message.class);
	// if(incoming==null)
	// {ctx.status(400);return;}
	// if(incoming.getMessage_text()==null)
	// {ctx.status(400);return;}
	if(incoming.getMessage_text().isBlank())
		return ResponseEntity.status(400).build();
	if(incoming.getMessage_text().length()>=255)
		return ResponseEntity.status(400).build();

	Message messageToUpdate=messageDAO.findById(searchMessageId).orElse(null);
	if(messageToUpdate==null)
		return ResponseEntity.status(400).build();//couldn't find it

	messageToUpdate.setMessage_text(incoming.getMessage_text());
	messageDAO.save(messageToUpdate);

	return ResponseEntity.ok(1);//one row was updated
}

}//end class
