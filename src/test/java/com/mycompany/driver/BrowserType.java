package com.mycompany.driver;

public enum BrowserType
{
    CHROME("CHROME"),
    FIREFOX("FIREFOX");

    private String browserType;

    BrowserType(String browserType)
    {
        this.browserType = browserType;
    }

    public String getBrowserType()
    {
        return browserType;
    }
}