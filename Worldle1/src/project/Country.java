package project;
/**
 * 
 */
public class Country
{
    private String name;
    private double latitude;
    private double longitude;

    /**
     * Constructor for objects of class Country
     */
    public Country(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @return the name of the country
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the latitude of the country
     */
    public double getLatitude()
    {
        return latitude;
    }

    /**
     * @return the longitude of the country
     */
    public double getLongitude()
    {
        return longitude;
    }
}
