/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Marquel
 */
public class Population {
    private singleTour[] individuals;
    
    public Population(int populationSize) {
        individuals = new singleTour[populationSize];
    }
    
    public void initialize(){
        for(int i=0; i<individuals.length; i++){
            singleTour newIndividual = new singleTour(); 
            newIndividual.generateIndividual();
            saveIndividual(i, newIndividual);
        }
    }
    
    public singleTour getIndividual(int index) {
        return this.individuals[index];
    }
    
    public singleTour GetFittestIndividual(){
        singleTour fittest = individuals[0];
        
        for(int i=1;i<individuals.length; i++){
            if(getIndividual(i).getFitness() > fittest.getFitness()){
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }
    
    public int size(){
        return this.individuals.length;
    }
    
    public void saveIndividual(int index, singleTour individual){
        this.individuals[index] = individual;
    }

    public singleTour[] getIndividuals() {
        return individuals;
    }
}
