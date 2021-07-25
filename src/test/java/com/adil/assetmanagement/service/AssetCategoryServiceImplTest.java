package com.adil.assetmanagement.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.adil.assetmanagement.model.Category;
import com.adil.assetmanagement.service.impl.AssetCategoryServiceImpl;

public class AssetCategoryServiceImplTest {
	
	AssetCategoryServiceImpl assetCategoryServiceImpl;

	@SuppressWarnings("deprecation")
	@Test
	void happyTest() {
		
		//create test data
		Category cat = new Category();
		cat.setDescription("MyDesc");
		cat.setId("124");
		cat.setName("myname");
		
		//execute test
		assetCategoryServiceImpl.addCategory(cat);
		
		//validation
		List<Category> cats = assetCategoryServiceImpl.getCategory();
		Assert.isTrue(cats.size() == 1);
		
	}
}
