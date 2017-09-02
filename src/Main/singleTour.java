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
public class singleTour {
    private ArrayList<City> tour = new ArrayList<>();
    private double distance = 0;
    private double fitness = 0;
    
    public singleTour(){
        for(int i=0; i<Repository.getCitiesCount(); i++){
            tour.add(null);
        }
    }
    
    public singleTour(ArrayList<City> tour){
        this.tour = tour;
    }
    
    public ArrayList<City> getTour() {
        return this.tour;
    }
    
    public void generateIndividual(){
        for(int cityIndex = 0; cityIndex < Repository.getCitiesCount(); cityIndex++){
            setCity(cityIndex, Repository.getCityAt(cityIndex));
        }
        Collections.shuffle(tour);
//        City city = getCity(0);
//        tour.remove(0);
//        Collections.shuffle(tour);
//        tour.add(0, city);
    }

    public void setCity(int cityIndex, City city) {
        this.tour.set(cityIndex, city);
        this.distance = 0;
    }    

    public City getCity(int tourPosition) {
        return tour.get(tourPosition);
    }
    
    public int getTourSize() {
        return this.tour.size();
    }
    
    public double getDistance() {
        if (this.distance == 0) {
            int tourDistance = 0;
            
            for (int cityIndex = 0; cityIndex < getTourSize(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;
                
                if (cityIndex+1 < getTourSize()) {
                    destinationCity = getCity(cityIndex);
                }else {
                    destinationCity = getCity(0);
                }
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            this.distance = tourDistance;
        }
        
        return this.distance;
    }
    
    public double getFitness() {
        double jarak = getDistance();
        if (this.fitness == 0) {
            this.fitness = 1/jarak;
        }
        return this.fitness;
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < getTourSize(); i++) {
            s += getCity(i) +  "->";
        }
        s += "\nJarak: " + this.distance;
        return s;
    }

    public boolean haveCity(City city) {
        return tour.contains(city);
    }
}
