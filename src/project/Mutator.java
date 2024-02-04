package project;

/**
 * Interfejs definiujący operację mutacji genotypu.
 */
interface Mutator {
    /**
     * Mutuje podany genotyp.
     *
     * @param genotype       genotyp do mutacji
     * @param genotypeLength długość genotypu
     * @return zmutowany genotyp
     */
    String mutator(String genotype, int genotypeLength);
}

