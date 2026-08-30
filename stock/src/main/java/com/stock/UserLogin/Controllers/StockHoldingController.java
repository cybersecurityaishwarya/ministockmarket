package com.stock.UserLogin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stock.Service.StockHoldingServiceLayer;

@Controller
public class StockHoldingController {
	@Autowired
	private StockHoldingServiceLayer stockHoldingService;
@GetMapping("/holdings/{userID}")
public String viewHoldingPage(@PathVariable int userID, Model model) {
	model.addAttribute("listStockHoldings", stockHoldingService.getStockHoldingsByUserId(userID));
	return "stockholding";
}
}
