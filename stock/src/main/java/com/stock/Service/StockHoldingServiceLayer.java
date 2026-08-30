package com.stock.Service;

import java.util.List;

import com.stock.entities.StockHolding;

public interface StockHoldingServiceLayer {
	List<StockHolding> getStockHoldingsByUserId(int userID);
}
