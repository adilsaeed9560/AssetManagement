package com.adil.assetmanagement.service;


import java.util.List;

import com.adil.assetmanagement.model.Asset;

public interface AssetService {
	public void addAsset(Asset asset);

	public List<Asset> getAsset();

	public List<Asset> searchAsset(String name);

	public void updateAsset(String id, Asset asset);
	
	public void assignAsset(String id, String empId);
	
	public void recoverAsset(String id, String empId);
	
	public void deleteAsset(String id);
}
