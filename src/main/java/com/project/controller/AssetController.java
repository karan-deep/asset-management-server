package com.project.controller;

import com.project.model.Asset;
import com.project.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Enabling cross-origin resource sharing
@CrossOrigin
// marking class AssetController as RestController for creating Restful controllers, it also adds the @Controller and @ResponseBody annotations
@RestController
public class AssetController {

    @Autowired
    private AssetService assetService;

    // GET endpoint - to get all assets
    @GetMapping("/api/assets")
    private List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    // GET endpoint - to get one asset details
    @GetMapping("/api/assets/{id}")
    private Asset getAssetById(@PathVariable("id") int id) {
        return assetService.getAssetById(id);
    }

    // PUT endpoint - to update one asset details
    @PutMapping("/api/assets/{id}")
    private ResponseEntity getAssetById(@PathVariable("id") int id,@RequestBody Asset asset) {
        assetService.addOrUpdateAsset(asset);
        return new ResponseEntity(HttpStatus.OK);
    }

    // DELETE endpoint - to delete one asset
    @DeleteMapping("/api/assets/{id}")
    private void deleteAsset(@PathVariable("id") int id) {
        assetService.deleteAsset(id);
    }

    // POST endpoint - to add one asset
    @PostMapping("/api/assets")
    private ResponseEntity addAsset(@RequestBody Asset asset) {
        assetService.addOrUpdateAsset(asset);
        return new ResponseEntity(HttpStatus.OK);
    }
}
