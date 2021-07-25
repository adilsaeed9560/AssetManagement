package com.adil.assetmanagement.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adil.assetmanagement.dao.AssetCategoryRepository;
import com.adil.assetmanagement.model.Asset;
import com.adil.assetmanagement.model.Category;
import com.adil.assetmanagement.service.AssetCategoryService;

@Service
public class AssetCategoryServiceImpl implements AssetCategoryService {

	@Autowired
	AssetCategoryRepository assetCategoryRepository;
	
	@Override
	public void addCategory(Category category) {
		com.adil.assetmanagement.dao.model.Category categoryDao = new com.adil.assetmanagement.dao.model.Category();
		BeanUtils.copyProperties(category, categoryDao);
	
		assetCategoryRepository.save(categoryDao);
	}

	@Override
	public List<Category> getCategory() {
		List<Category> categories = new LinkedList<>();
		assetCategoryRepository.findAll().forEach(categoryDao -> {
			Category category = new Category();
			BeanUtils.copyProperties(categoryDao, category);
			categories.add(category);
			
		});
		
		return categories;
	}

	@Override
	public void updateCategory(String id, Category category) {
		com.adil.assetmanagement.dao.model.Category categoryDao = assetCategoryRepository.findById(id).get();
		BeanUtils.copyProperties(category, categoryDao);
		assetCategoryRepository.save(categoryDao);
		
	}

}
