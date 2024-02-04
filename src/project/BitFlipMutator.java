package project;

import java.util.Random;

/**
 * Klasa implementująca operator mutacji typu Bit Flip.
 */
class BitFlipMutator implements Mutator {
    /**
     * Wykonuje operację mutacji na genotypie poprzez odwrócenie wartości jednego losowego bitu.
     *
     * @param genotype       genotyp przed mutacją
     * @param genotypeLength długość genotypu
     * @return zmutowany genotyp
     */
    @Override
    public String mutator(String genotype, int genotypeLength) {
        Random random = new Random();
        int index = random.nextInt(genotypeLength);
        char[] genotypeArray = genotype.toCharArray();
        genotypeArray[index] = genotypeArray[index] == '0' ? '1' : '0';
        return new String(genotypeArray);
    }
}
