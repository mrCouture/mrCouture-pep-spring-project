package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>
{
    Account findAccountByUsername(String username);

	Account findAccountByUsernameAndPassword(String username,String password);

	//Can't rename all the variables to camelCase because 
	//tests would need to change and I can't change those
	@Query("from Account where account_id=?1")
	Account findAccountByAccountId(Integer accountId);

	//Error: No property accountId found for type Account! Did you mean 'account_id'?
	//Account findAccountByAccountId(Integer account_id);

	//Error: No property accountId found for type Account! Did you mean 'account_id'?
	//Account findAccountByAccountId(Integer accountId);

	//Error: No property account found for type Account!
	//Account findAccountByAccount_id(Integer accountId);
}
