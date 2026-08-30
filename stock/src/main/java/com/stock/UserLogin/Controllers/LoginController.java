package com.stock.UserLogin.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.Service.AccountServiceLayer;
import com.stock.dtos.LoginDto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Controller
@RequestMapping("/login")

public class LoginController {
	private final AccountServiceLayer accountServiceLayer;
	@GetMapping
	public String login(Model model) {
		model.addAttribute(new LoginDto());
		return "login";
	}
	
	@PostMapping
	public String login(@Valid @ModelAttribute LoginDto loginDto, Model model) {
		String loginOutput=accountServiceLayer.Login(loginDto);
		model.addAttribute("message",loginOutput);
		if(loginOutput.equals("Welcome back!")) {
			return "redirect:/holdings" ;
		}
		return "login";
	}
	}


