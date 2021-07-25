package com.adil.assetmanagement.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adil.assetmanagement.dao.AssetRepository;
import com.adil.assetmanagement.model.Asset;
import com.adil.assetmanagement.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	AssetRepository assetRepository;

	@Override
	public void addAsset(Asset asset) {
		com.adil.assetmanagement.dao.model.Asset assetDao = new com.adil.assetmanagement.dao.model.Asset();
		BeanUtils.copyProperties(asset, assetDao);
		assetRepository.save(assetDao);
	}

	@Override
	public List<Asset> getAsset() {
		List<Asset> assets = new LinkedList<>();
		assetRepository.findAll().forEach(assetDao -> {
			Asset asset = new Asset();
			BeanUtils.copyProperties(assetDao, asset);
			assets.add(asset);
			
		});
		
		return assets;
	}

	@Override
	public List<Asset> searchAsset(String name) {
		List<Asset> assets = new LinkedList<>();
		assetRepository.findAll().forEach(assetDao -> {
			if(name.equals(assetDao.getName())) {
				Asset asset = new Asset();
				BeanUtils.copyProperties(assetDao, asset);
				assets.add(asset);
			}
			
		});
		
		return assets;
	}

	@Override
	public void updateAsset(String id, Asset asset) {
		com.adil.assetmanagement.dao.model.Asset assetDao = assetRepository.findById(id).get();
		BeanUtils.copyProperties(asset, assetDao);
		assetRepository.save(assetDao);
	}

	@Override
	public void assignAsset(String id, String empId) {
		com.adil.assetmanagement.dao.model.Asset assetDao = assetRepository.findById(id).get();
		assetDao.setEmployeeId(empId);
		assetRepository.save(assetDao);
	}

	@Override
	public void recoverAsset(String id, String empId) {
		com.adil.assetmanagement.dao.model.Asset assetDao = assetRepository.findById(id).get();
		assetDao.setEmployeeId("");
		assetRepository.save(assetDao);
		
	}

	@Override
	public void deleteAsset(String id) {
		assetRepository.deleteById(id);
	}
	
}
