# Genetic-Algorithm-Optimization-Problem

## Overview
This repository contains a genetic algorithm designed to solve an optimization problem related to finding the optimal configuration of coordinate pairs on a map. It includes mechanisms for individual representation, mutation, crossover, and population evolution, demonstrating the algorithm's effectiveness in addressing complex optimization challenges.

## Documentation
The project documentation and instructions are provided in Polish. Please refer to the [specyfikacja_projektu_v1.1.pdf](./specyfikacja%20projektu_v1.1.pdf) for a comprehensive explanation of the project's design and implementation details.
- [Project Specification (Polish)](./specyfikacja%20projektu_v1.1.pdf)
- [Jump to Polish Version](#sprawozdanie-algorytm-genetyczny-w-problemie-optymalizacyjnym)
## Authors
- [@tomekdot](https://github.com/tomekdot)
- [@xFusek](https://github.com/xFusek)

## Language
Please note that the project documentation and in-line comments are in Polish. For any questions or clarifications in English, feel free to open an issue.

---

## Report: Genetic Algorithm in Optimization Problem

### Introduction
Genetic algorithms are popular heuristic techniques used for solving optimization problems. They are based on evolutionary processes that mimic the mechanisms of biological evolution. Genetic algorithms are applicable in various fields such as engineering, economics, biology, and artificial intelligence. In our project, we focused on applying a genetic algorithm to solve an optimization problem that involves finding the optimal configuration for pairs of coordinates on a map.

### Development

#### Individual Representation
The method of representing an individual as a genotype in the study is performed using the `PopulationIndividual` class, which implements the `IIndividual` interface. This class stores information about the individual's identifier (id), genotype (genotype), and fitness value (fitnessValue). The genotype is stored as a string of characters, for example, "0101010110," where each character represents the value of one gene.

#### Mutation of an Individual
The mutation of an individual is carried out using the `BitFlipMutator` class, which implements the `Mutator` interface. In the Bit Flip mutation, an index in the genotype is randomly selected, and then the value at this index is inverted (if it is '0', it changes to '1', and if it is '1', it changes to '0'). The mutated genotype is then returned as the result of the mutation.

#### Crossover of Individuals
The crossover of two individuals is conducted in the `CGA` class. In the `generateNextPopulation()` method, two parent individuals from the population are randomly selected. Then, based on the crossover probability (crossProbability), it is decided whether to perform a crossover. If so, the `Crosser` operator is used to perform the crossover operation on the parents' genotypes. The `SinglePointCrossover` operator, which carries out a single-point crossover, is utilized by selecting a crossover point in the genotypes. Subsequently, based on the received genotypes of the offspring, new individuals (childA and childB) are created by cloning the parents. The progeny's genotypes are set to the genotypes obtained after crossing. Finally, the new individuals are added to the next population.

#### Results of the KAG Algorithm
The KAG (Canonical Genetic Algorithm) operates in a loop. In each iteration, the main step of the algorithm `doMainStep()`, which generates the next population based on the current population, is performed. Then, the stop condition is checked in the `isStopConditionSatisfied()` method, which determines whether the algorithm should be terminated. The stop condition is based on the maximum difference between the fitness values of individuals and the number of individuals that meet this condition. If the condition is met, the loop is terminated, and the algorithm concludes its operation.

#### Best Configuration Found
The best configuration found for the KAG algorithm is a population size of 100 individuals, a mutation operator with a probability of 0.01, and a crossover operator with a probability of 0.7. These values were experimentally determined and provided the best results for our optimization problem.

#### Best Solution Found
The best solution found is a set of genotype values that achieved the highest fitness score among all individuals. For our optimization problem, the best solution corresponded to the point with the highest value of the objective function.

### Conclusion
As part of our project, we conducted a study aimed at solving an optimization problem using a genetic algorithm. By using the appropriately selected configuration of the KAG algorithm, we were able to find increasingly better solutions in subsequent generations. The results and outcomes presented confirm the effectiveness of the genetic algorithm in solving optimization problems. The insights from our study may be beneficial for further research and the application of genetic algorithms to other optimization problems.

---

## Sprawozdanie: Algorytm Genetyczny w Problemie Optymalizacyjnym

### Wstęp
Algorytmy genetyczne są popularnymi technikami heurystycznymi wykorzystywanymi do rozwiązywania problemów optymalizacyjnych. Są one oparte na procesach ewolucyjnych, które naśladują mechanizmy ewolucji biologicznej. Algorytmy genetyczne znajdują zastosowanie w różnych dziedzinach, takich jak inżynieria, ekonomia, biologia czy sztuczna inteligencja.

### Rozwinięcie
#### Reprezentacja osobnika
Sposób reprezentacji osobnika jako genotyp w badaniu jest realizowany za pomocą klasy PopulationIndividual, która implementuje interfejs IIndividual. Klasa PopulationIndividual przechowuje informacje o identyfikatorze osobnika (id), genotypie (genotype) i wartości przystosowania (fitnessValue). Genotyp jest przechowywany jako ciąg znaków, np. "0101010110", gdzie każdy znak reprezentuje wartość jednego genu.

#### Mutacja osobnika
Mutacja osobnika jest realizowana za pomocą klasy BitFlipMutator, która implementuje interfejs Mutator. W przypadku mutacji typu Bit Flip, losowany jest indeks w genotypie, a następnie wartość tego indeksu jest odwracana (jeśli jest równa '0', zmienia się na '1', a jeśli jest równa '1', zmienia się na '0'). Na koniec, zmutowany genotyp jest zwracany jako wynik mutacji.

#### Krzyżowanie osobników
Krzyżowanie dwóch osobników jest realizowane w klasie CGA. W metodzie generateNextPopulation() losowane są dwa osobniki rodziców z populacji. Następnie, na podstawie prawdopodobieństwa krzyżowania (crossProbability), decyduje się, czy ma zostać wykonane krzyżowanie. Jeśli tak, wykorzystywany jest operator krzyżowania (Crosser) do wykonania operacji krzyżowania na genotypach rodziców. Wykorzystywany jest operator krzyżowania SinglePointCrossover, który realizuje krzyżowanie jednopunktowe (losuje się punkt przecięcia genotypów). Następnie, na podstawie otrzymanych genotypów potomków, tworzone są nowe osobniki (childA i childB) na podstawie klonowania rodziców. Genotypy potomków są ustawiane na otrzymane genotypy po krzyżowaniu. Na koniec, nowi osobnicy są dodawani do kolejnej populacji.

#### Najlepsze znalezione rozwiązanie:
Najlepsze znalezione rozwiązanie to zestaw wartości genotypu, które osiągnęły najwyższy wynik fitness wśród wszystkich osobników. Dla naszego problemu optymalizacyjnego, najlepsze znalezione rozwiązanie odpowiadało punktowi o najwyższej wartości funkcji celu.

#### Zakończenie:
W ramach naszego projektu przeprowadziliśmy badanie, którego celem było rozwiązanie problemu optymalizacyjnego przy użyciu algorytmu genetycznego. Wykorzystując odpowiednio dobraną konfigurację algorytmu KAG, udało nam się znaleźć coraz lepsze rozwiązania w kolejnych pokoleniach. Przedstawione wyniki i rezultaty potwierdzają skuteczność algorytmu genetycznego w rozwiązywaniu problemów optymalizacyjnych. Wnioski z przeprowadzonego badania mogą być pomocne przy dalszych badaniach i zastosowaniu algorytmów genetycznych w innych problemach optymalizacyjnych.


[//]: # (Jump back to the English version)
[Back to English Version](#report-genetic-algorithm-in-optimization-problem)

