package com.mycompany.driver;

import com.codeborne.selenide.Configuration;

public abstract class DefaultDriverFactory
{
    public abstract void configureDriver(DriverConfiguration driverConfiguration);

    protected void defaultDriverConfiguration(DriverConfiguration driverConfiguration)
    {
        Configuration.browserSize = driverConfiguration.getWindowWidth() + "x" + driverConfiguration.getWindowHeight();
        Configuration.timeout = driverConfiguration.getTimeoutSeconds();
    }
}