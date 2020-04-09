package com.mycompany.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mycompany.driver.DriverConfiguration;

import java.io.File;
import java.io.IOException;

public class ResourceUtils
{
    private static final String BROWSER_TYPE_SYSTEM_PROPERTY = "test.driver.browser.type";
    private static final String DRIVER_EXECUTION_SYSTEM_PROPERTY = "test.driver.execution";

    public static DriverConfiguration getConfiguration()
    {
        DriverConfiguration driverConfiguration = getConfigFromFile();
        if (getSystemProp(BROWSER_TYPE_SYSTEM_PROPERTY) != null)
        {
            driverConfiguration.setBrowserType(getSystemProp(BROWSER_TYPE_SYSTEM_PROPERTY).toUpperCase());
        }
        if (getSystemProp(DRIVER_EXECUTION_SYSTEM_PROPERTY) != null)
        {
            driverConfiguration.setDriverExecutionType(getSystemProp(DRIVER_EXECUTION_SYSTEM_PROPERTY).toUpperCase());
        }
        return driverConfiguration;
    }

    private static String getSystemProp(String name)
    {
        return System.getProperty(name);
    }

    private static DriverConfiguration getConfigFromFile()
    {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        DriverConfiguration driverConfiguration = new DriverConfiguration();
        try
        {
            driverConfiguration = mapper.readValue(new File("src/test/resources/driverConfig.yaml"),
                DriverConfiguration.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return driverConfiguration;
    }
}
