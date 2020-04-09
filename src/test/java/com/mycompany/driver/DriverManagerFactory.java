package com.mycompany.driver;

public class DriverManagerFactory
{
    public static void driverManager(DriverConfiguration driverConfiguration)
    {
        if (driverConfiguration.getDriverExecutionType().equals("REMOTE"))
        {
            new RemoteDriverFactory().configureDriver(driverConfiguration.getBrowserType());
        }
        else
        {
            switch (driverConfiguration.getBrowserType())
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
}