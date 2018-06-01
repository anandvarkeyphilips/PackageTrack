package com.jits.shipping.helper;

import com.jits.shipping.constants.AppConstants;
import com.jits.shipping.entity.Package;

import java.util.Arrays;

/**
 * Created by Harsha Philips on 6/1/2018.
 */
public class PackageHandlerHelper {

    public void validateAndAddPackage(String barCode){
        Package aPackage = new Package();

        String  id = barCode.substring(0,17);
        aPackage.setId(id);

        String shipMethod = barCode.substring(18,20);
        if(Arrays.asList(AppConstants.validShipMethods).contains(shipMethod)){
            aPackage.setShipMethod(shipMethod);
        }else{
            throw  new IllegalArgumentException("Invalid Shipment Method");
        }

        String fromZip= barCode.substring(21,25);
        try{
            Integer.parseInt(fromZip);
            aPackage.setFromZip(fromZip);
        }catch (NumberFormatException e){
            throw  new IllegalArgumentException("Invalid From Zip Code");
        }

        String  toZip= barCode.substring(26,30);
        try{
            Integer.parseInt(toZip);
            aPackage.setFromZip(toZip);
        }catch (NumberFormatException e){
            throw  new IllegalArgumentException("Invalid To Zip Code");
        }

        Float weight;
        int height;
        int width;
        int depth;
        String other;
        String hazards;


    }
}
