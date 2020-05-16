package com.mycompany.driver;

public class DriverConfiguration
{
    private DriverExecutionType driverExecutionType;
    private String browserType;
    private String hubUrl;
    private String windowWidth;
    private String windowHeight;
    private String chromeVersion;
    private int timeoutSeconds;

    public DriverExecutionType getDriverExecutionType()
    {
        return driverExecutionType;
    }

    public void setDriverExecutionType(DriverExecutionType driverExecutionType)
    {
        this.driverExecutionType = driverExecutionType;
    }

    public String getBrowserType()
    {
        return browserType;
    }

    public void setBrowserType(String browserType)
    {
        this.browserType = browserType;
    }

    public String getHubUrl()
    {
        return hubUrl;
    }

    public void setHubUrl(String hubUrl)
    {
        this.hubUrl = hubUrl;
    }

    public String getWindowWidth()
    {
        return windowWidth;
    }

    public void setWindowWidth(String windowWidth)
    {
        this.windowWidth = windowWidth;
    }

    public String getWindowHeight()
    {
        return windowHeight;
    }

    public void setWindowHeight(String windowHeight)
    {
        this.windowHeight = windowHeight;
    }

    public String getChromeVersion()
    {
        return chromeVersion;
    }

    public void setChromeVersion(String chromeVersion)
    {
        this.chromeVersion = chromeVersion;
    }

    public int getTimeoutSeconds()
    {
        return timeoutSeconds;
    }

    public void setTimeoutSeconds(int timeoutSeconds)
    {
        this.timeoutSeconds = timeoutSeconds;
    }
}
