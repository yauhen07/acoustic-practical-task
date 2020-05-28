package com.mycompany.pageobjects;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$x;

public class RWResultsOtherFilterPage extends AbstractPage
{
    public void filterResultsUsingOtherFilter(ResultsPageOtherFilter resultsPageOtherFilter)
    {
        Configuration.clickViaJs = true;
        $x(resultsPageOtherFilter.getOtherFilterLocator()).click();
        Configuration.clickViaJs = false;
    }
}
