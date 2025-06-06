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
     * 
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
        return this.getName().equalsIgnoreCase(other.getName());
    }

    /**
     * @return a string representation of the country
     */
    public String toString()
    {
        return "Country: " + name + ", Latitude: " + latitude + ", Longitude: " + longitude + ", Code: " + code;
    }

    public int getDistance(Country other)
    {
        double lat1 = this.getLatitude();
        double lon1 = this.getLongitude();
        double lat2 = other.getLatitude();
        double lon2 = other.getLongitude();
        final int R = 6371; // Radius of the Earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return (int) (R * c);
    }

    /**
     * @return the direction from this country to another country
     * from this country to another country
     */
    public String getDirection(Country other)
    {
        double lat1 = this.getLatitude();
        double lon1 = this.getLongitude();
        double lat2 = other.getLatitude();
        double lon2 = other.getLongitude();
        String latDir = (lat2 > lat1) ? "N" : "S";
        String lonDir = (lon2 > lon1) ? "E" : "W";
        return latDir + lonDir;
    }
}
