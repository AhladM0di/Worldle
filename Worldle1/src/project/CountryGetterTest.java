package project;
import static org.junit.Assert.*;
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
    public void testGetRandomCountry()
    {
        Country randomCountry = countryGetter.getRandomCountry();
        assertNotNull("Random country should not be null", randomCountry);
        assertNotNull("Country name should not be null", randomCountry.getName());
        assertNotNull("Country code should not be null", randomCountry.getCode());
    }

}
