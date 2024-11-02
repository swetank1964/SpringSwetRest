package com.swetank.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
    private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String about;  
}
