package com.swetank.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.swetank.entities.Category;
import com.swetank.exception.ResourceNotFoundException;
import com.swetank.payloads.CategoryDto;
import com.swetank.repositories.CategoryRepo;
import com.swetank.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category = this.modelMapper.map(categoryDto, Category.class);
		
		Category createCategory = this.categoryRepo.save(category);
		
		return this.modelMapper.map(createCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId)
				                             .orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updateCategory = this.categoryRepo.save(category);
		
		return this.modelMapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
		this.categoryRepo.delete(category);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}
	
	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category> categories = this.categoryRepo.findAll();
		
		List<CategoryDto> categoryDtos = categories.stream()
				                                   .map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				                                   .collect(Collectors.toList());
		return categoryDtos;
	}

	

}
