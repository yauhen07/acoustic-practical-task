package com.mycompany.configs;

import com.browserup.bup.client.ClientUtil;
import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BupChrome implements WebDriverProvider
{

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities)
    {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.PROXY, ClientUtil.createSeleniumProxy(Bup.proxyServer));
        return new ChromeDriver(capabilities);
    }
}
