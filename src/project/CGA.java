package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Klasa reprezentująca algorytm genetyczny (CGA - Canonical Genetic Algorithm).
 */
class CGA {
    private IIndividual[] population;
    private final int populationSize;
    private final Mutator mutationOperator;
    private final Crosser crossingOperator;
    private final double mutationProbability;
    private final double crossProbability;
    private final Random random;

    /**
     * Konstruktor klasy CGA.
     *
     * @param initialPopulation  początkowa populacja
     * @param populationSize     rozmiar populacji
     * @param mutationOperator   operator mutacji
     * @param crossingOperator   operator krzyżowania
     * @param mutationProbability   prawdopodobieństwo mutacji
     * @param crossProbability   prawdopodobieństwo krzyżowania
     */
    public CGA(IIndividual[] initialPopulation, int populationSize, Mutator mutationOperator,
               Crosser crossingOperator, double mutationProbability, double crossProbability) {
        this.population = initialPopulation;
        this.populationSize = populationSize;
        this.mutationOperator = mutationOperator;
        this.crossingOperator = crossingOperator;
        this.mutationProbability = mutationProbability;
        this.crossProbability = crossProbability;
        this.random = new Random();
    }

    /**
     * Generuje następną populację na podstawie obecnej populacji.
     */
    public void generateNextPopulation() {
        List<IIndividual> nextPopulation = new ArrayList<>();

        while (nextPopulation.size() < populationSize) {
            IIndividual parentA = drawNextIndividualRoulette();
            IIndividual parentB = drawNextIndividualRoulette();

            if (random.nextDouble() < crossProbability) {
                GenotypePair genotypePair = crossingOperator.crossingOperator
                        (new GenotypePair(parentA.getGenotype(), parentB.getGenotype()));
                IIndividual childA = parentA.cloneIndividual();
                IIndividual childB = parentB.cloneIndividual();
                childA.setGenotype(genotypePair.genotypeA());
                childB.setGenotype(genotypePair.genotypeB());
                nextPopulation.add(childA);
                nextPopulation.add(childB);
            } else {
                nextPopulation.add(parentA.cloneIndividual());
                nextPopulation.add(parentB.cloneIndividual());
            }
        }

        for (IIndividual individual : nextPopulation) {
            if (random.nextDouble() < mutationProbability) {
                String mutatedGenotype = mutationOperator.mutator
                        (individual.getGenotype(), individual.getGenotypeLength());
                individual.setGenotype(mutatedGenotype);
            }
        }

        population = Tool.castListToArray(nextPopulation);
        Arrays.sort(population, IIndividual.compare);
    }

    /**
     * Wykonuje główny krok algorytmu CGA.
     */
    public void doMainStep() {
        generateNextPopulation();
    }

    /**
     * Zwraca obecną populację.
     *
     * @return obecna populacja
     */
    public IIndividual[] getPopulation() {
        return population;
    }

    /**
     * Znajduje najlepsze osobniki w populacji.
     *
     * @param count liczba najlepszych osobników do znalezienia
     * @return tablica najlepszych osobników
     */
    public IIndividual[] findBest(int count) {
        if (count > populationSize) {
            count = populationSize;
        }

        return Arrays.copyOfRange(population, 0, count);
    }

    /**
     * Sprawdza, czy warunek zatrzymania algorytmu jest spełniony.
     *
     * @param maxDifference różnica maksymalna między wartościami fitness
     * @param individualsCount liczba osobników spełniających warunek
     * @return true, jeśli warunek zatrzymania jest spełniony, w przeciwnym razie false
     */
    public boolean isStopConditionSatisfied(double maxDifference, int individualsCount) {
        int conditionSatisfiedCount = numberOfIndividualsConditionSatisfied(maxDifference);
        return conditionSatisfiedCount >= individualsCount;
    }

    /**
     * Zlicza liczbę osobników, które spełniają warunek różnicy fitness.
     *
     * @param maxDifference różnica maksymalna między wartościami fitness
     * @return liczba osobników spełniających warunek
     */
    private int numberOfIndividualsConditionSatisfied(double maxDifference) {
        int count = 0;
        double bestFitnessValue = population[0].getFitnessValue();
        for (IIndividual individual : population) {
            if (Math.abs(individual.getFitnessValue() - bestFitnessValue) <= maxDifference) {
                count++;
            }
        }
        return count;
    }

    /**
     * Losuje kolejnego osobnika z populacji na podstawie proporcjonalnego ruletkowego doboru.
     *
     * @return wylosowany osobnik
     */
    private IIndividual drawNextIndividualRoulette() {
        double fitnessSum = 0;
        for (IIndividual individual : population) {
            fitnessSum += individual.getFitnessValue();
        }

        double randomValue = random.nextDouble() * fitnessSum;
        double partialSum = 0;
        for (IIndividual individual : population) {
            partialSum += individual.getFitnessValue();
            if (partialSum >= randomValue) {
                return individual;
            }
        }

        return population[population.length - 1];
    }
}
