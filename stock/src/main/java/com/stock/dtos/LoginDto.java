package com.stock.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDto {
	@NotEmpty
	private String username;
	
	
	@Size(min=4,max=32, message= "Password must be between 4 and 32 characters.")
	private String password;	
	

}
