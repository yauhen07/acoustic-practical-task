package com.mycompany.builders;

import com.mycompany.pageobjects.ResultsPageOtherFilter;

public class Director
{
    public void constructFilterWithFreeSeats (Builder builder){
        builder.setOtherFilter(ResultsPageOtherFilter.PLACES_FOR_WHEELCHAIR_USERS);
    }

    public void constructFilterWithER(Builder builder){
        builder.setOtherFilter(ResultsPageOtherFilter.E_REGISTRATION);
    }
}
