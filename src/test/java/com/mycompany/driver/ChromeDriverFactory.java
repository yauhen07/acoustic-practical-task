package com.mycompany.driver;

import com.codeborne.selenide.Configuration;

public class ChromeDriverFactory extends DefaultDriverFactory
{
    public ChromeDriverFactory(DriverConfiguration driverConfiguration)
    {
        super(driverConfiguration);
    }

    @Override
    public void configureDriver()
    {
        defaultDriverConfiguration();
        Configuration.browser = BrowserType.CHROME.getBrowserType().toLowerCase();
        Configuration.browserVersion = driverConfiguration.getChromeVersion();
    }
}