package com.stock.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.entities.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {
	Optional<Account> findByUsername(String username);
	}
