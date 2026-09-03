package com.stock.UserLogin.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.Service.AccountServiceLayer;
import com.stock.dtos.RegisterDto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/register")
public class RegisterController {
	private final AccountServiceLayer accountServiceLayer;
	@GetMapping
	public String register(Model model) {
		model.addAttribute("registerDto",new RegisterDto());
		return "register"; //returns to the html
	}
	@PostMapping
	//the valid makes it so it checks my DTO criterias... before accepting it
	public String register(@Valid @ModelAttribute RegisterDto registerDto, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "register";
		}
		try {
			accountServiceLayer.addUser(registerDto);
			return "redirect:/register";
		}
		catch(IllegalArgumentException a){
			model.addAttribute("message",a.getMessage());
			return "register";
			
		}
	}
}
