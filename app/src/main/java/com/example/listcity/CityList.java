package com.example.listcity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does    not exist
     * @param city
     *      This is a candidate city to add
     * @throws IllegalArgumentException if the city already there
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks whether a given city exists in the list.
     * @param city
     *      The city to check for in the list
     * @return
     *      True if the city exists in the list, otherwise false
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }


    /**
     * This deletes a city from the list if it exists.
     * @param city
     *      The city to remove from the list
     * @throws NoSuchElementException
     *      If the city is not found in the list
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new NoSuchElementException("City not found: " + city.getCityName());
        }
    }

    /**
     * This returns the total number of cities in the list.
     * @return
     *      The number of cities currently stored in the list
     */
    public int countCities() {
        return cities.size();
    }
    }