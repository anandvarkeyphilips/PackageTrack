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
        packageHandlerService.addNewPackage("01234567890123456GRD123456789012345678901234567890OTHERHAZARD");
    }

    @Test
    public void addNewPackageTestInvalidShipMethod() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid Shipment Method");
        packageHandlerService.addNewPackage("012345678901234567892123456789012345678901234567890OTHERHAZARD");
    }

    @Test
    public void addNewPackageTestInvalidFromZipCode() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid From Zip Code");
        packageHandlerService.addNewPackage("01234567890123456GRDwrong6789012345678901234567890OTHERHAZARD");
    }

    @Test
    public void addNewPackageTestInvalidToZipCode() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid To Zip Code");
        packageHandlerService.addNewPackage("01234567890123456GRD12345wrong12345678901234567890OTHERHAZARD");
    }

    @Test
    public void addNewPackageTestInvalidHeight() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid Weight");
        packageHandlerService.addNewPackage("01234567890123456GRD1234567890wrong678901234567890OTHERHAZARD");
    }
}