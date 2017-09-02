/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Random;

/**
 *
 * @author Marquel
 */
public class GA {
    private Random randomGenerator;

    public GA() {
        this.randomGenerator = new Random();
    }

    public Population evolvePopulation(Population population) {
        Population newPopulation = new Population(population.size());
        
        for (int i = 0; i < population.size(); i++) {
            singleTour firstIndividual = randomSelection(population);
            singleTour secondIndividual = randomSelection(population);
            singleTour newIndividual = crossOver(firstIndividual, secondIndividual);
            newPopulation.saveIndividual(i, newIndividual);
        }
        
        for (int i = 0; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }
        return newPopulation;
    }

    private singleTour randomSelection(Population population) {
        Population newPopulation = new Population(Constants.TOURNAMENT_SIZE);
        
        for (int i = 0; i < Constants.TOURNAMENT_SIZE; i++) {
            int randomIndex = (int) (Math.random() * population.size());
            newPopulation.saveIndividual(i, population.getIndividual(randomIndex));
        }
        
        singleTour fittestIndividual = newPopulation.GetFittestIndividual();
        
        return fittestIndividual;
    }

    private singleTour crossOver(singleTour firstIndividual, singleTour secondIndividual) {
        singleTour newIndividual = new singleTour();
        
        int start = randomGenerator.nextInt(Constants.CROMOSOME_LENGTH); 
        int end = randomGenerator.nextInt(Constants.CROMOSOME_LENGTH);
        
        for(int i=0; i<Constants.CROMOSOME_LENGTH; i++){
            if(start<end && (i>start && i<end)){
                newIndividual.setCity(i, firstIndividual.getCity(i));
            } else if(start>end && !(i<start && i>end)){
                newIndividual.setCity(i, firstIndividual.getCity(i));
            }
        }
        
        for(int i = 0; i < Constants.CROMOSOME_LENGTH; i++){
            if(!newIndividual.haveCity(secondIndividual.getCity(i))){
                for(int j = 0; j < Constants.CROMOSOME_LENGTH; j++){
                    if(newIndividual.getCity(j) == null){
                        newIndividual.setCity(j, secondIndividual.getCity(i));
                        break;
                    }
                }
            }
        }     
        return newIndividual;
    }

    private void mutate(singleTour individual) {
        for(int i=1; i<Constants.CROMOSOME_LENGTH; i++){
            if(Math.random() <= Constants.MUTATION_RATE){
                int cityIndex = randomGenerator.nextInt(individual.getTourSize());
                if (cityIndex>0){
                City city1 = individual.getCity(i);
                City city2 = individual.getCity(cityIndex);
                individual.setCity(cityIndex, city1);
                individual.setCity(i, city2);
                }
            }
        }
    }
    
    
}
