package com.mycompany.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mycompany.driver.DriverConfiguration;

import java.io.File;
import java.io.IOException;

public class ResourceUtils
{
    public static DriverConfiguration getConfigFromFile()
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
