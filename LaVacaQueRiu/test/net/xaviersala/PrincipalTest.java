package net.xaviersala;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Comprova el funcionament de la funció d'emplenat del camió.
 *
 * @author xavier
 *
 */
public class PrincipalTest {

    /**
     * Pes de les vaques.
     */
    private static final int PES = 100;
    /**
     * Litres que genera cada vaca.
     */
    private static final int LITRES = 10;
    /**
     * Número de vaques a crear.
     */
    private static final int TOTALVAQUES = 10;

    /**
     * Llista de vaques.
     */
    private ArrayList<Vaca> vaques;

    /**
     * Crear les vaques.
     * @throws Exception Algun problema?
     */
    @Before
    public final void setUp() throws Exception {
        vaques = new ArrayList<Vaca>();

        for (int i = 0; i < TOTALVAQUES; i++) {
            vaques.add(new Vaca(String.valueOf(i), PES, LITRES));
        }
    }

    /**
     * Comprova que les vaques no entren en el camió si són massa grans.
     */
    @Test
    public final void testNoHiHaCapVacaQueEntri() {

        Camio truck = new Camio(PES - 1);

        Resultat r = Principal.emplenaCamio(vaques, 0, new Resultat(), truck);
        assertEquals(0, r.getMaxim());
        assertEquals("", r.getLlista());

    }

    /**
     * Comprova que les vaques entren en el camió pel pès just.
     */
    @Test
    public final void testEntrenVaques() {

        Camio truck = new Camio(PES);
        Resultat r = Principal.emplenaCamio(vaques, 0, new Resultat(), truck);
        assertEquals(LITRES, r.getMaxim());
        assertEquals("0 ", r.getLlista());

        truck = new Camio(PES + 1);
        r = Principal.emplenaCamio(vaques, 0, new Resultat(), truck);
        assertEquals(LITRES, r.getMaxim());
        assertEquals("0 ", r.getLlista());

        truck = new Camio(PES + PES);
        r = Principal.emplenaCamio(vaques, 0, new Resultat(), truck);
        assertEquals(LITRES + LITRES, r.getMaxim());
        assertEquals("0 1 ", r.getLlista());

        truck = new Camio(PES * TOTALVAQUES);
        r = Principal.emplenaCamio(vaques, 0, new Resultat(), truck);
        assertEquals(LITRES * TOTALVAQUES, r.getMaxim());
        assertEquals("0 1 2 3 4 5 6 7 8 9 ", r.getLlista());

    }

    /**
     * Una de les vaques fa molta més llet que les altres de manera
     * que ha de ser triada sempre.
     */
    @Test
    public final void testVacaSuperLletera() {
        // La reina de les vaques!
        vaques.add(new Vaca("X", PES + PES, PES));

        Camio truck = new Camio(PES * 2);
        Resultat r = Principal.emplenaCamio(vaques, 0, new Resultat(), truck);
        assertEquals(PES, r.getMaxim());
        assertEquals("X ", r.getLlista());

        truck = new Camio(PES + PES + PES);
        r = Principal.emplenaCamio(vaques, 0, new Resultat(), truck);
        assertEquals(PES + LITRES, r.getMaxim());
        assertEquals("0 X ", r.getLlista());
    }

    /**
     * Exemples proposats.
     *    Camió 1000 kg --> 189 litres
     *                      Pica Penta Hexa Escallot Tacada
     */
    @Test
    public final void testExemple1() {
        ArrayList<Vaca> llista = new ArrayList<Vaca>();

        llista.add(new Vaca("Pica", 223, 34));
        llista.add(new Vaca("Mica", 243, 28));
        llista.add(new Vaca("Penta", 100, 45));
        llista.add(new Vaca("Hexa", 200, 31));
        llista.add(new Vaca("Escallot", 200, 50));
        llista.add(new Vaca("Tacada", 155, 29));
        llista.add(new Vaca("Bruna", 300, 16));
        llista.add(new Vaca("Neu", 150, 10));

        Camio truck = new Camio(1000);
        Resultat r = Principal.emplenaCamio(llista, 0, new Resultat(), truck);

        assertEquals(189, r.getMaxim());
        assertEquals("Pica Penta Hexa Escallot Tacada ", r.getLlista());
    }

    /**
     * Exemples proposats.
     *    Camió 700 kg --> 125 litres
     *                     Patata Dansa Perla Pepi
     */
    @Test
    public final void testExemple2() {
        ArrayList<Vaca> llista = new ArrayList<Vaca>();

        llista.add(new Vaca("Guapa", 340, 45));
        llista.add(new Vaca("Bona", 355, 50));
        llista.add(new Vaca("Bonica", 223, 34));
        llista.add(new Vaca("Fletxa", 243, 39));
        llista.add(new Vaca("Patata", 130, 29));
        llista.add(new Vaca("Dansa", 240, 40));
        llista.add(new Vaca("Conxi", 260, 30));
        llista.add(new Vaca("Perla", 155, 25));
        llista.add(new Vaca("Mosca", 302, 52));
        llista.add(new Vaca("Pepi", 130, 31));

        Camio truck = new Camio(700);
        Resultat r = Principal.emplenaCamio(llista, 0, new Resultat(), truck);
        assertEquals(125, r.getMaxim());
        assertEquals("Patata Dansa Perla Pepi ", r.getLlista());
    }
}
