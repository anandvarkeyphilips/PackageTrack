package com.jits.shipping.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Anand Philips on 5/31/2018.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PackageHandlerServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Autowired
    public PackageHandlerService packageHandlerService;

    @Test
    public void addNewPackageTestSuccessful() throws Exception {
        packageHandlerService.addNewPackage("012345678901234567|GRD|12345|67890|12345|67890|12345|67890|OTHER|HAZARD");
    }

    @Test
    public void generateReport() throws Exception {
        packageHandlerService.addNewPackage("021344839439700689|GRD|12345|67890|12345|67890|12345|67890|OTHER|HAZARD");
        packageHandlerService.addNewPackage("001234567890123458|GRD|12345|67890|12345|67890|12345|67890|OTHER|HAZARD");
        packageHandlerService.addNewPackage("213654889765021231|AIR|12345|67890|12345|67890|12345|67890|OTHER|HAZARD");
        packageHandlerService.addNewPackage("001234567890123456|AIR|12345|67890|12345|67890|12345|67890|OTHER|HAZARD");
        packageHandlerService.addNewPackage("001234567890123456|RAL|12345|67890|12345|67890|12345|67890|OTHER|HAZARD");
        packageHandlerService.addNewPackage("101234567890123456|RAL|12345|67890|12345|67890|12345|67890|OTHER|HAZARD");
        packageHandlerService.generateReport();
    }

    @Test
    public void getDistributionCentreSuccesfully() {
        packageHandlerService.getDistributionCentreService("NY");
    }

    @Test
    public void getDistributionCentreWithValueNA() {
        packageHandlerService.getDistributionCentreService("HI");
    }

    @Test
    public void getDistributionCentreForInvlaidState() {
        packageHandlerService.getDistributionCentreService("ZZ");
    }
}