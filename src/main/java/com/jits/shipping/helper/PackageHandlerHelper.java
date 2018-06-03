package com.jits.shipping.helper;

import com.jits.shipping.constants.AppConstants;
import com.jits.shipping.entity.Package;
import com.jits.shipping.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Anand Philips on 6/1/2018.
 */
@Component
public class PackageHandlerHelper {
    private static Logger LOGGER = LoggerFactory.getLogger(PackageHandlerHelper.class);

    public Package validateAndAddPackage(String barCode) throws ValidationException {

        //Format ID|GRD|FROMZIP|TOZIP|WEIGHT|HEIGHT|WIDTH|DEPTH|OTHER|HAZARD|
        //Valid Example 012345678901234567|GRD|12345|67890|12345|67890|12345|67890|OTHER|HAZARD|
        Package aPackage = new Package();

        String id = barCode.substring(0, 18);
        aPackage.setId(id);

        String shipMethod = barCode.substring(18, 21);
        if (Arrays.asList(AppConstants.validShipMethods).contains(shipMethod)) {
            aPackage.setShipMethod(shipMethod);
        } else {
            throw new ValidationException("Invalid Shipment Method");
        }

        String fromZip = barCode.substring(21, 26);
        try {
            Integer.parseInt(fromZip);
            aPackage.setFromZip(fromZip);
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid From Zip Code");
        }

        String toZip = barCode.substring(26, 31);
        try {
            Integer.parseInt(toZip);
            aPackage.setFromZip(toZip);
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid To Zip Code");
        }

        String weight = barCode.substring(31, 36);
        try {
            aPackage.setWeight(Float.parseFloat(weight));
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid Weight");
        }

        String height = barCode.substring(36, 41);
        try {
            aPackage.setHeight(Integer.parseInt(height));
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid Height");
        }

        String width = barCode.substring(41, 46);
        try {
            aPackage.setWidth(Integer.parseInt(width));
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid Width");
        }

        String depth = barCode.substring(46, 51);
        try {
            aPackage.setDepth(Integer.parseInt(depth));
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid To depth");
        }

        aPackage.setOther(barCode.substring(51, 56));

        aPackage.setHazards(barCode.substring(56, 62));
        LOGGER.debug("Validation has been successfully completed for {}", barCode);
        return aPackage;
    }
}
