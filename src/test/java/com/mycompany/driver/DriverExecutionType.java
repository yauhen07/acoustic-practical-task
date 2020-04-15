package com.mycompany.driver;

public enum DriverExecutionType
{
    REMOTE("REMOTE"),
    LOCAL("LOCAL");

    private String executionType;

    DriverExecutionType(String executionType)
    {
        this.executionType = executionType;
    }

    public String getExecutionType()
    {
        return executionType;
    }
}