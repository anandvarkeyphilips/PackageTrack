package com.jits.shipping.service;

import com.jits.shipping.entity.Package;
import com.jits.shipping.exceptions.ValidationException;
import com.jits.shipping.helper.PackageHandlerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Anand Philips on 5/31/2018.
 */
@Component
public class PackageHandlerService {
    @Autowired
    private PackageHandlerHelper packageHandlerHelper;

    private static Logger LOGGER = LoggerFactory.getLogger(PackageHandlerService.class);

    public Map<String, Package> packageMap;

    //Valid Format 012345678901234567|892|12345|67890|12345|67890|12345|67890|OTHER|HAZARD|
    public void addNewPackage(String barCode) {
        try {
            Package aPackage = packageHandlerHelper.validateAndAddPackage(barCode);
            packageMap.put(barCode, aPackage);
            LOGGER.error("New package {} has been successfully added.", barCode);
        } catch (ValidationException e) {
            LOGGER.error("invalid bar code scanned {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Error in processing.", e);
        }
    }
}
