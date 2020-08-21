package com.mycompany.builders;

import com.mycompany.filters.Filter;
import com.mycompany.pageobjects.ResultsPageOtherFilter;

public class FilterBuilder implements Builder
{
    ResultsPageOtherFilter resultsPageOtherFilter;

    @Override
    public void setOtherFilter(ResultsPageOtherFilter resultsPageOtherFilter)
    {
        this.resultsPageOtherFilter = resultsPageOtherFilter;
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
