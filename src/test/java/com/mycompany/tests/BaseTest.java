package com.mycompany.tests;

import com.mycompany.builders.Director;
import com.mycompany.builders.FilterBuilder;
import com.mycompany.configs.Bup;
import com.mycompany.driver.DriverConfiguration;
import com.mycompany.driver.DriverManager;
import com.mycompany.filters.Filter;
import com.mycompany.utils.ResourceUtils;
import com.mycompany.utils.ScreenshotsListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.List;

@Listeners(value = ScreenshotsListener.class)

public abstract class BaseTest
{
    protected Filter filter;
    protected Director director = new Director();
    protected FilterBuilder builder = new FilterBuilder();
    protected List<Object> listAllVariantsOfFilters = new ArrayList<>();


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
