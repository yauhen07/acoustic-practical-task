package com.mycompany.tests;

import com.mycompany.pageobjects.ResultsPageOtherFilter;
import com.mycompany.services.RWOperations;
import com.mycompany.utils.BupUtils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class VerifySearchResultsTest extends BaseTest
{
    private final String FROM_STATION = "Минск-Пассажирский";
    private final String TO_STATION = "Молодечно";
    private final GregorianCalendar DATE = new GregorianCalendar(2020, Calendar.APRIL, 16);
    private final int COUNT_DATE_FILTERS = 4;
    private final int NUMBER_OF_LOADED_PNG = 5;
    private RWOperations rwOperations;

    @BeforeTest
    private void profileSetup()
    {
        BupUtils.initProxyFor("pass.rw.by");
    }


    @Test
    public void searchAndVerifyResults() throws InterruptedException
    {

        rwOperations = new RWOperations();
        rwOperations.openSearchPage();
        rwOperations.search(FROM_STATION, TO_STATION, DATE);
        rwOperations.rwResultsPage.rwResultsRouteSelectorPage.radioButtonDefault();
        rwOperations.collectTrainsToList();
        rwOperations.verifyOtherFilterResults(ResultsPageOtherFilter.E_REGISTRATION);
        //        Har har = Bup.proxyServer.getHar();
        //        BupUtils.verifyLoadedPngMoreThan(har, NUMBER_OF_LOADED_PNG);
        rwOperations.rwResultsPage.countDateFilters(COUNT_DATE_FILTERS);
    }
}
