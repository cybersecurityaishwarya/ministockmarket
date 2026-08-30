package com.stock.StockController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stock.DataTransferObject.StockResponse;
import com.stock.DataTransferObject.TrendingStock;
import com.stock.ServiceLayer.ServiceLayer;

@RestController
public class StockController {
private final ServiceLayer serviceLayer;
public StockController(ServiceLayer serviceLayer){
	this.serviceLayer=serviceLayer;
}

@GetMapping("/springboot/stock/{ticker}")
public StockResponse getStock(@PathVariable String ticker){
	return serviceLayer.fetchPythonStockData(ticker);
}
@GetMapping("/springboot/stock/trending")
public List<TrendingStock> getTrend() {
	return serviceLayer.fetchTrendingStock();
}
}
