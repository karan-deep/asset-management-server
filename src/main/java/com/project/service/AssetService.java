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

    // Method to add the asset
    public void addAsset(Asset asset) {
        assetRepository.save(asset);
    }

    // Method to update the asset
    public void updateAsset(int id,Asset asset) {
        if(!assetRepository.findById(id).isPresent()){
            throw new NotFoundException("Asset not found");
        }
        assetRepository.save(asset);
    }

    // Method to delete the asset by their id
    public void deleteAsset(int id) {
        if(!assetRepository.findById(id).isPresent()){
            throw new NotFoundException("Asset not found");
        }
        assetRepository.deleteById(id);
    }

}
