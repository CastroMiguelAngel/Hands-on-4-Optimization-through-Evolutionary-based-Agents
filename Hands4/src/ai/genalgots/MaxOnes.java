package ai.genalgots;

public class MaxOnes {

    public static void main(String[] args) {
        int populationSize = 30;
        double mutationRate = 0.001;
        double crossoverRate = 0.95;
        int elitismCount = 0;
        int chromosomeLength = 10;
        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize, mutationRate, crossoverRate, elitismCount);
        Population population = ga.initPopulation(chromosomeLength);
        int generation = 1;

        ga.evalPopulation(population);
        
        int populationSize1 = 30;
        double mutationRate1 = 0.001;
        double crossoverRate1 = 0.95;
        int elitismCount1 = 0;
        int chromosomeLength1 = 10;
        GeneticAlgorithm ga1 = new GeneticAlgorithm(populationSize1, mutationRate1, crossoverRate1, elitismCount1);
        Population population1 = ga1.initPopulation(chromosomeLength1);
        int generation1 = 1;

        ga1.evalPopulation(population1);

        while (!ga.isTerminationConditionMet(population)) {
        	
            printGenerationData(generation, population);
            
            population = ga.crossoverPopulation(population);

            population = ga.mutatePopulation(population);

            ga.evalPopulation(population);

            generation++;
            
            printGenerationData(generation1, population1);
            
            population1 = ga1.crossoverPopulation(population1);

            population1 = ga1.mutatePopulation(population1);

            ga1.evalPopulation(population1);

            generation1++;
            if(ga1.isTerminationConditionMet(population1))
        	{
        		break;
        	}
        }

        printGenerationData(generation, population);
        printGenerationData(generation1, population1);
        
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(" ");

        System.out.println("Found solution in " + generation1 + " generations B1");
        System.out.println("Best solution: " + population1.getFittest(0).toString());
        System.out.println("Found solution in " + generation + " generations B0");
        System.out.println("Best solution: " + population.getFittest(0).toString());
    }

    public static void printGenerationData(int generation, Population population) {
        double populationFitness = population.getPopulationFitness();
        System.out.println("Generation:" + generation);
        System.out.println("Population fitness: " + populationFitness);

        System.out.println("Chromosomes:");
        for(Individual individual : population.getIndividuals()) {
            double individualFitness = individual.getFitness();
            double proportionateFitness = (individualFitness * 100) / populationFitness;
            System.out.println(individual.toString() + " | Fitness: " + individual.getFitness()  + " | Proportionate fitness value: " + proportionateFitness + "%");
        }       
        
        System.out.println();
    }
}
