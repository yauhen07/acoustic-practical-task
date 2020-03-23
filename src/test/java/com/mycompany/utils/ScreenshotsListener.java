package com.mycompany.utils;

import com.codeborne.selenide.Selenide;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshotsListener extends TestListenerAdapter
{
    @Override
    public void onTestFailure(ITestResult result)
    {
        if (!result.isSuccess())
        {
            Selenide.screenshot("" + System.nanoTime());
        }
    }
}
