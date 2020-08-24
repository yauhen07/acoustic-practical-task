package com.mycompany.builders;

import com.mycompany.pageobjects.ResultsPageOtherFilter;

public interface Builder
{
    void setOtherFilter(ResultsPageOtherFilter withSits, ResultsPageOtherFilter eRegistration,
                        ResultsPageOtherFilter placesForWheelchairUsers);

    void setTrainFilter();

    void setTimeFilter();
}
