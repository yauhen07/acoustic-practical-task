package com.mycompany.pageobjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertFalse;

public class RWResultsPage extends AbstractPage
{
    private static final By RADIO_BUTTON_DIRECTIONS = By.xpath("//li[@class = 'rasp-filter__radio active']//*[text() = 'В "
        + "одну сторону']");
    private static final By LIST_OF_TRAINS_FILTERED_BY_OTHER = By.xpath("//i[@class= 'svg-tag-er']/../../../../..");
    private static final By LIST_OF_DATE_FILTERS_ABOVE_TRAIN_SCHEDULE = By.xpath("//li[@class='sch-links__item "
        + "active']|//li[@class='sch-links__item']");

    @Step("Verify 'В одну сторону' radio button selected by default")
    public void radioButtonDefault()
    {
        $(RADIO_BUTTON_DIRECTIONS).should(exist);
    }

    public void filterResultsUsingOtherFilter(ResultsPageOtherFilter resultsPageOtherFilter)
    {
        $x(resultsPageOtherFilter.getOtherFilterLocator()).click();
    }

    public ElementsCollection collectListofTrainsFilteredByOther()
    {
        return $$(LIST_OF_TRAINS_FILTERED_BY_OTHER);
    }

    @Step("Verify '{expectedCountOfDateFilters}' date filters above trains schedule")
    public void countDateFilters(int expectedCountOfDateFilters)
    {
        $$(LIST_OF_DATE_FILTERS_ABOVE_TRAIN_SCHEDULE)
            .shouldHave(CollectionCondition.size(expectedCountOfDateFilters));
    }
}
