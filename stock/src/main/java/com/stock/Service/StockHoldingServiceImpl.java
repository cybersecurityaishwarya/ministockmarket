package com.stock.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.entities.StockHolding;
import com.stock.repositories.StockHoldingRepository;
@Service
public class StockHoldingServiceImpl implements StockHoldingServiceLayer{
@Autowired
private StockHoldingRepository stockHoldingRepository;
@Override
public List <StockHolding> getStockHoldingsByUserId(int userID){
	return stockHoldingRepository.findByAccountUserID(userID);
}
}
