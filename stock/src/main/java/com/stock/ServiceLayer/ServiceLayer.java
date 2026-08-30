package com.stock.ServiceLayer;


import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.stock.DataTransferObject.StockResponse;
import com.stock.DataTransferObject.TrendingStock;

@Service
public class ServiceLayer {
	//
	private final RestClient restClient=RestClient.builder()
			.baseUrl("http://127.0.0.1:8000").build();
	public StockResponse fetchPythonStockData(String ticker){
		return this.restClient.get().uri("/api/stock/{ticker}",ticker)
				.retrieve().body(new ParameterizedTypeReference<StockResponse>() {});		
	}
	public List<TrendingStock> fetchTrendingStock(){
		return this.restClient.get().uri("/api/stock/trending").retrieve().body(new ParameterizedTypeReference<List<TrendingStock>>() {});
	}
}
