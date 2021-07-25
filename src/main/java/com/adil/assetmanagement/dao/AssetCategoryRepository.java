package com.adil.assetmanagement.dao;


import org.springframework.data.repository.CrudRepository;

import com.adil.assetmanagement.dao.model.Category;

public interface AssetCategoryRepository extends CrudRepository<Category, String> {

}