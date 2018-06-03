package com.jits.shipping.service;

import com.jits.shipping.exceptions.ValidationException;
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
    private PackageHandlerService packageHandlerService;

    @Test
    public void addNewPackageTestSuccessful() throws Exception {
        packageHandlerService.addNewPackage("001234567890123456GRD123456789012345678901234567890OTHERHAZARD");
    }

    @Test
    public void generateReport() throws Exception {
        packageHandlerService.addNewPackage("021344839439700689GRD123456789012345678901234567890OTHERHAZARD");
        packageHandlerService.addNewPackage("001234567890123458GRD123456789012345678901234567890OTHERHAZARD");
        packageHandlerService.addNewPackage("213654889765021231AIR123456789012345678901234567890OTHERHAZARD");
        packageHandlerService.addNewPackage("001234567890123456AIR123456789012345678901234567890OTHERHAZARD");
        packageHandlerService.addNewPackage("001234567890123456RAL123456789012345678901234567890OTHERHAZARD");
        packageHandlerService.addNewPackage("101234567890123456RAL123456789012345678901234567890OTHERHAZARD");
        packageHandlerService.generateReport();
    }

}