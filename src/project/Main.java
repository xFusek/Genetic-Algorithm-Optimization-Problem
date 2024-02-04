/**
 * ====================================================================
 * @author: Wykonali: Tomasz Kaczak, Evelina Bolshakova, Przemysław Fusiarz
 * Grupowy projekt zaliczeniowy - Sztuczna inteligencja
 * ====================================================================
 */

package project;

import java.util.*;

/**
 * Klasa główna programu, która zawiera metodę `main()`.
 */
public class Main {
    /**
     * Metoda główna programu.
     *
     * @param args argumenty wiersza poleceń
     */
    public static void main(String[] args) {
        // Konfiguracja parametrów
        int populationSize = 100;
        int maxIterations = 1000;
        double mutationProbability = 0.1;
        double crossProbability = 0.7;
        double maxDifference = 1e-6;
        int individualsCount = 100;

        // Tworzenie początkowej populacji
        IIndividual[] initialPopulation = new IIndividual[populationSize];
        for (int i = 0; i < populationSize; i++) {
            String genotype = generateRandomGenotype();
            initialPopulation[i] = new PopulationIndividual(i, genotype);
        }

        // Inicjalizacja operatorów
        Mutator mutationOperator = new BitFlipMutator();
        Crosser crossingOperator = new SinglePointCrossover();

        // Tworzenie obiektu CGA
        CGA cga = new CGA(initialPopulation, populationSize, mutationOperator, crossingOperator,
                mutationProbability, crossProbability);

        // Główna pętla CGA
        for (int i = 0; i < maxIterations; i++) {
            cga.doMainStep();
            if (cga.isStopConditionSatisfied(maxDifference, individualsCount)) {
                break;
            }
        }

        // Pobieranie najlepszych osobników
        IIndividual[] bestIndividuals = cga.findBest(individualsCount);

        // Wyświetlanie wyników
        System.out.println("=======================================================");
        for (IIndividual individual : bestIndividuals) {
            System.out.println("=======================================================");
            int x = Integer.parseInt(individual.getGenotype().substring(0, 10), 2);
            int y = Integer.parseInt(individual.getGenotype().substring(10), 2);
            System.out.println("Best individual: (" + x + ", " + y + ")");
            System.out.println("Fitness value: " + individual.getFitnessValue());

            // Obliczanie wartości współczynników dla najlepszego osobnika
            double[] coefficients = calculateCoefficients(individual);
            System.out.println("Coefficients: " + Arrays.toString(coefficients));
            System.out.println("=======================================================");
        }
        System.out.println("=======================================================");
    }

    /**
     * Generuje losowy genotyp.
     *
     * @return wygenerowany genotyp
     */
    private static String generateRandomGenotype() {
        Random random = new Random();
        StringBuilder genotype = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            int bit = random.nextInt(2);
            genotype.append(bit);
        }

        return genotype.toString();
    }

    /**
     * Oblicza wartości współczynników na podstawie genotypu osobnika.
     *
     * @param individual osobnik
     * @return wartości współczynników
     */
    private static double[] calculateCoefficients(IIndividual individual) {
        double[] calculatedCoefficients = new double[individual.getGenotype().length()];
        String genotype = individual.getGenotype();
        for (int i = 0; i < genotype.length(); i++) {
            int geneValue = Integer.parseInt(genotype.substring(i, i + 1));
            double coefficient = geneValue * 0.1; // Przykładowa funkcja konwersji
            calculatedCoefficients[i] = coefficient;
        }

        return calculatedCoefficients;
    }
}
