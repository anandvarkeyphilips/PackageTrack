package com.jits.shipping.service;

import com.jits.shipping.entity.Package;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * Created by Harsha Philips on 5/31/2018.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PackageHandlerServiceTest {


    @Autowired
    PackageHandlerService packageHandlerService;



    @Test
    public  void addNewPackage(){
        packageHandlerService.addNewPackage("12345678901234567892123456789012345678901234567890OTHERHAZARD");

    }
}