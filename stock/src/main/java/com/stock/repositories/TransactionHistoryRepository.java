package com.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entities.TransactionHistory;
@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Integer>{
	List<TransactionHistory> findByAccountUserID(int userID);

}
