package com.mycompany.services;

import com.mycompany.pageobjects.RWResultsPage;
import com.mycompany.pageobjects.RWSearchPage;

import java.util.Calendar;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RWSearchOperations
{
    public static RWSearchPage rwSearchPage = open(RWSearchPage.SEARCH_URL, RWSearchPage.class);
    public static RWResultsPage rwResultsPage;

    @Step("Set '{fromStation}' value for 'Откуда' field, '{toStation}' value for 'Куда' field and click 'Найти' button")
    public static RWResultsPage search(String fromStation, String toStation, Calendar calendar)
    {
        rwSearchPage.setFromStationField(fromStation);
        rwSearchPage.setToStationField(toStation);
        rwSearchPage.clickDateField();
        rwSearchPage.setDateField(calendar);
        rwSearchPage.clickSubmitButton();
        rwResultsPage = page(RWResultsPage.class);
        return rwResultsPage;
    }
}
