package com.mycompany.pageobjects;

import org.openqa.selenium.By;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class RWResultsRouteSelectorPage extends AbstractPage
{
    private final By RADIO_BUTTON_DIRECTIONS = By.xpath("//li[@class = 'rasp-filter__radio active']//*[text() = 'В "
        + "одну сторону']");

    @Step("Verify 'В одну сторону' radio button selected by default")
    public void radioButtonDefault()
    {
        $(RADIO_BUTTON_DIRECTIONS).should(exist);
    }
}
