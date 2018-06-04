package com.jits.shipping.helper;

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
public class PackageHandlerHelperTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Autowired
    private PackageHandlerHelper packageHandlerHelper;

    //Format ID|GRD|FROMZIP|TOZIP|WEIGHT|HEIGHT|WIDTH|DEPTH|OTHER|HAZARD
    //Valid Example 012345678901234567|GRD|12345|67890|12345|67890|12345|67890|OTHER|HAZARD

    @Test
    public void addNewPackageTestSuccessful() throws Exception {
        packageHandlerHelper.validateAndAddPackage("012345678901234567|GRD|12345|67890|12345|67890|12345|67890|OTHER|HAZARD");
    }

    @Test
    public void addNewPackageTestInvalidShipMethod() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid Shipment Method");
        packageHandlerHelper.validateAndAddPackage("012345678901234567|GRC|12345|67890|12345|67890|12345|67890|OTHER|HAZARD");
    }

    @Test
    public void addNewPackageTestInvalidFromZipCode() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid From Zip Code");
        packageHandlerHelper.validateAndAddPackage("012345678901234567|GRD|wrong|67890|12345|67890|12345|67890|OTHER|HAZARD");
    }

    @Test
    public void addNewPackageTestInvalidToZipCode() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid To Zip Code");
        packageHandlerHelper.validateAndAddPackage("012345678901234567|GRD|12345|wrong|12345|67890|12345|67890|OTHER|HAZARD");
    }

    @Test
    public void addNewPackageTestCorrectWeight() throws Exception {
        packageHandlerHelper.validateAndAddPackage("012345678901234567|GRD|12345|67890|30.0|67890|12345|67890|OTHER|HAZARD");
    }

    @Test
    public void addNewPackageTestInvalidWeight() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid Weight");
        packageHandlerHelper.validateAndAddPackage("012345678901234567|GRD|12345|67890|abc|67890|12345|67890|OTHER|HAZARD");
    }

    @Test
    public void addNewPackageTestInvalidHeight() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("Invalid Height");
        packageHandlerHelper.validateAndAddPackage("012345678901234567|GRD|12345|67890|0.20|wrng|12345|67890|OTHER|HAZARD");
    }

    @Test
    public void addNewPackageTestInvalidDataExtra() throws Exception {
        exception.expect(ValidationException.class);
        exception.expectMessage("The Barcode is having invalid number of details");
        packageHandlerHelper.validateAndAddPackage("012345678901234567|GRD|12345|67890|0.20|wrng|12345|67890|OTHER|HAZARD|EXTRA");
    }
}