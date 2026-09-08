package com.stock.Service;

import java.util.List;

import com.stock.entities.TransactionHistory;


public interface TransactionHistoryServiceLayer {
	List<TransactionHistory> getTransactionHistoryByUserId(int userID);

}
