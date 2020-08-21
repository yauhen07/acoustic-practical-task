package com.mycompany.filters;

import com.mycompany.pageobjects.ResultsPageOtherFilter;
import com.mycompany.pageobjects.ResultsPageTimeFilter;
import com.mycompany.pageobjects.ResultsPageTrainTypeFilter;

public class Filter
{
    private ResultsPageOtherFilter resultsPageOtherFilter;
    private ResultsPageTimeFilter resultsPageTimeFilter;
    private ResultsPageTrainTypeFilter resultsPageTrainTypeFilter;

    public Filter(ResultsPageOtherFilter resultsPageOtherFilter)
    {
        this.resultsPageOtherFilter = resultsPageOtherFilter;
    }

    public ResultsPageOtherFilter getResultsPageOtherFilter()
    {
        return resultsPageOtherFilter;
    }

    public void setResultsPageOtherFilter(ResultsPageOtherFilter resultsPageOtherFilter)
    {
        this.resultsPageOtherFilter = resultsPageOtherFilter;
    }

    public ResultsPageTimeFilter getResultsPageTimeFilter()
    {
        return resultsPageTimeFilter;
    }

    public void setResultsPageTimeFilter(ResultsPageTimeFilter resultsPageTimeFilter)
    {
        this.resultsPageTimeFilter = resultsPageTimeFilter;
    }

    public ResultsPageTrainTypeFilter getResultsPageTrainTypeFilter()
    {
        return resultsPageTrainTypeFilter;
    }

    public void setResultsPageTrainTypeFilter(ResultsPageTrainTypeFilter resultsPageTrainTypeFilter)
    {
        this.resultsPageTrainTypeFilter = resultsPageTrainTypeFilter;
    }
}
