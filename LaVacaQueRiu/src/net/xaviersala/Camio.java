package net.xaviersala;

import java.util.ArrayList;

/**
 * Camió de vaques.
 *
 * @author xavier
 *
 */
public class Camio {

    /**
     * Pes màxim que suporta el camió.
     */
    private int pesMaxim;
    /**
     * Pes actual que es pot entrar en el camió.
     */
    private int pesActual;
    /**
     * Litres que fan les vaques que són dins del camió.
     */
    private int litres;
    /**
     * Llista de vaques que hi ha en el camió.
     */
    private ArrayList<Vaca> vaques;

    /**
     * Constructor del camió.
     * @param pes màxim que suporta el camió
     */
    public Camio(final int pes) {
        pesMaxim = pes;
        pesActual = 0;
        litres = 0;
        vaques = new ArrayList<Vaca>();
    }

    /**
     * Introdueix la vaca rebuda com a paràmetre en el camió.
     * @param nova Vaca a introduïr
     * @return retorna si la vaca ha pogut entrar o no
     */
    public final boolean entraVaca(final Vaca nova) {
        if (pesActual + nova.getPes() <= pesMaxim) {
            vaques.add(nova);
            pesActual += nova.getPes();
            litres += nova.getLitres();
            return true;
        }
        return false;
    }

    /**
     * @return els litres de llet del camió
     */
    public final int getLitres() {
        return litres;
    }

    /**
     * Treu la vaca que està en la posició especificada i retorna la
     * vaca que surt.
     *
     * @param i posició de la vaca
     * @return Vaca que es treu
     */
    public final Vaca treuVaca(final int i) {
        Vaca burra;
        if (i < vaques.size()) {
            burra = vaques.get(i);
            vaques.remove(i);
            litres -= burra.getLitres();
            pesActual -= burra.getPes();
            return burra;
        }
        return null;

    }

    /**
     * Treu la darrera vaca que s'ha posat.
     * @return La vaca treta
     */
    public final Vaca treuUltimaVaca() {
        Vaca burra = null;

        if (!vaques.isEmpty()) {
            int ultima = vaques.size() - 1;
            burra = vaques.get(ultima);
            vaques.remove(ultima);
            litres -= burra.getLitres();
            pesActual -= burra.getPes();
        }
        return burra;
    }

    /**
     * @return Retorna el pes de les vaques que ja s'han carregat en el
     * camió.
     */
    public final int getPesActual() {
        return pesActual;
    }

    /**
     * @return el pes que el camió suporta.
     */
    public final int getPesMaxim() {
        return pesMaxim;
    }

    /**
     * @return els noms de totes les vaques en una cadena de text.
     */
    public final String getNomsDeVaques() {
        String resultat = "";
        for (int i = 0; i < vaques.size(); i++) {
            resultat += vaques.get(i).getNom() + " ";
        }
        return resultat;
    }

    /**
     * @return cadena amb els noms de les vaques de dins
     */
    public final String toString() {
        return getNomsDeVaques();
    }


}
