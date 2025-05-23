package project;

import java.util.*;
import java.io.*;

/*
 * 
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
     * @return a random country from the list
     */
    public Country getRandomCountry()
    {
        Random rand = new Random();
        return countries[rand.nextInt(countries.length)];
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
    public Country[] getCountries()
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
            System.out.println(c.getName());
            if ((c).equals(country) && c!= null)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * @return boolean indicating if the country is valid
     */
    public Country get(int index)
    {
        return countries[index];
    }
}
