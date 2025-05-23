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
    
    @Test
    public void testget()
    {
        setUp();
        Country country = countryGetter.getCountries()[0];
        assertEquals("andorra", country.getName());
        assertEquals(42.54625, country.getLatitude(), 0.01);
        assertEquals(1.6, country.getLongitude(), 0.01);
        assertEquals("ad", country.getCode());
    }
}
