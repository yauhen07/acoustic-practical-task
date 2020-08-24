package com.mycompany.builders;

import com.mycompany.pageobjects.ResultsPageOtherFilter;

public class Director
{
    public void constructFilterWithFreeSeatsAndER(Builder builder)
    {
        builder.setOtherFilter(ResultsPageOtherFilter.WITH_FREE_SITS, ResultsPageOtherFilter.E_REGISTRATION, null);
    }

    public void constructFilterWithFreeSeatsAndWheelchairUsers(Builder builder)
    {
        builder.setOtherFilter(ResultsPageOtherFilter.WITH_FREE_SITS, null, ResultsPageOtherFilter.PLACES_FOR_WHEELCHAIR_USERS);
    }
}
