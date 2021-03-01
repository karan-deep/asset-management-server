package com.project.component;

import com.project.repository.AssetRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// marking AssetComponent as a component to add it into the application context by component-scanning mechanism and implementing CommandLineRunner that will automatically call the run method
@Component
public class AssetComponent implements CommandLineRunner {

    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception {
    }

}

