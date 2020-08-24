package com.mycompany.pageobjects;

public enum ResultsPageOtherFilter
{
    WITH_FREE_SITS("С наличием свободных мест", "//span[@data-filter-value = 'w_places']/../div", "//div[@class = 'sch-table__t-name']"),
    E_REGISTRATION("Электронная регистрация", "//span[@data-filter-value = 'eregistration']/../div", "//i[@class= 'svg-tag-er']/../../../../.."),
    PLACES_FOR_WHEELCHAIR_USERS("Места для инвалидов-колясочников", "//span[@data-filter-value = 'special']/../div", "//i[@class= 'svg-tag-special']/../../../../..");

    private final String otherFilterLocator;
    public String ruName;
    public String tagLocator;

    ResultsPageOtherFilter(String ruName, String otherFilterLocator, String tagLocator)
    {
        this.ruName = ruName;
        this.otherFilterLocator = otherFilterLocator;
        this.tagLocator = tagLocator;
    }

    public String getOtherFilterLocator()
    {
        return otherFilterLocator;
    }

    public String getTagLocator()
    {
        return tagLocator;
    }
}
