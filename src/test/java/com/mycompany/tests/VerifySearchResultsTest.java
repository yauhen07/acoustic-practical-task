package com.mycompany.tests;

import com.mycompany.configs.Bup;
import com.mycompany.pageobjects.RWResultsPage;
import com.mycompany.pageobjects.ResultsPageOtherFilter;
import com.mycompany.services.RWResultsOperations;
import com.mycompany.services.RWSearchOperations;
import com.mycompany.utils.BupUtils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class VerifySearchResultsTest extends BaseTest
{
    private static final String FROM_STATION = "Минск-Пассажирский";
    private static final String TO_STATION = "Молодечно";
    private static final GregorianCalendar DATE = new GregorianCalendar(2020, Calendar.APRIL, 16);
    private static final int COUNT_DATE_FILTERS = 4;
    private static final int NUMBER_OF_LOADED_PNG = 5;


    @BeforeTest
    private void profileSetup()
    {
        har = BupUtils.getHarFor("pass.rw.by");
    }


    @Test
    public void searchAndVerifyResults() throws InterruptedException
    {
        RWResultsPage resultsPage = RWSearchOperations.search(FROM_STATION, TO_STATION, DATE);
        resultsPage.radioButtonDefault();
        RWResultsOperations.verifyOtherFilterResults(ResultsPageOtherFilter.E_REGISTRATION);
        BupUtils.verifyLoadedPngMoreThan(har, NUMBER_OF_LOADED_PNG);
        resultsPage.countDateFilters(COUNT_DATE_FILTERS);
    }
}
