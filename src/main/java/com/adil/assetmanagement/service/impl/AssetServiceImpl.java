package com.adil.assetmanagement.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adil.assetmanagement.dao.AssetCategoryRepository;
import com.adil.assetmanagement.dao.AssetRepository;
import com.adil.assetmanagement.dao.model.AssignmentStatus;
import com.adil.assetmanagement.dao.model.Category;
import com.adil.assetmanagement.model.Asset;
import com.adil.assetmanagement.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	AssetRepository assetRepository;

	@Autowired
	AssetCategoryRepository assetCategoryRepository;
	
	@Override
	public void addAsset(Asset asset) {
		
		String categoryId = asset.getCategory().getId();
		Optional<Category> cat = assetCategoryRepository.findById(categoryId);
		if(!cat.isPresent()) {
			throw new RuntimeException("Invalid category, please create category first.");
		}
		
		com.adil.assetmanagement.dao.model.Asset assetDao = new com.adil.assetmanagement.dao.model.Asset();
		BeanUtils.copyProperties(asset, assetDao);
		assetDao.setCategoryId(asset.getCategory().getId());
		assetRepository.save(assetDao);
	}

	@Override
	public List<Asset> searchAsset(String name) {
		List<Asset> assets = new LinkedList<>();
		assetRepository.findAll().forEach(assetDao -> {
			if(name == null || name.equals(assetDao.getName())) {
				Asset asset = new Asset();
				BeanUtils.copyProperties(assetDao, asset);
				
				com.adil.assetmanagement.model.Category category = new com.adil.assetmanagement.model.Category();
	
				BeanUtils.copyProperties(assetCategoryRepository.findById(assetDao.getCategoryId()).get(), category);
				asset.setCategory(category);
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
		if(assetDao.getAssignmentStatus() != AssignmentStatus.Available) {
			throw new RuntimeException("Asset is not available for assetId: " + id);
		}
		assetDao.setEmployeeId(empId);
		assetDao.setAssignmentStatus(AssignmentStatus.Assigned);
		assetRepository.save(assetDao);
	}

	@Override
	public void recoverAsset(String id, String empId) {
		com.adil.assetmanagement.dao.model.Asset assetDao = assetRepository.findById(id).get();
		
		if(assetDao.getAssignmentStatus() != AssignmentStatus.Assigned && !assetDao.getEmployeeId().equals(empId)) {
			throw new RuntimeException("Given asset id is not assigned to given empId");
		}
		assetDao.setEmployeeId("");
		assetDao.setAssignmentStatus(AssignmentStatus.Recovered);
		assetRepository.save(assetDao);	
	}

	@Override
	public void deleteAsset(String id) {
		assetRepository.deleteById(id);
	}
	
}
