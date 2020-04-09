package com.mycompany.driver;

import com.codeborne.selenide.Configuration;
import com.mycompany.utils.StartGrid;

public class RemoteDriverFactory extends DefaultDriverManager
{

    public void configureDriver(String browserType)
    {
        StartGrid.startGrid();
        Configuration.remote = defaultDriverConfiguration().getHubUrl();

        switch (browserType)
        {
            case "CHROME":
                new ChromeDriverManager().configureDriver();
                break;
            case "FIREFOX":
                new FirefoxDriverManager().configureDriver();
                break;
        }
    }
}