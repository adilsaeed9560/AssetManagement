package com.adil.assetmanagement.service;

import java.util.List;

import com.adil.assetmanagement.model.Category;

public interface AssetCategoryService {

	
	public void addCategory(Category category);

	public List<Category> getCategory();

	public void updateCategory( String id, Category category);
	
}
