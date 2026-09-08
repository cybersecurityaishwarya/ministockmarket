package com.stock.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.entities.TransactionHistory;
import com.stock.repositories.TransactionHistoryRepository;

@Service
public class TransactionHistoryServiceLayerImpl implements TransactionHistoryServiceLayer{
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	@Override
	public List<TransactionHistory> getTransactionHistoryByUserId(int userID){
		return transactionHistoryRepository.findByAccountUserID(userID);
	}

}
