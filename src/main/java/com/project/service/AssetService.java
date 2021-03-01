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

    public List<Asset> getAllAssets() {
        return (List<Asset>) assetRepository.findAll();
    }

    public Asset getAssetById(int id) {
        return assetRepository.findById(id).orElseThrow(() -> new NotFoundException("Asset not found"));
    }

    public void addOrUpdateAsset(Asset asset) {
        assetRepository.save(asset);
    }

    public void deleteAsset(int id) {
        assetRepository.deleteById(id);
    }

}
