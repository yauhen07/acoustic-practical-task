package com.mycompany.driver;

public class DriverManager
{
    private static DefaultDriverFactory driverFactory;

    public static DefaultDriverFactory getDriverFactory()
    {
        return driverFactory;
    }

    public static void setDriverFactory(DefaultDriverFactory driverFactory)
    {
        DriverManager.driverFactory = driverFactory;
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
        return driverFactory;
    }

    public static DefaultDriverFactory driverSelector(DriverConfiguration driverConfiguration)
    {
        switch (driverConfiguration.getBrowserType())
        {
            case "CHROME":
                driverFactory = new ChromeDriverFactory(driverConfiguration);
                break;
            case "FIREFOX":
                driverFactory = new FirefoxDriverFactory(driverConfiguration);
                break;
            default:
                driverFactory = new ChromeDriverFactory(driverConfiguration);
        }
        return driverFactory;
    }
}