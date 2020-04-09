package com.mycompany.driver;

import com.codeborne.selenide.Configuration;
import com.mycompany.utils.ResourceUtils;

public class DefaultDriverManager
{
    protected DriverConfiguration defaultDriverConfiguration()
    {
        DriverConfiguration driverConfiguration = ResourceUtils.getConfiguration();
        Configuration.browserSize = driverConfiguration.getWindowWidth() + "x" + driverConfiguration.getWindowHeight();
        Configuration.timeout = driverConfiguration.getTimeoutSeconds();
        return driverConfiguration;
    }
}