package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
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
	return null;//accountService.endLogin(incoming);
}

@GetMapping("accounts/{account_id}/messages")
public ResponseEntity<Account> endAccounts(@RequestBody Account incoming){
	return null;
}

@PostMapping("messages")
public ResponseEntity<Account> endMessagesPOST(@RequestBody Account incoming){
	return null;
}

@GetMapping("messages")
public ResponseEntity<Account> endMessagesGET_ALL(@RequestBody Account incoming){
	return null;
}

@GetMapping("messages/{message_id}")
public ResponseEntity<Account> endMessageGET_BY_ID(@RequestBody Account incoming){
	return null;
}

@DeleteMapping("messages/{message_id}")
public ResponseEntity<Account> endMessageDELETE_BY_ID(@RequestBody Account incoming){
	return null;
}

@PatchMapping("messages/{message_id}")
public ResponseEntity<Account> endMessagePATCH_BY_ID(@RequestBody Account incoming){
	return null;
}

}//end class
