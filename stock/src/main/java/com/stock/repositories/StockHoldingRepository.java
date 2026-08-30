package com.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entities.StockHolding;
@Repository
public interface StockHoldingRepository extends JpaRepository<StockHolding,Integer>{
	List<StockHolding> findByAccountUserID(int userID);
}
