package com.elenaffm.finaltesting.reports;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {

    public static ExtentReports getInstance() {
        ExtentReports extent = new ExtentReports();

        extent.setSystemInfo("Selenium Version", "4.1.4");
        return extent;
    }

}
