package com.mycompany.driver;

import com.codeborne.selenide.Configuration;
import com.mycompany.utils.StartGrid;

public class RemoteDriverFactory extends DefaultDriverFactory
{

    public void configureDriver(DriverConfiguration driverConfiguration)
    {
        DefaultDriverFactory defaultDriverFactory;
        StartGrid.startGrid();
        Configuration.remote = driverConfiguration.getHubUrl();

        switch (driverConfiguration.getBrowserType())
        {
            case "CHROME":
                defaultDriverFactory = new ChromeDriverFactory();
                break;
            case "FIREFOX":
                defaultDriverFactory = new FirefoxDriverFactory();
                break;
            default:
                defaultDriverFactory = new ChromeDriverFactory();
        }
    }
}