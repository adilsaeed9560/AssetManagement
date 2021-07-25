package com.adil.assetmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adil.assetmanagement.model.Asset;
import com.adil.assetmanagement.service.AssetService;

@RestController
@RequestMapping("/v1/assets")
public class AssetController {
	

	@Autowired
	AssetService assetService;

	@PostMapping
	public void addAsset(@RequestBody Asset asset) {
		assetService.addAsset(asset);
	}

	@GetMapping
	public List<Asset> getAsset(@RequestParam(required = false)String name) {	
		return assetService.searchAsset(name);
	}


	@PutMapping("/{id}")
	public void updateAsset(@PathVariable String id, @RequestBody Asset asset) {
		assetService.updateAsset(id, asset);
	}
	
	@PutMapping("/{id}/assign")
	public void assignAsset(@PathVariable String id, @RequestBody String empId) {
		assetService.assignAsset(id, empId);
	}
	@PutMapping("/{id}/recover")
	public void recoverAsset(@PathVariable String id, @RequestBody String empId) {
		assetService.recoverAsset(id, empId);
	}
	@DeleteMapping("/{id}")
	public void deleteAsset(@PathVariable String id) {
		assetService.deleteAsset(id);
	}
}
