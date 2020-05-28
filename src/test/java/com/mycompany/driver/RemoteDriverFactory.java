package com.mycompany.driver;

import com.codeborne.selenide.Configuration;
import com.mycompany.utils.StartGrid;

public class RemoteDriverFactory extends DefaultDriverFactory
{
    public RemoteDriverFactory(DriverConfiguration driverConfiguration)
    {
        super(driverConfiguration);
    }

    @Override
    public void configureDriver()
    {
        defaultDriverConfiguration();
        StartGrid.startGrid();
        Configuration.remote = driverConfiguration.getHubUrl();

        DriverManager.driverSelector(driverConfiguration);
    }
}