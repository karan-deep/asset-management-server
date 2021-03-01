package com.project.component;

import com.project.model.Asset;
import com.project.model.User;
import com.project.repository.AssetRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;

// marking AssetComponent as a component to add it into the application context by component-scanning mechanism and implementing CommandLineRunner that will automatically call the run method
@Component
public class AssetComponent implements CommandLineRunner {

    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String...args) throws Exception {
        assetRepository.save(new Asset(1, "Hard Drive", "A hard drive is the hardware component that stores all of your digital content.", 10, new GregorianCalendar(2020, 10, 10) {
        }));
        assetRepository.save(new Asset(1,"Desktop","The desktop is the primary user interface of a computer.",78,new GregorianCalendar(2021,01,10)));
        assetRepository.save(new Asset(2,"Operating System","An operating system is the core set of software on a device that keeps everything together.",98,new GregorianCalendar(2018,9,9)));
        assetRepository.save(new Asset(1,"Scanner"," A scanner is an input device that scans documents such as photographs and pages of text.",50,new GregorianCalendar(2020,05,20)));
        assetRepository.save(new Asset(1,"Barcode Reader","A barcode is a method of representing data in a visual, machine,readable form and barcode reader understands that code.",30,new GregorianCalendar(2020,04,07)));

        userRepository.save(new User("test@gmail.com","$2a$04$h7OCM7XJEQwV/xefuqnV0uhhZXl7IWi.vfAMkyStjL6T.QFeqonfy"));
    }

}

