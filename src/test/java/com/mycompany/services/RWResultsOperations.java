package com.mycompany.services;

import com.codeborne.selenide.SelenideElement;
import com.mycompany.pageobjects.ResultsPageOtherFilter;

import io.qameta.allure.Step;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RWResultsOperations extends RWSearchOperations
{
    @Step("Verify '{resultsPageOtherFilter.ruName}' filter working correctly")
    public static void verifyOtherFilterResults(ResultsPageOtherFilter resultsPageOtherFilter)
    {
        rwResultsPage.filterResultsUsingOtherFilter(resultsPageOtherFilter);
        for (SelenideElement element : rwResultsPage.collectListofTrainsFilteredByOther())
        {
            assertTrue(element.getAttribute("class").endsWith("hidden"), "Not only trains with '" + resultsPageOtherFilter.ruName +
                "' option is displayed");
        }
    }
}
