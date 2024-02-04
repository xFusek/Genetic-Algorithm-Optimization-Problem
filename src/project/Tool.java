package project;

import java.util.List;

/**
 * Narzędzia pomocnicze do przekształcania listy osobników na tablicę.
 */
class Tool {
    /**
     * Przekształca listę osobników na tablicę.
     *
     * @param list lista osobników
     * @return tablica osobników
     */
    public static IIndividual[] castListToArray(List<IIndividual> list) {
        IIndividual[] array = new IIndividual[list.size()];
        return list.toArray(array);
    }
}
