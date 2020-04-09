package com.mycompany.utils;

import java.io.File;
import java.io.IOException;

public class StartGrid
{
    public static void startGrid()
    {
        try
        {
            Process process = Runtime.getRuntime().exec("cmd /c startGrid.bat", null, new File("C:\\data"
                + "\\projects\\acoustic-practical-task\\src\\test\\resources\\"));
            process.waitFor();

        }
        catch (
            IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
