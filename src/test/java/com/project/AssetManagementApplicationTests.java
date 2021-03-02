package com.project;

import com.project.model.Asset;
import com.project.service.AssetService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(AssetService.class)
class AssetManagementApplicationTests {

    @Autowired
    AssetService assetService;

    @Test
    public void test_to_get_all_assets()  {
        assetService.addAsset(new Asset(1, "Desktop", "The desktop is the primary user interface of a computer.", 78, new GregorianCalendar(2021, 01, 10)));
        assetService.addAsset(new Asset(2, "Operating System", "An operating system is the core set of software on a device that keeps everything together.", 98, new GregorianCalendar(2018, 9, 9)));
        assetService.addAsset(new Asset(1, "Scanner", " A scanner is an input device that scans documents such as photographs and pages of text.", 50, new GregorianCalendar(2020, 05, 20)));
        assertThat(assetService.getAllAssets()).hasSize(3);
        assertThat(assetService.getAllAssets()).isInstanceOf(ArrayList.class);
        assertThat(assetService.getAllAssets()).extracting("price").isEqualTo(new ArrayList<Double>() {
            {
                add(78.0);
                add(98.0);
                add(50.0);
            }
        });
    }

    @Test
    public void test_to_get_one_asset() {
        assetService.addAsset(new Asset(1, "Barcode Reader", "A barcode is a method of representing data in a visual, machine,readable form and barcode reader understands that code.", 30, new GregorianCalendar(2020, 04, 07)));
        assertThat(assetService.getAssetById(4).getName()).isEqualTo("Barcode Reader");
    }

    @Test
    public void test_to_add_one_asset() {
        assetService.addAsset(new Asset(1, "Hard Drive", "A hard drive is the hardware component that stores all of your digital content.", 10, new GregorianCalendar(2020, 10, 10)));
        assertThat(assetService.getAssetById(5).getName()).isEqualTo("Hard Drive");
        assertThat(assetService.getAssetById(5).getPrice()).isEqualTo(10);
    }

    @Test
    public void test_to_delete_one_asset() {
        assetService.addAsset(new Asset(1, "Hard Drive", "A hard drive is the hardware component that stores all of your digital content.", 10, new GregorianCalendar(2020, 10, 10)));
        assetService.deleteAsset(6);
        assertThat(assetService.getAllAssets()).hasSize(0);
    }

    @Test
    public void test_to_update_one_asset() {
        assetService.addAsset(new Asset(1, "Hard Drive", "A hard drive is the hardware component that stores all of your digital content.", 10, new GregorianCalendar(2020, 10, 10)));
        assetService.getAssetById(7).setName("Operating System");
        assetService.updateAsset(assetService.getAssetById(7).getId(),assetService.getAssetById(7));
        assertThat(assetService.getAssetById(7).getName()).isEqualTo("Operating System");
    }



}
