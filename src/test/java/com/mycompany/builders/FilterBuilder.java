package com.mycompany.builders;

import com.mycompany.filters.Filter;
import com.mycompany.pageobjects.ResultsPageOtherFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterBuilder implements Builder
{
    //    ResultsPageOtherFilter resultsPageOtherFilter;
    private List<ResultsPageOtherFilter> resultsPageOtherFilter;

    @Override
    public void setOtherFilter(ResultsPageOtherFilter withSits, ResultsPageOtherFilter eRegistration,
                               ResultsPageOtherFilter placesForWheelchairUsers)
    {
        this.resultsPageOtherFilter = Arrays.asList(withSits, eRegistration, placesForWheelchairUsers);
    }

    @Override
    public void setTrainFilter()
    {

    }

    @Override
    public void setTimeFilter()
    {

    }

    public Filter getResult()
    {
        return new Filter(resultsPageOtherFilter);
    }
}
