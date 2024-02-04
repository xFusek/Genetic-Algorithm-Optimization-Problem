package project;

import java.util.Comparator;

/**
 * Interfejs reprezentujący osobnika w populacji.
 */
public interface IIndividual {
    /**
     * Zwraca identyfikator osobnika.
     *
     * @return identyfikator osobnika
     */
    int getId();

    /**
     * Zwraca genotyp osobnika.
     *
     * @return genotyp osobnika
     */
    String getGenotype();

    /**
     * Zwraca długość genotypu.
     *
     * @return długość genotypu
     */
    int getGenotypeLength();

    /**
     * Ustawia genotyp osobnika.
     *
     * @param genotype nowy genotyp
     * @return true, jeśli genotyp został ustawiony pomyślnie, w przeciwnym razie false
     */
    boolean setGenotype(String genotype);

    /**
     * Zwraca wartość przystosowania osobnika.
     *
     * @return wartość przystosowania osobnika
     */
    Double getFitnessValue();

    /**
     * Tworzy kopię osobnika.
     *
     * @return kopia osobnika
     */
    IIndividual cloneIndividual();

    /**
     * Komparator do porównywania osobników na podstawie wartości przystosowania.
     */
    public static Comparator<IIndividual> compare = (IIndividual a, IIndividual b) -> {
        if (a.getFitnessValue() < b.getFitnessValue())
            return 1;
        else if (a.getFitnessValue() > b.getFitnessValue())
            return -1;
        else
            return 0;
    };
}
