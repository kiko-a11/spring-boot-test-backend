package com.example.demo.controller;

import java.util.List;

import org. springframework.validation. annotation. Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org. springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org. springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryRepository repository;

	public CategoryController(CategoryRepository repository) {
		this.repository = repository;
	}

	@GetMapping("")
	public List<CategoryEntity> getAllCategorys() {
		return repository.findAll();
	}

	@GetMapping("/{categoryId}")
	public CategoryEntity getCategory(@PathVariable Long categoryId) {
		return repository.getReferenceById(categoryId);
	}

	@PostMapping("")
	public void addCategory(@Validated @RequestBody CategoryEntity category) {
		repository.save(category);
	}

    @PutMapping("/{categoryId}")
    public void updateCategory(@PathVariable Long categoryId, @Validated @RequestBody CategoryEntity category) {
		category.setCategoryId(categoryId);
        repository.save(category);
    }

	@DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
