package com.project.service;

import com.project.exception.NotFoundException;
import com.project.model.Asset;
import com.project.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//marking AssetService class as an Service
@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    // Method to get list of all assets
    public List<Asset> getAllAssets() {
        return (List<Asset>) assetRepository.findAll();
    }

    // Method to get one asset finding by their 'id' else throwing exception if does not exist
    public Asset getAssetById(int id) {
        return assetRepository.findById(id).orElseThrow(() -> new NotFoundException("Asset not found"));
    }

    // Method to save the asset
    public void addOrUpdateAsset(Asset asset) {
        assetRepository.save(asset);
    }

    // Method to delete the asset by their id
    public void deleteAsset(int id) {
        assetRepository.deleteById(id);
    }

}
