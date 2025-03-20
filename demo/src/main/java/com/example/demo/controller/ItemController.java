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

import com.example.demo.entity.ItemEntity;
import com.example.demo.repository.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final ItemRepository repository;

	public ItemController(ItemRepository repository) {
		this.repository = repository;
	}

	@GetMapping("")
	public List<ItemEntity> getAllItems() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ItemEntity getItem(@PathVariable Long id) {
		return repository.getReferenceById(id);
	}

	@PostMapping("")
	public void addItem(@Validated @RequestBody ItemEntity item) {
		repository.save(item);
	}

    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, @Validated @RequestBody ItemEntity item) {
		item.setId(id);
        repository.save(item);
    }

	@DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
