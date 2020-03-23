package com.mycompany.driver;

public class DriverConfiguration
{
    public String driverExecutionType;
    public String browserType;
    public String hubUrl;
    public String windowWidth;
    public String windowHeight;
    public String chromeVersion;
    public int timeoutSeconds;

    public String getDriverExecutionType()
    {
        return driverExecutionType;
    }

    public void setDriverExecutionType(String driverExecutionType)
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
