package com.adil.assetmanagement.dao;
import org.springframework.data.repository.CrudRepository;

import com.adil.assetmanagement.dao.model.Asset;

public interface AssetRepository extends CrudRepository<Asset, String> {
	
}
