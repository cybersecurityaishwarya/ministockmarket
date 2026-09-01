package com.stock.Service;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stock.dtos.LoginDto;
import com.stock.entities.Account;
import com.stock.repositories.AccountRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class AccountServiceLayer {
	private final AccountRepository accountRepository;

public String Login(LoginDto loginDto) {
	Optional<Account> existingAccount = accountRepository.findByUsername(loginDto.getUsername());
	
	
		if(existingAccount.isPresent()) {
			Account account=existingAccount.get();
			if(account.getPassword().equals(loginDto.getPassword())) {
			return "Welcome back!";
			}
			else {
				return "Incorrect username or password";
			}
		}
		
		return "Incorrect username or password";
	
}
public Account findByUsername(String username) {
	return accountRepository.findByUsername(username).orElse(null);
}
public Account addUser(Account account) {
	return accountRepository.save(account);
}
}
