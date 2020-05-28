package com.mycompany.tests;

import com.mycompany.configs.Bup;
import com.mycompany.driver.DriverConfiguration;
import com.mycompany.driver.DriverManager;
import com.mycompany.utils.ResourceUtils;
import com.mycompany.utils.ScreenshotsListener;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(value = ScreenshotsListener.class)

public abstract class BaseTest
{
    @BeforeSuite
    public void globalConfiguration()
    {
        DriverConfiguration config = ResourceUtils.getConfiguration();
        DriverManager.setDriverFactory(config).configureDriver();
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
