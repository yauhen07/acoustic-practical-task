package com.mycompany.driver;

import com.codeborne.selenide.Configuration;

public abstract class DefaultDriverFactory
{
    protected DriverConfiguration driverConfiguration;

    public DefaultDriverFactory(DriverConfiguration driverConfiguration)
    {
        this.driverConfiguration = driverConfiguration;
    }

    public abstract void configureDriver();

    protected void defaultDriverConfiguration()
    {
        Configuration.browserSize = driverConfiguration.getWindowWidth() + "x" + driverConfiguration.getWindowHeight();
        Configuration.timeout = driverConfiguration.getTimeoutSeconds();
    }
}