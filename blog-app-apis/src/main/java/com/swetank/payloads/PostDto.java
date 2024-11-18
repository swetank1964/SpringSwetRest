package com.swetank.payloads;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	
	private Integer postId;

	@NotEmpty
	@Size(min=4,message="Title must be min of 4 characters")
	private String title;
	
	@NotEmpty
	@Size(min=10,max=1000,message="Content must be between 10 and 1000 characters")
	private String content;
	
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
}
