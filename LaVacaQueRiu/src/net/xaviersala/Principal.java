package net.xaviersala;

import java.util.ArrayList;

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
        String[] noms = {"Maria", "Pepa", "Flor", "Toñi", "Conxita", "Blanca"};
        int[] pesos   = {360,    250,    400,    180,    50,         90};
        int[] litres  = {40,     35,     43,     28,    12,         13};
        ArrayList<Vaca> vaques = new ArrayList<Vaca>();
        for (int i = 0; i < noms.length; i++) {
            vaques.add(new Vaca(noms[i], pesos[i], litres[i]));
        }

        // Creo el camió definint-li el pes màxim.
        Camio trailer = new Camio(PESDELCAMIO);

        Resultat maxim = new Resultat();
        Resultat llet = emplenaCamio(vaques, 0, maxim, trailer);

        System.out.println("Resultat: " + llet.getLlista()
                + ": " + llet.getMaxim() + " litres");

    }

    /**
     * Emplena el camió intentant posar les millors vaques.
     * @param vaques Array amb les vaques que es poden carregar
     * @param posicio posició de la vaca que provem
     * @param resultat número màxim de litres que s'aconsegueix
     * @param trailer Camió
     * @return El número màxim de litres
     */
    public static Resultat emplenaCamio(final ArrayList<Vaca> vaques,
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
