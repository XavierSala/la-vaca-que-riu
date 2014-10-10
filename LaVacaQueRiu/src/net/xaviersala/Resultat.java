package net.xaviersala;

/**
 * Classe creada per obtenir el resultat d'emplenar el camió
 * a partir d'una llista de noms de vaques i un valor dels
 * litres que són capaces de fer.
 *
 * @author xavier
 *
 */
class Resultat {

    /**
     * Crea un objecte resultat a partir de les dades
     * que el composen.
     * @param m maxim.
     * @param s cadena amb el resultat.
     */
    public Resultat(final int m, final String s) {
        maxim = m;
        llista = s;
    }

    /**
     * Crea un resultat a partir d'un altre objecte resultat.
     *
     * @param r resultat
     */
    public Resultat(final Resultat r) {
        maxim = r.maxim;
        llista = r.llista;
    }

    /**
     * Crea un objecte resultat.
     */
    public Resultat() {
        maxim = 0;
        llista = "";
    }

    /**
     * Maxim número de litres.
     */
    private int maxim;
    /**
     * Llista de vaques.
     */
    private String llista;

    /**
     * @return el màxim obtingut
     */
    public int getMaxim() {
        return maxim;
    }
    /**
     * Posa el màxim.
     * @param max litres màxims
     */
    public void setMaxim(final int max) {
        maxim = max;
    }

    /**
     * @return la llista de vaques
     */
    public String getLlista() {
        return llista;
    }

    /**
     * Assigna la llista de vaques.
     * @param lli la llista.
     */
    public void setLlista(final String lli) {
        this.llista = lli;
    }

    /**
     * @return retorna el resultat
     */
    public String toString() {
        return llista + ": " + maxim + " litres";
    }
}
