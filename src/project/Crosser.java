package project;

/**
 * Interfejs reprezentujący operator krzyżowania genotypów.
 */
interface Crosser {
    /**
     * Wykonuje operację krzyżowania na parze genotypów.
     *
     * @param genotypePair para genotypów do skrzyżowania
     * @return para genotypów po skrzyżowaniu
     */
    GenotypePair crossingOperator(GenotypePair genotypePair);
}
