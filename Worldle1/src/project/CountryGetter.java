package project;

import java.util.*;
import java.io.*;

/*
 * 
 */
public class CountryGetter
{
    private List<Country> countries = new ArrayList<>();
    

    /**
     * Constructor for objects of class CountryGetter
     */
    public CountryGetter(String filepath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        while (line != null)
        {
            String[] parts = line.split(",");
            countries.add(new Country(parts[1],
            Double.parseDouble(parts[2]),
            Double.parseDouble(parts[3]),
            parts[4]));
            line = reader.readLine();
        }
        reader.close();
    }

    /**
     * @return a random country from the list
     */
    public Country getRandomCountry()
    {
        Random rand = new Random();
        return countries.get(rand.nextInt(countries.size()));
    }

     public Country findCountryByName(String name)
     {
        for (Country c : countries) {
            if ((c.getName().toLowerCase()).equals(name.toLowerCase()))
            {
                return c;
            }
        }
        return null;
    }

    /**
     * @return the list of countries
     */
    public List<Country> getCountries()
    {
        return countries;
    }

    /**
     * @return boolean indicating if the country is valid
     */
    public boolean isValidCountry(Country country)
    {
        for (Country c : countries)
        {
            if ((c.getName().toLowerCase()).equals(country.getName().toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }
}
