package com.mycompany.driver;

import com.codeborne.selenide.Configuration;

public class ChromeDriverFactory extends DefaultDriverFactory
{
    public void configureDriver(DriverConfiguration driverConfiguration)
    {
        defaultDriverConfiguration(driverConfiguration);
        Configuration.browser = driverConfiguration.getBrowserType().toLowerCase();
        Configuration.browserVersion = driverConfiguration.getChromeVersion();
    }
}