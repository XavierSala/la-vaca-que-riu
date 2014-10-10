package net.xaviersala;

import java.util.Arrays;
import java.util.List;

/**
 * Programa d'entrada de vaques en un camió.
 *
 * @author xavier
 *
 */
public final class Principal {

    /**
     * Pes màxim que pot portar el camió.
     */
    private static final int PESDELCAMIO = 700;

    /**
     * Evitar que es crein objectes a partir de la classe.
     */
    private Principal() {
    }
    /**
     * Programa principal.
     *
     * Entra les vaques que hi càpiguen i plega...
     *
     * @param args arguments
     */
    public static void main(final String[] args) {

        //Dades de les vaques
        List<Vaca> vaques = Arrays.asList(
                new Vaca("Maria", 360, 40),
                new Vaca("Pepa", 250, 35),
                new Vaca("Flor", 400, 43),
                new Vaca("Toñi", 180, 28),
                new Vaca("Conxita", 50, 12),
                new Vaca("Blanca", 90, 13)
                );

        // Creo el camió definint-li el pes màxim.
        Camio trailer = new Camio(PESDELCAMIO);

        Resultat maxim = new Resultat();
        Resultat llet = emplenaCamio(vaques, 0, maxim, trailer);

        System.out.println(llet);

    }

    /**
     * Emplena el camió intentant posar les millors vaques.
     * @param vaques Array amb les vaques que es poden carregar
     * @param posicio posició de la vaca que provem
     * @param resultat número màxim de litres que s'aconsegueix
     * @param trailer Camió
     * @return El número màxim de litres
     */
    public static Resultat emplenaCamio(final List<Vaca> vaques,
            final int posicio,
            final Resultat resultat,
            final Camio trailer) {

        Resultat litres = new Resultat();

        Resultat maximActual = new Resultat(resultat);


        for (int i = posicio; i < vaques.size(); i++) {

            if (trailer.entraVaca(vaques.get(i))) {

                if (maximActual.getMaxim() < trailer.getLitres()) {
                    maximActual.setMaxim(trailer.getLitres());
                    maximActual.setLlista(trailer.toString());
                }
                // maximActual = Math.max(maximActual, trailer.getLitres());
                litres = emplenaCamio(vaques, i + 1, resultat, trailer);

                if (litres.getMaxim() > maximActual.getMaxim()) {
                    maximActual.setMaxim(litres.getMaxim());
                    maximActual.setLlista(litres.getLlista());
                }

                trailer.treuUltimaVaca();
            }
        }

        return maximActual;
    }

}
