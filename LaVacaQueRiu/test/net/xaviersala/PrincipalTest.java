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

}
