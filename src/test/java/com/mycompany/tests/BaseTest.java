package com.mycompany.tests;

import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.Har;
import com.codeborne.selenide.Selenide;
import com.mycompany.configs.Bup;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

public abstract class BaseTest
{
    protected static final String BASE_URL = "https://pass.rw.by/";

    @BeforeClass
    public void con()
    {
        Selenide.clearBrowserCookies();

        System.setProperty("selenide.browser", "com.mycompany.configs.BupChrome");
//        Har har = null;
//        Bup.proxyServer = new BrowserUpProxyServer();
//        Bup.proxyServer.start();
//        Bup.proxyServer.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
//        har = Bup.proxyServer.getHar();
//        har.toString();




    }

    @AfterClass
    public void waitTo()
    {

    }

}
