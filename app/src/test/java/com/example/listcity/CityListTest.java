package com.example.listcity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1,cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));

    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    // --- helpers ---
    private CityList emptyList() {
        return new CityList();
    }

    private City edmonton() {
        return new City("Edmonton", "Alberta");
    }

    private City calgary() {
        return new City("Calgary", "Alberta");
    }

    // ----------------------------
    // hasCity(City city) Test
    // ----------------------------

    /** returns true when the SAME instance is in the list */
    @Test
    void testHasCityTrue_SameInstance() {
        CityList list = emptyList();
        City e = edmonton();
        list.add(e);
        assertTrue(list.hasCity(e));
    }

    /** returns false for a DIFFERENT instance with same field values (since City has no equals/hashCode) */
    @Test
    void testHasCityFalse_DifferentInstanceSameValues() {
        CityList list = emptyList();
        City e = edmonton();
        list.add(e);
        assertFalse(list.hasCity(new City("Edmonton", "Alberta")));
    }

    // ----------------------------
    // delete(City city) Test
    // ----------------------------

    /** deleting the SAME instance removes it */
    @Test
    void testDeleteRemovesCity_SameInstance() {
        CityList list = emptyList();
        City e = edmonton();
        list.add(e);

        list.delete(e);

        assertFalse(list.hasCity(e));
        assertEquals(0, list.countCities());
    }

    /** deleting a city that is not present should throw (any exception type per spec) */
    @Test
    void testDeleteThrowsWhenMissing() {
        CityList list = emptyList();
        // Expect some exception type (e.g., IllegalArgumentException or NoSuchElementException)
        assertThrows(Exception.class, () -> list.delete(edmonton()));
    }

    /** deleting a DIFFERENT instance with same values should throw (not the same object) */
    @Test
    void testDeleteThrows_DifferentInstanceSameValues() {
        CityList list = emptyList();
        City e = edmonton();
        list.add(e);

        // Not the same reference — should be treated as "missing"
        assertThrows(Exception.class, () -> list.delete(new City("Edmonton", "Alberta")));
        // Still intact
        assertTrue(list.hasCity(e));
        assertEquals(1, list.countCities());
    }

    // ----------------------------
    // countCities() Test
    // ----------------------------

    @Test
    void testCountCitiesEmptyList() {
        CityList list = emptyList();
        assertEquals(0, list.countCities());
    }

    @Test
    void testCountCitiesAfterAddsAndDelete() {
        CityList list = emptyList();

        City e = edmonton();
        City c = calgary();

        list.add(e);
        assertEquals(1, list.countCities());

        list.add(c);
        assertEquals(2, list.countCities());

        list.delete(e);
        assertEquals(1, list.countCities());
        assertTrue(list.hasCity(c));
    }
}