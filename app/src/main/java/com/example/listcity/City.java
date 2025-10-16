package com.example.listcity;


/**
 * This is a class that defines a City.
 */
public class City  implements Comparable<City>{
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    String getCityName(){
        return this.city;
    }
    String getProvinceName(){
        return this.province;
    }

    /**
     *
     * @param o the object to be compared.
     * @return 0, 1< or >1 if two values are equal. a<b or a>b
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}