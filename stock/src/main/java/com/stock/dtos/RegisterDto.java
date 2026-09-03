package com.stock.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterDto {

	@NotBlank(message="Please enter username.")
	private String username;
	
	@NotBlank(message="Please enter password.")
	private String password;
}
