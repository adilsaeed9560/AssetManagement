package com.adil.assetmanagement.dao;
import org.springframework.data.repository.CrudRepository;

import com.adil.assetmanagement.dao.model.Asset;

/**
 * this will expose  crud operation for assets in the organisation.
 * @author AdiL
 *
 */
public interface AssetRepository extends CrudRepository<Asset, String> {
	
}
