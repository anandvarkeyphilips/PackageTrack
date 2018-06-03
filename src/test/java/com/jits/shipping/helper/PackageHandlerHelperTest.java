package com.jits.shipping.service;

import com.jits.shipping.exceptions.ValidationException;
import com.jits.shipping.helper.PackageHandlerHelper;
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
public class PackageHandlerHelperTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Autowired
    private PackageHandlerHelper packageHandlerHelper;

    //Format ID|GRD|FROMZIP|TOZIP|WEIGHT|HEIGHT|WIDTH|DEPTH|OTHER|HAZARD|
    //Valid Example 012345678901234567|GRD|12345|67890|12345|67890|12345|67890|OTHER|HAZARD|

    @Test
    public void addNewPackageTestSuccessful() throws Exception {
        packageHandlerHelper.validateAndAddPackage("001234567890123456GRD123456789012345678901234567890OTHERHAZARD");
    }

    @Test
    public void addNewPackageTestInvalidShipMethod() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid Shipment Method");
        packageHandlerHelper.validateAndAddPackage("0012345678901234567892123456789012345678901234567890OTHERHAZARD");
    }

    @Test
    public void addNewPackageTestInvalidFromZipCode() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid From Zip Code");
        packageHandlerHelper.validateAndAddPackage("001234567890123456GRDwrong6789012345678901234567890OTHERHAZARD");
    }

    @Test
    public void addNewPackageTestInvalidToZipCode() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid To Zip Code");
        packageHandlerHelper.validateAndAddPackage("001234567890123456GRD12345wrong12345678901234567890OTHERHAZARD");
    }

    @Test
    public void addNewPackageTestInvalidHeight() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid Weight");
        packageHandlerHelper.validateAndAddPackage("001234567890123456GRD1234567890wrong678901234567890OTHERHAZARD");
    }
}