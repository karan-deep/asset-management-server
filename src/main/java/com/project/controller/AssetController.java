package com.project.controller;

import com.project.model.Asset;
import com.project.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Enabling cross-origin resource sharing
@CrossOrigin
// marking class AssetController as RestController for creating Restful controllers, it also adds the @Controller and @ResponseBody annotations
@RestController
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping("/api/assets")
    private List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @GetMapping("/api/assets/{id}")
    private Asset getAssetById(@PathVariable("id") int id) {
        return assetService.getAssetById(id);
    }
}
