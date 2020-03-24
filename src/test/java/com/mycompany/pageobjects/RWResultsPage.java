package com.mycompany.pageobjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class RWResultsPage extends AbstractPage
{
    private final By RADIO_BUTTON_DIRECTIONS = By.xpath("//li[@class = 'rasp-filter__radio active']//*[text() = 'В "
        + "одну сторону']");
    private final By LIST_OF_TRAINS_FILTERED_BY_OTHER = By.xpath("//i[@class= 'svg-tag-er']/../../../../..");
    private final By LIST_OF_DATE_FILTERS_ABOVE_TRAIN_SCHEDULE = By.xpath("//li[@class='sch-links__item "
        + "active']|//li[@class='sch-links__item']");
    private final By LIST_OF_ALL_DISPLAYED_TRAINS_NAMES = By.xpath("//span[@class = 'train-route']");
    private final By LIST_OF_ALL_DISPLAYED_TRAINS_DEPARTURE = By.xpath("//div[@class = 'sch-table__time train-from-time']");
    private final By LIST_OF_ALL_DISPLAYED_TRAINS_DURATION = By.xpath("//div[@class = 'sch-table__duration "
        + "train-duration-time']|div[@data-value]");

    @Step("Verify 'В одну сторону' radio button selected by default")
    public void radioButtonDefault()
    {
        $(RADIO_BUTTON_DIRECTIONS).should(exist);
    }

    public void filterResultsUsingOtherFilter(ResultsPageOtherFilter resultsPageOtherFilter)
    {
        Configuration.clickViaJs = true;
        $x(resultsPageOtherFilter.getOtherFilterLocator()).click();
        Configuration.clickViaJs = false;
    }

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
