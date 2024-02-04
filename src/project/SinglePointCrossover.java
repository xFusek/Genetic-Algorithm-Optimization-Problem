package project;

/**
 * Operator krzyżowania jednopunktowego.
 */
class SinglePointCrossover implements Crosser {
    /**
     * Wykonuje operację krzyżowania jednopunktowego na parze genotypów.
     *
     * @param genotypePair para genotypów do krzyżowania
     * @return para genotypów po krzyżowaniu
     */
    @Override
    public GenotypePair crossingOperator(GenotypePair genotypePair) {
        String genotypeA = genotypePair.genotypeA();
        String genotypeB = genotypePair.genotypeB();
        int genotypeLength = genotypeA.length();

        int crossoverPoint = genotypeLength / 2;

        String newGenotypeA = genotypeA.substring(0, crossoverPoint) + genotypeB.substring(crossoverPoint);
        String newGenotypeB = genotypeB.substring(0, crossoverPoint) + genotypeA.substring(crossoverPoint);

        return new GenotypePair(newGenotypeA, newGenotypeB);
    }
}