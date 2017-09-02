/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.*;

/**
 *
 * @author Marquel
 */
public class Repository {
    private static List<City> cities = new ArrayList<>();
    
    public static void addCity(City city){
        cities.add(city);
    }
    
    public static City getCityAt(int index) {
        return cities.get(index);
    }
    
    public static int getCitiesCount() {
        return cities.size();
    }
}
