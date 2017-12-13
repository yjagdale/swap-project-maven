package com.test.utilis;

import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonUtils {

    public static boolean assertResultContains(List<String> allResults, List<String> resultAssert) {
        boolean status = true;
        for (int i = 0; i < allResults.size(); i++) {
            status = false;
            for (int j = 0; j < resultAssert.size(); j++) {
               // System.out.println("Comparing " + allResults.get(i).toUpperCase() + "    With " + resultAssert.get(j));
                if (allResults.get(i).toUpperCase().contains(resultAssert.get(j).toUpperCase())) {
                    status = true;
                }
            }
            if(!status){
                return false;
            }
        }
        return true;
    }
}
