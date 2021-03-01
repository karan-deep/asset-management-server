package com.project.controller;

import com.project.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Enabling cross-origin resource sharing
@CrossOrigin
// marking class AssetController as RestController for creating Restful controllers, it also adds the @Controller and @ResponseBody annotations
@RestController
public class AssetController {

    @Autowired
    private AssetService assetService;
}
