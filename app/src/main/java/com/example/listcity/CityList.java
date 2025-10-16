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

    /** When given a city, return whether or not it belongs in the list. */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * If present remove it; otherwise throw.
     * @throws NoSuchElementException if the city is not in the list
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new NoSuchElementException("City not found: " + city.getCityName());
        }
    }

    /** Return how many cities are in the list. */
    public int countCities() {
        return cities.size();
    }
    }