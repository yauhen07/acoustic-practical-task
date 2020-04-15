package com.mycompany.driver;

public class DriverManagerFactory
{
    public static DefaultDriverFactory driverManager(DriverConfiguration driverConfiguration)
    {
        DefaultDriverFactory defaultDriverFactory;
        if (driverConfiguration.getDriverExecutionType().equals(DriverExecutionType.REMOTE.getExecutionType()))
        {
            return new RemoteDriverFactory();
        }
        else
        {
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
        return defaultDriverFactory;
    }
}