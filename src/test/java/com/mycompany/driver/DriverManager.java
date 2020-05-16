package com.mycompany.driver;

public class DriverManager
{
    private static DefaultDriverFactory defaultDriverFactory;

    public static DefaultDriverFactory getDefaultDriverFactory()
    {
        return defaultDriverFactory;
    }

    public static void setDefaultDriverFactory(DefaultDriverFactory defaultDriverFactory)
    {
        DriverManager.defaultDriverFactory = defaultDriverFactory;
    }

    public static DefaultDriverFactory setDriverFactory(DriverConfiguration driverConfiguration)
    {
        //        DefaultDriverFactory defaultDriverFactory;
        if (driverConfiguration.getDriverExecutionType().equals(DriverExecutionType.REMOTE))
        {
            return new RemoteDriverFactory(driverConfiguration);
        }
        else
        {
            driverSelector(driverConfiguration);
        }
        return defaultDriverFactory;
    }

    public static DefaultDriverFactory driverSelector(DriverConfiguration driverConfiguration)
    {
        switch (driverConfiguration.getBrowserType())
        {
            case "CHROME":
                defaultDriverFactory = new ChromeDriverFactory(driverConfiguration);
                break;
            case "FIREFOX":
                defaultDriverFactory = new FirefoxDriverFactory(driverConfiguration);
                break;
            default:
                defaultDriverFactory = new ChromeDriverFactory(driverConfiguration);
        }
        return defaultDriverFactory;
    }
}