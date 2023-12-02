package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

@Autowired AccountService accountService;
@Autowired MessageService messageService;

@PostMapping("register")
public ResponseEntity<Account> endRegister(@RequestBody Account incoming){
	return accountService.endRegister(incoming);
}

@PostMapping("login")
public ResponseEntity<Account> endLogin(@RequestBody Account incoming){
	return accountService.endLogin(incoming);
}

@GetMapping("accounts/{account_id}/messages")
public ResponseEntity<List<Message>> endMessagesGivenAccountId(
	@PathVariable(name="account_id",required=true) Integer account_id)
{
	return accountService.endMessagesGivenAccountId(account_id);
}

@PostMapping("messages")
public ResponseEntity<Message> endMessagesPOST(@RequestBody(required=true) Message incoming){
	return messageService.endMessagesPOST(incoming);
}

@GetMapping("messages")
public ResponseEntity<List<Message>> endMessagesGET_ALL(){
	return messageService.endMessagesGET_ALL();
}

@GetMapping("messages/{message_id}")
public ResponseEntity<Message> endMessageGET_BY_ID(
	@PathVariable(name="message_id",required=true) Integer message_id)
{
	return messageService.endMessageGET_BY_ID(message_id);
}

@DeleteMapping("messages/{message_id}")
public ResponseEntity<Integer> endMessageDELETE_BY_ID(
	@PathVariable(name="message_id",required=true) Integer message_id)
{
	return messageService.endMessageDELETE_BY_ID(message_id);
}

@PatchMapping("messages/{message_id}")
public ResponseEntity<Integer> endMessagePATCH_BY_ID(
	@PathVariable(name="message_id",required=true) Integer message_id,
	@RequestBody(required=true) Message incoming)
{
	return messageService.endMessagePATCH_BY_ID(message_id,incoming);
}

}//end class
