package com.mycompany.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.mycompany.configs.Bup;
import com.mycompany.driver.DriverConfiguration;
import com.mycompany.utils.ResourceUtils;
import com.mycompany.utils.ScreenshotsListener;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(value = ScreenshotsListener.class)

public abstract class BaseTest
{
    @BeforeSuite
    public void globalConfiguration()
    {
                DriverConfiguration driverConfiguration = ResourceUtils.getConfigFromFile();
                Configuration.browser = driverConfiguration.browserType;
                Configuration.baseUrl = driverConfiguration.hubUrl;
                Configuration.browserSize = driverConfiguration.windowWidth + "x" + driverConfiguration.windowHeight;
                Configuration.browserVersion = driverConfiguration.chromeVersion;
                Configuration.timeout = driverConfiguration.timeoutSeconds;
    }

    @AfterTest
    private void stopProxyServer()
    {
        if (Bup.proxyServer.isStarted())
        {
            Bup.proxyServer.stop();
        }
    }
}
