package com.stock.UserLogin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stock.Service.TransactionHistoryServiceLayer;

@Controller
public class TransactionHistoryController {
@Autowired
private TransactionHistoryServiceLayer transactionHistoryService;

@GetMapping("/transactionhistory/{userID}")
public String viewTransactionPage(@PathVariable int userID, Model model) {
model.addAttribute("listTransactionHistory",transactionHistoryService.getTransactionHistoryByUserId(userID));
return "transaction";
}
}
