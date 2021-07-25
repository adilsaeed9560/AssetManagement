package com.adil.assetmanagement.service;

import java.util.List;

import com.adil.assetmanagement.model.Category;

/**
 * This service will take of asset category life-cycle.
 * @author AdiL
 *
 */
public interface AssetCategoryService {

	

	/**
	 * this function will add category to the system.
	 * @param category
	 */
	public void addCategory(Category category);

	/**
	 * this function will return all category from the system.
	 * @param category
	 */
	public List<Category> getCategory();

	/**
	 * this function will update category to the system.
	 * @param category
	 */
	public void updateCategory( String id, Category category);
	
}
