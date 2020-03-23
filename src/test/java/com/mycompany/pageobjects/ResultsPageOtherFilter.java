package com.mycompany.pageobjects;

public enum ResultsPageOtherFilter
{
    WITH_FREE_SITS("С наличием свободных мест", "//span[@data-filter-value = 'w_places']"),
    E_REGISTRATION("Электронная регистрация", "//span[@data-filter-value = 'eregistration']"),
    PLACES_FOR_WHEELCHAIR_USERS("Места для инвалидов-колясочников", "//span[@data-filter-value = 'special']");

    public String ruName;
    private String otherFilterLocator;

    ResultsPageOtherFilter(String ruName, String otherFilterLocator)
    {
        this.ruName = ruName;
        this.otherFilterLocator = otherFilterLocator;
    }

    public String getOtherFilterLocator()
    {
        return otherFilterLocator;
    }
}
