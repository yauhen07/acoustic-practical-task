package com.mycompany.utils;

import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.Har;
import com.mycompany.configs.Bup;

import java.util.stream.Collectors;

import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;

public class BupUtils
{
    public static void initProxyFor(String url)
    {
        Har har = null;
        Bup.proxyServer = new BrowserUpProxyServer();
        Bup.proxyServer.start();
        Bup.proxyServer.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
        Bup.proxyServer.newHar(url);
    }

    @Step("Verify count of loaded .png files id more than '{png}'")
    public static void verifyLoadedPngMoreThan(Har har, int png)
    {
        assertTrue(har.getLog().getEntries().stream()
            .filter(p -> p.getResponse()
                .getContent()
                .getMimeType()
                .contains("png"))
            .collect(Collectors.toList()).size() > png, "Nunmer of loaded .png on Results page is less than '" + png + "'");
    }
}
