package com.mycompany.pageobjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.mycompany.enums.OtherFilter;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;

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

    @Step("Verify '{otherFilter.ruName}' filter working correctly")
    public void otherFilterResultsVerify(OtherFilter otherFilter)
    {
        $(By.xpath(otherFilter.getOtherFilterLocator())).click();
        for (SelenideElement element : $$(LIST_OF_TRAINS_FILTERED_BY_OTHER))
        {
            element.shouldHave(Condition.not(Condition.attribute("class", "hidden")));

            assertEquals(element.getAttribute("class").endsWith("hidden"), false);
        }
    }

    @Step("Verify '{expectedCountOfDateFilters}' date filters above trains schedule")
    public void countDateFilters(int expectedCountOfDateFilters)
    {
        $$(LIST_OF_DATE_FILTERS_ABOVE_TRAIN_SCHEDULE)
            .shouldHave(CollectionCondition.size(expectedCountOfDateFilters));
    }
}
