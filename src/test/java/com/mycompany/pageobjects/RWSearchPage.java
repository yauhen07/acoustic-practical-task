package com.mycompany.pageobjects;

import org.openqa.selenium.By;

import java.util.Calendar;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RWSearchPage extends AbstractPage
{
    private static final By FROM_STATION_FIELD = By.id("one-way-raspFormFromTitle");
    private static final By TO_STATION_FIELD = By.id("one-way-raspFormToTitle");
    private static final By DATE_FIELD = By.xpath("//div[@class='collapse in']//div[@class='tab-pane fade in "
        + "active']//div[@class='rasp-form__inp input-group date']");
    private static final By SUBMIT_BUTTON = By.xpath("//div[@class='collapse in']//div[@class='tab-pane fade in active']//button[@class='btn btn-default "
        + "btn-submit js-input-taber']");

    @Step("Set '{fromStation}' value for 'Откуда' field, '{toStation}' value for 'Куда' field and click 'Найти' button")
    public RWResultsPage search(String fromStation, String toStation, Calendar date)
    {
        $(FROM_STATION_FIELD).setValue(fromStation);
        $(TO_STATION_FIELD).setValue(toStation);
        $(DATE_FIELD).click();
        $(By.xpath("//td[@data-year = '" + date.get(1) + "'][@data-month = '" + date.get(2) +
            "']/a[text() = '" + date.get(5) + "']")).click();
        $(SUBMIT_BUTTON).click();
        return page(RWResultsPage.class);
    }
}

