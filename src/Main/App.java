/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;

/**
 *
 * @author Marquel
 */
public class App {
    public static void template(){
        City city = new City(82,76);
        Repository.addCity(city);
        
        city = new City(96,44);
        Repository.addCity(city);
        
        city = new City(50,5);
        Repository.addCity(city);
        
        city = new City(49,8);
        Repository.addCity(city);
        
        city = new City(13,7);
        Repository.addCity(city);
        
        city = new City(29,89);
        Repository.addCity(city);
        
        city = new City(58,30);
        Repository.addCity(city);
        
        city = new City(84,39);
        Repository.addCity(city);
        
        city = new City(14,24);
        Repository.addCity(city);
        
        city = new City(2,39);
        Repository.addCity(city);
        
        city = new City(3,82);
        Repository.addCity(city);
        
        city = new City(5,10);
        Repository.addCity(city);
        
        city = new City(98,52);
        Repository.addCity(city);
        
        city = new City(84,25);
        Repository.addCity(city);
        
        city = new City(61,59);
        Repository.addCity(city);
        
        city = new City(1,65);
        Repository.addCity(city);
        
    }
    
    public static void main(String[] args) {
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        String pil;
        int totalData, x, y;
        City inputCity;
        
        System.out.println("Add data manual? (y/n)");
        pil = scString.nextLine();
        
        if ("y".equals(pil)) {
            System.out.print("Total data: ");
            totalData = scInt.nextInt();
            
            for (int i = 0; i < totalData; i++) {
                System.out.print("Koordinat x:");
                x = scInt.nextInt();
                System.out.print("Koordinat y:");
                y = scInt.nextInt();
                inputCity = new City(x, y);
                Repository.addCity(inputCity);
            }
        } else {
            template();
        }
        
        
        Population population = new Population(500);
        population.initialize();
        
        GA geneticAlgorithms = new GA();
        population = geneticAlgorithms.evolvePopulation(population);
        int i;
        for (i = 0; i < 500; i++) {
            population = geneticAlgorithms.evolvePopulation(population);
        }
        
        System.out.println("Generation: "+i);
        System.out.println(population.GetFittestIndividual().toString());
    }
}
