package project;

/**
 * Klasa reprezentująca parę genotypów.
 */
record GenotypePair(String genotypeA, String genotypeB) {
    /**
     * Tworzy parę genotypów.
     *
     * @param genotypeA genotyp A
     * @param genotypeB genotyp B
     */
    public GenotypePair(String genotypeA, String genotypeB) {
        this.genotypeA = genotypeA;
        this.genotypeB = genotypeB;
    }

    /**
     * Zwraca genotyp A.
     *
     * @return genotyp A
     */
    public String genotypeA() {
        return genotypeA;
    }

    /**
     * Zwraca genotyp B.
     *
     * @return genotyp B
     */
    public String genotypeB() {
        return genotypeB;
    }
}
