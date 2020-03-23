package com.mycompany.utils;

import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.Har;
import com.mycompany.configs.Bup;

import java.util.stream.Collectors;

import io.qameta.allure.Step;

public class BupUtils
{
    public static Har getHarFor(String url)
    {
        Bup.proxyServer = new BrowserUpProxyServer();
        Bup.proxyServer.start();
        Bup.proxyServer.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
        Bup.proxyServer.newHar(url);
        return Bup.proxyServer.getHar();
    }

    @Step("Verify count of loaded .png files id more than '{png}'")
    public static boolean verifyLoadedPngMoreThan(Har har, int png)
    {
        har = Bup.proxyServer.getHar();
        return ((har.getLog().getEntries().stream()
            .filter(p -> p.getResponse()
                .getContent().getMimeType().contains("png"))
            .collect(Collectors.toList())).size() >= png);
    }
}
