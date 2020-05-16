package com.mycompany.driver;

import com.codeborne.selenide.Configuration;

public class FirefoxDriverFactory extends DefaultDriverFactory
{
    public FirefoxDriverFactory(DriverConfiguration driverConfiguration)
    {
        super(driverConfiguration);
    }

    @Override
    public void configureDriver()
    {
        defaultDriverConfiguration();
        Configuration.browser = BrowserType.FIREFOX.getBrowserType().toLowerCase();
        Configuration.browserVersion = driverConfiguration.getChromeVersion();
    }
}