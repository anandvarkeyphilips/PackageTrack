package com.jits.shipping.service;

import com.jits.shipping.entity.Package;
import com.jits.shipping.exceptions.ValidationException;
import com.jits.shipping.helper.PackageHandlerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Anand Philips on 5/31/2018.
 */
@Component
public class PackageHandlerService {
    @Autowired
    private PackageHandlerHelper packageHandlerHelper;

    private static Logger LOGGER = LoggerFactory.getLogger(PackageHandlerService.class);

    public List<Package> packageList = new ArrayList<>();

    public void addNewPackage(String barCode) {
        try {
            Package aPackage = packageHandlerHelper.validateAndAddPackage(barCode);
            packageList.add(aPackage);
            LOGGER.error("New package({}) has been successfully added.", barCode);
        } catch (ValidationException e) {
            LOGGER.error("invalid bar code scanned {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Technical Error in processing.", e);
        }
    }

    public void generateReport() {
        Map<String, List<Package>> packageListForShipmentMethod =
                packageList.stream().collect(Collectors.groupingBy(w -> w.getShipMethod()));
        System.out.println("JITS Shipping Package Report\n");
        System.out.println("Package ID        | Shipping Method");
        packageListForShipmentMethod.forEach(((s, packages) -> {
            Collections.sort(packages, Package.idComparator);
            packages.forEach(p -> {
                System.out.println(p.getId() + "| " + p.getShipMethod());
            });
        }));
    }
}
