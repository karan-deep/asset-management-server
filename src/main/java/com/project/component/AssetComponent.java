package com.project.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// marking AssetComponent as a component to add it into the application context by component-scanning mechanism and implementing CommandLineRunner that will automatically call the run method
@Component
public class AssetComponent implements CommandLineRunner {

    public void run(String...args) throws Exception {
    }

}
