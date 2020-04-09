package com.mycompany.pageobjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class RWResultsPage extends AbstractPage
{
    private final By LIST_OF_TRAINS_FILTERED_BY_OTHER = By.xpath("//i[@class= 'svg-tag-er']/../../../../..");
    private final By LIST_OF_DATE_FILTERS_ABOVE_TRAIN_SCHEDULE = By.xpath("//li[@class='sch-links__item "
        + "active']|//li[@class='sch-links__item']");
    private final By LIST_OF_ALL_DISPLAYED_TRAINS_NAMES = By.xpath("//span[@class = 'train-route']");
    private final By LIST_OF_ALL_DISPLAYED_TRAINS_DEPARTURE = By.xpath("//div[@class = 'sch-table__time train-from-time']");
    private final By LIST_OF_ALL_DISPLAYED_TRAINS_DURATION = By.xpath("//div[@class = 'sch-table__duration "
        + "train-duration-time']|div[@data-value]");

    public RWResultsOtherFilterPage rwResultsOtherFilterPage = page(RWResultsOtherFilterPage.class);
    public RWResultsRouteSelectorPage rwResultsRouteSelectorPage = page(RWResultsRouteSelectorPage.class);

    public ElementsCollection collectListOfTrainsFilteredByOther()
    {
        return $$(LIST_OF_TRAINS_FILTERED_BY_OTHER);
    }

    @Step("Verify '{expectedCountOfDateFilters}' date filters above trains schedule")
    public void countDateFilters(int expectedCountOfDateFilters)
    {
        $$(LIST_OF_DATE_FILTERS_ABOVE_TRAIN_SCHEDULE)
            .shouldHave(CollectionCondition.size(expectedCountOfDateFilters));
    }

    public ElementsCollection collectAllDisplayedTrainsNames()
    {
        return $$(LIST_OF_ALL_DISPLAYED_TRAINS_NAMES);
    }

    public ElementsCollection collectAllDisplayedTrainsDeparture()
    {
        return $$(LIST_OF_ALL_DISPLAYED_TRAINS_DEPARTURE);
    }

    public ElementsCollection collectAllDisplayedTrainsDuration()
    {
        return $$(LIST_OF_ALL_DISPLAYED_TRAINS_DURATION);
    }
}
