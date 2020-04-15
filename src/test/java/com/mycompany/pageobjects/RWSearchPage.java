package com.mycompany.pageobjects;

import org.openqa.selenium.By;

import java.util.Calendar;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RWSearchPage extends AbstractPage
{
    public static final String SEARCH_URL = "https://pass.rw.by/";
    private final By FROM_STATION_FIELD = By.id("one-way-raspFormFromTitle");
    private final By TO_STATION_FIELD = By.id("one-way-raspFormToTitle");
    private final By DATE_FIELD = By.xpath("//div[@class='collapse in']//div[@class='tab-pane fade in "
        + "active']//div[@class='rasp-form__inp input-group date']");
    private final By SUBMIT_BUTTON = By.xpath("//div[@class='collapse in']//div[@class='tab-pane fade in "
        + "active']//button[@class='btn btn-default "
        + "btn-submit js-input-taber']");

    public void setFromStationField(String fromStation)
    {
        $(FROM_STATION_FIELD).setValue(fromStation);
    }

    public void setToStationField(String toStation)
    {
        $(TO_STATION_FIELD).setValue(toStation);
    }

    public void clickDateField()
    {
        $(DATE_FIELD).click();
    }

    public void setDateField(Calendar calendar)
    {
        $x(getDataLocator(calendar)).click();
    }

    public void clickSubmitButton()
    {
        $(SUBMIT_BUTTON).click();
    }

    private String getDataLocator(Calendar calendar)
    {
        return "//td[@data-year = '" + calendar.get(1) + "'][@data-month = '" + calendar.get(2) +
            "']/a[text() = '" + calendar.get(5) + "']";
    }
}