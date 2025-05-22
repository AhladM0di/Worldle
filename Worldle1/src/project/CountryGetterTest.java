package project;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;
public class CountryGetterTest
{
    /*
     * 
     */
    private CountryGetter countryGetter;

    public void setUp()
    {
        try
        {
            countryGetter = new CountryGetter("/Users/ahladmodi/Documents/Virginia Tech/Personal/countryNames.csv");
        }
        catch (IOException e)
        {
            fail("Failed to initialize CountryGetter: " + e.getMessage());
        }
    }
}
