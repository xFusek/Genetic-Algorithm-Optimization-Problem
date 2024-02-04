package project;

/**
 * Implementacja interfejsu IIndividual reprezentująca pojedynczy osobnik populacji.
 */
class PopulationIndividual implements IIndividual {
    private final int id;
    private String genotype;
    private Double fitnessValue;

    /**
     * Tworzy nowy obiekt PopulationIndividual.
     *
     * @param id       identyfikator osobnika
     * @param genotype genotyp osobnika
     */
    public PopulationIndividual(int id, String genotype) {
        this.id = id;
        this.genotype = genotype;
        this.fitnessValue = calculateFitnessValue();
    }

    private Double calculateFitnessValue() {
        int x = Integer.parseInt(genotype.substring(0, 10), 2);
        int y = Integer.parseInt(genotype.substring(10), 2);
        return -(Math.pow(475 - x, 2) + Math.pow(500 - y, 2)) + 600000;
    }

    /**
     * Zwraca identyfikator osobnika.
     *
     * @return identyfikator osobnika
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Zwraca genotyp osobnika.
     *
     * @return genotyp osobnika
     */
    @Override
    public String getGenotype() {
        return genotype;
    }

    /**
     * Zwraca długość genotypu osobnika.
     *
     * @return długość genotypu osobnika
     */
    @Override
    public int getGenotypeLength() {
        return genotype.length();
    }

    /**
     * Ustawia nowy genotyp osobnika.
     *
     * @param genotype nowy genotyp osobnika
     * @return true, jeśli genotyp został pomyślnie ustawiony, w przeciwnym razie false
     */
    @Override
    public boolean setGenotype(String genotype) {
        this.genotype = genotype;
        this.fitnessValue = calculateFitnessValue();
        return true;
    }

    /**
     * Zwraca wartość przystosowania osobnika.
     *
     * @return wartość przystosowania osobnika
     */
    @Override
    public Double getFitnessValue() {
        return fitnessValue;
    }

    /**
     * Tworzy głęboką kopię osobnika.
     *
     * @return klon osobnika
     */
    @Override
    public IIndividual cloneIndividual() {
        return new PopulationIndividual(id, genotype);
    }
}