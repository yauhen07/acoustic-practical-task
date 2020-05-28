package com.mycompany.services;

import com.codeborne.selenide.SelenideElement;
import com.mycompany.model.Train;
import com.mycompany.pageobjects.RWResultsPage;
import com.mycompany.pageobjects.RWSearchPage;
import com.mycompany.pageobjects.ResultsPageOtherFilter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertFalse;

public class RWOperations
{
    public RWSearchPage rwSearchPage;
    public RWResultsPage rwResultsPage;

    public void openSearchPage()
    {
        rwSearchPage = open(RWSearchPage.SEARCH_URL, RWSearchPage.class);
    }

    @Step("Set '{fromStation}' value for 'Откуда' field, '{toStation}' value for 'Куда' field and click 'Найти' button")
    public RWResultsPage search(String fromStation, String toStation, Calendar calendar)
    {
        rwSearchPage.setFromStationField(fromStation);
        rwSearchPage.setToStationField(toStation);
        rwSearchPage.clickDateField();
        rwSearchPage.setDateField(calendar);
        rwSearchPage.clickSubmitButton();
        rwResultsPage = page(RWResultsPage.class);
        return rwResultsPage;
    }

    @Step("Verify '{resultsPageOtherFilter.ruName}' filter working correctly")
    public void verifyOtherFilterResults(ResultsPageOtherFilter resultsPageOtherFilter)
    {
        rwResultsPage.rwResultsOtherFilterPage.filterResultsUsingOtherFilter(resultsPageOtherFilter);
        for (SelenideElement element : rwResultsPage.collectListOfTrainsFilteredByOther())
        {
            assertFalse(element.getAttribute("class").endsWith("hidden"),
                "Not only trains with '" + resultsPageOtherFilter.ruName +
                    "' option is displayed");
        }
    }

    @Step("Collect all displayed trains in 'List<Trains>'")
    public List<Train> collectTrainsToList()
    {
        List<Train> listOfTrainsOnResultsPage = new ArrayList<>();
        for (int i = 0; i <= rwResultsPage.collectAllDisplayedTrainsNames().size() - 1; i++)
        {
            listOfTrainsOnResultsPage.add(new Train(rwResultsPage.collectAllDisplayedTrainsNames().texts().get(i),
                rwResultsPage.collectAllDisplayedTrainsDeparture().texts().get(i),
                rwResultsPage.collectAllDisplayedTrainsDuration().get(i).getAttribute("data-value")));
        }
        return listOfTrainsOnResultsPage;
    }
}
