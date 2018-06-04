package com.jits.shipping.helper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1509967 on 6/4/2018.
 */
@Component
public class InformationLookupHelper {
    private Map<String, String> statesToDistributionCentreMap = new HashMap<>();

    {
        statesToDistributionCentreMap.put("AL", "DC2");
        statesToDistributionCentreMap.put("AK", "DC3");
        statesToDistributionCentreMap.put("AZ", "DC3");
        statesToDistributionCentreMap.put("AR", "DC1");
        statesToDistributionCentreMap.put("CA", "DC3");
        statesToDistributionCentreMap.put("CO", "DC3");
        statesToDistributionCentreMap.put("CT", "DC1");
        statesToDistributionCentreMap.put("DE", "DC1");
        statesToDistributionCentreMap.put("DC", "DC1");
        statesToDistributionCentreMap.put("FL", "DC1");
        statesToDistributionCentreMap.put("GA", "DC1");
        statesToDistributionCentreMap.put("HI", "NA");
        statesToDistributionCentreMap.put("ID", "DC3");
        statesToDistributionCentreMap.put("IL", "DC2");
        statesToDistributionCentreMap.put("IN", "DC2");
        statesToDistributionCentreMap.put("IA", "DC2");
        statesToDistributionCentreMap.put("KS", "DC3");
        statesToDistributionCentreMap.put("KY", "DC2");
        statesToDistributionCentreMap.put("LA", "DC2");
        statesToDistributionCentreMap.put("ME", "DC1");
        statesToDistributionCentreMap.put("MD", "DC1");
        statesToDistributionCentreMap.put("MA", "DC1");
        statesToDistributionCentreMap.put("MI", "DC2");
        statesToDistributionCentreMap.put("MN", "DC2");
        statesToDistributionCentreMap.put("MS", "DC2");
        statesToDistributionCentreMap.put("MO", "DC2");
        statesToDistributionCentreMap.put("MT", "DC3");
        statesToDistributionCentreMap.put("NE", "DC3");
        statesToDistributionCentreMap.put("NV", "DC3");
        statesToDistributionCentreMap.put("NH", "DC1");
        statesToDistributionCentreMap.put("NJ", "DC1");
        statesToDistributionCentreMap.put("NM", "DC3");
        statesToDistributionCentreMap.put("NY", "DC1");
        statesToDistributionCentreMap.put("NC", "DC1");
        statesToDistributionCentreMap.put("ND", "DC3");
        statesToDistributionCentreMap.put("OH", "DC1");
        statesToDistributionCentreMap.put("OK", "DC3");
        statesToDistributionCentreMap.put("OR", "DC3");
        statesToDistributionCentreMap.put("PA", "DC1");
        statesToDistributionCentreMap.put("RI", "DC1");
        statesToDistributionCentreMap.put("SC", "DC1");
        statesToDistributionCentreMap.put("SD", "DC3");
        statesToDistributionCentreMap.put("TN", "DC1");
        statesToDistributionCentreMap.put("TX", "DC3");
        statesToDistributionCentreMap.put("UT", "DC3");
        statesToDistributionCentreMap.put("VT", "DC1");
        statesToDistributionCentreMap.put("VA", "DC1");
        statesToDistributionCentreMap.put("WA", "DC2");
        statesToDistributionCentreMap.put("WV", "DC1");
        statesToDistributionCentreMap.put("WI", "DC2");
        statesToDistributionCentreMap.put("WY", "DC3");
    }

    public String getDistributionCentre(String stateCode) {
        return statesToDistributionCentreMap.get(stateCode);
    }
}
