package com.mycompany.tests;

import com.mycompany.filters.Filter;
import com.mycompany.services.RWOperations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class VerifyFiltersOnSearchResultPageTest extends BaseTest
{
    private final String FROM_STATION = "Минск-Пассажирский";
    private final String TO_STATION = "Молодечно";
    private final GregorianCalendar DATE = new GregorianCalendar(2020, Calendar.AUGUST, 30);
    private RWOperations rwOperations;


    @BeforeTest
    private void createFilterObjects()
    {
        director.constructFilterWithFreeSeats(builder);
        listAllVariantsOfFilters.add(builder.getResult());
    }

    @DataProvider(name = "Data-Provider-Filters")
    public Iterator<Object> filters()
    {
                return listAllVariantsOfFilters.iterator();
    }

    @Test(dataProvider = "Data-Provider-Filters")
    public void verifyFilters(Filter filter)
    {
        rwOperations = new RWOperations();
        rwOperations.openSearchPage();
        rwOperations.search(FROM_STATION, TO_STATION, DATE);
        rwOperations.verifyOtherFilterResults(filter);
    }
}
