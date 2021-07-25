package com.adil.assetmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adil.assetmanagement.model.Category;
import com.adil.assetmanagement.service.AssetCategoryService;


@RestController
@RequestMapping("/v1/assets/category")
public class AssetCategoryController {

	@Autowired
	AssetCategoryService assetCategoryService;
	
	@PostMapping
	public void addCategory(@RequestBody Category category) {
		assetCategoryService.addCategory(category);
	}


	@GetMapping
	public List<Category> getCategory() {
		return assetCategoryService.getCategory();
	}

	@PutMapping("/{id}")
	public void updateCategory(@PathVariable String id, @RequestBody Category category) {
		assetCategoryService.updateCategory(id, category);
	}
	
}
