package com.stock.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDto {
	@NotEmpty
	private String username;
	
	
	@Size(min=0, message= "Password must be greater than 0 characters.")
	private String password;	
	

}
