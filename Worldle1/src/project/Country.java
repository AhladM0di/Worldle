package project;



/**
 * 
 */
public class Country
{
    private String name;
    private double latitude;
    private double longitude;
    private String code;

    /**
     * Constructor for objects of class Country
     */
    public Country(String name, double latitude , double longitude, String code)
    {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.code = code;
    }

    public Country(String name)
    {
        this.name = name;
    }
    
    /**
     * @return the name of the country
     */
    public String getName()
    {
        return name.toLowerCase();
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

    /**
     * @return the code of the country
     */
    public String getCode()
    {
        return code.toLowerCase();
    }

    /**
     * @return a string representation of the country
     */
    public boolean equals(Country other)
    {
        return this.name.equalsIgnoreCase(other.name);
    }

    /**
     * @return a string representation of the country
     */
    public String toString()
    {
        return "Country: " + name + ", Latitude: " + latitude + ", Longitude: " + longitude + ", Code: " + code;
    }
}
