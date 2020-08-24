package com.mycompany.filters;

import com.mycompany.pageobjects.ResultsPageOtherFilter;
import com.mycompany.pageobjects.ResultsPageTimeFilter;
import com.mycompany.pageobjects.ResultsPageTrainTypeFilter;

import java.util.ArrayList;
import java.util.List;

public class Filter
{
    private List<ResultsPageOtherFilter> resultsPageOtherFilter;
    private ResultsPageTimeFilter resultsPageTimeFilter;
    private ResultsPageTrainTypeFilter resultsPageTrainTypeFilter;

    public Filter(List<ResultsPageOtherFilter> resultsPageOtherFilter)
    {
        this.resultsPageOtherFilter = (resultsPageOtherFilter);
    }

    public List<ResultsPageOtherFilter> getResultsPageOtherFilter()
    {
        return resultsPageOtherFilter;
    }

    public void setResultsPageOtherFilter(List<ResultsPageOtherFilter> resultsPageOtherFilter)
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
