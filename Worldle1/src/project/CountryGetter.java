package project;

import java.util.*;
import java.io.*;

/*
    * CountryGetter class to manage a list of countries.
 */
public class CountryGetter
{
    private Country[] countries = new Country[244];
    

    /**
     * Constructor for objects of class CountryGetter
     */
    public CountryGetter(String filepath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        int index = 0;
        while (line != null)
        {
            String[] parts = line.split(",");
            countries[index] = new Country(parts[3].substring(0, parts[3].length()-1).toLowerCase(),
            Double.parseDouble(parts[1]),
            Double.parseDouble(parts[2]),
            parts[0].substring(1));
            index++;
            line = reader.readLine();
        }
        reader.close();
    }

    /**
     * Returns a random country from the list of countries.
     * @return a random Country object
     */
    public Country getRandomCountry()
    {
        Random rand = new Random();
        return countries[rand.nextInt(countries.length)];
    }

    /**
     * Finds a country by its name.
     * @param name the name of the country to find
     * @return the Country object if found, null otherwise
     */
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
     * Returns the list of countries.
     * @return an array of Country objects
     */
    public Country[] getCountries()
    {
        return countries;
    }

    /**
     * Checks if a given country is valid.
     * @param country the Country object to check
     * @return true if the country is valid, false otherwise
     */
    public boolean isValidCountry(Country country)
    {
        for (Country c : countries)
        {
            if ((c).equals(country) && c!= null)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the country at a specific index.
     * @param index the index of the country to retrieve
     * @return the Country object at the specified index
     */
    public Country get(int index)
    {
        return countries[index];
    }
}
