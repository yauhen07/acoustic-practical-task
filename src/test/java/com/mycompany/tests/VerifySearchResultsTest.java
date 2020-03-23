package com.mycompany.tests;

import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.Har;
import com.mycompany.configs.Bup;
import com.mycompany.enums.OtherFilter;
import com.mycompany.pageobjects.RWResultsPage;
import com.mycompany.pageobjects.RWSearchPage;

import org.testng.annotations.Test;

import java.util.GregorianCalendar;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;


public class VerifySearchResultsTest extends BaseTest
{
    private static final String FROM_STATION = "Минск-Пассажирский";
    private static final String TO_STATION = "Молодечно";
    private static final GregorianCalendar DATE = new GregorianCalendar(2020, 4, 16);
    private static final int COUNT_DATE_FILTERS = 4;

    @Test
    public void searchAndVerifyResults() throws InterruptedException
    {

        Har har = null;
        Bup.proxyServer = new BrowserUpProxyServer();
        Bup.proxyServer.start();
        Bup.proxyServer.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
        Bup.proxyServer.newHar("pass.rw.by");
        har = Bup.proxyServer.getHar();


        RWSearchPage searchPage = open(BASE_URL, RWSearchPage.class);
        RWResultsPage resultsPage = searchPage.search(FROM_STATION, TO_STATION, DATE);
        resultsPage.radioButtonDefault();
        resultsPage.otherFilterResultsVerify(OtherFilter.E_REGISTRATION);
        har = Bup.proxyServer.getHar();
        assertTrue((har.getLog().getEntries().stream()
            .filter(p -> p.getResponse()
                .getContent().getMimeType().contains("png"))
            .collect(Collectors.toList())).size() >= 5);

        resultsPage.countDateFilters(COUNT_DATE_FILTERS);

    }
}
