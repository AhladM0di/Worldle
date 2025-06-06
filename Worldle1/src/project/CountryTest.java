package project;
import static org.junit.Assert.*;
import org.junit.Test;
public class CountryTest
{
    @Test
    public void testCountryCreation()
    {
        Country c = new Country("India");
        assertEquals("india", c.getName());
    }

    @Test
    public void testCountryCreationWithCoordinates()
    {
        Country c = new Country("India", 20.5937, 78.9629, "IN");
        assertEquals("india", c.getName());
        assertEquals(20.5937, c.getLatitude(), 0.0001);
        assertEquals(78.9629, c.getLongitude(), 0.0001);
        assertEquals("in", c.getCode());
    }

    @Test
    public void testgetDirection()
    {
        Country c1 = new Country("India", 20.5937, 78.9629, "IN");
        Country c2 = new Country("Australia", -25.2744, 133.7751, "AU");
        assertEquals("SE", c1.getDirection(c2));
    }
}
