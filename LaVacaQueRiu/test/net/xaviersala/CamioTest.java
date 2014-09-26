package net.xaviersala;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Comprovar el camió.
 *
 * @author xavier
 *
 */
public class CamioTest {

    /**
     * Pes de la vaca 1.
     */
    static final int PESVACA1 = 300;
    /**
     * Pes de la vaca 2.
     */
    static final int PESVACA2 = 200;
    /**
     * Pes de la vaca 3.
     */
    static final int PESVACA3 = 100;
    /**
     * Quantitat de llet.
     */
    static final int LLET = 20;

    /**
     * Camió on emplenem.
     */
    private Camio truck;

    /**
     * Llista de vaques.
     */
    private ArrayList<Vaca> vaques;

    /**
     * Crear els objectes per fer les proves.
     * @throws Exception Alguna cosa no va...
     */
    @Before
    public final void setUp() throws Exception {
        vaques = new ArrayList<Vaca>();
        vaques.add(new Vaca("Un", PESVACA1, LLET));
        vaques.add(new Vaca("Dos", PESVACA2, LLET));
        vaques.add(new Vaca("Tres", PESVACA3, LLET));
    }

    /**
     * Comprovar que no es pot posar més pes del que el camió
     * suporta.
     */
    @Test
    public final void testNoDeixaSuperarElMaxim() {

        // Entrar una vaca i comprovar que ha entrat
        truck = new Camio(vaques.get(0).getPes());

        assertTrue(truck.entraVaca(vaques.get(0)));
        assertTrue(truck.getPesActual() == vaques.get(0).getPes());
        assertTrue(truck.getLitres() == vaques.get(0).getLitres());

        // La segona i la tercera no entren i comprovar que el pes no canvia
        assertFalse(truck.entraVaca(vaques.get(1)));
        assertTrue(truck.getPesActual() == vaques.get(0).getPes());
        assertTrue(truck.getLitres() == vaques.get(0).getLitres());

        assertFalse(truck.entraVaca(vaques.get(2)));
        assertTrue(truck.getPesActual() == vaques.get(0).getPes());
        assertTrue(truck.getLitres() == vaques.get(0).getLitres());

        // Preparo un camió que permeti entrar dues vaques
        int pesTotal = vaques.get(1).getPes() + vaques.get(2).getPes();
        int litresTotal = vaques.get(1).getLitres() + vaques.get(2).getLitres();
        truck = new Camio(pesTotal);
        assertTrue(truck.entraVaca(vaques.get(1)));
        assertTrue(truck.getPesActual() == vaques.get(1).getPes());
        assertTrue(truck.getLitres() == vaques.get(1).getLitres());

        assertTrue(truck.entraVaca(vaques.get(2)));
        assertTrue(truck.getPesActual() == pesTotal);
        assertTrue(truck.getLitres() == litresTotal);

        assertFalse(truck.entraVaca(vaques.get(0)));
        assertTrue(truck.getPesActual() == pesTotal);
        assertTrue(truck.getLitres() == litresTotal);

    }

    /**
     * Comprova que el camió controla correctament els litres de
     * les vaques.
     */
    @Test
    public final void testLletEntraISurtCorrectament() {
        truck = new Camio(vaques.get(0).getPes() + vaques.get(1).getPes());
        assertTrue(truck.entraVaca(vaques.get(0)));
        assertTrue(truck.getLitres() == vaques.get(0).getLitres());

        assertTrue(truck.entraVaca(vaques.get(1)));
        assertEquals(truck.getLitres(),
                vaques.get(0).getLitres() + vaques.get(1).getLitres());

        assertSame(vaques.get(1), truck.treuUltimaVaca());
        assertEquals(truck.getLitres(),
                vaques.get(0).getLitres());

        assertSame(vaques.get(0), truck.treuUltimaVaca());
        assertEquals(truck.getLitres(),
                0);

        // Treure i no n'hi ha cap...
        assertNull(truck.treuUltimaVaca());
        assertEquals(truck.getLitres(),
                0);

        assertTrue(truck.entraVaca(vaques.get(2)));
        assertEquals(truck.getLitres(),
                vaques.get(2).getLitres());
    }

    /**
     * Comprova que els pesos de les vaques que s'han entrat o tret
     * són control·lats correctament.
     */
    @Test
    public final void testPesFuncionaCorrectament() {
        truck = new Camio(vaques.get(0).getPes() + vaques.get(1).getPes());
        assertTrue(truck.entraVaca(vaques.get(0)));
        assertTrue(truck.getPesActual() == vaques.get(0).getPes());

        truck.treuUltimaVaca();
        assertEquals(truck.getPesActual(), 0);

        // Treure vaca quan no n'hi ha cap
        truck.treuUltimaVaca();
        assertEquals(truck.getPesActual(), 0);

        assertTrue(truck.entraVaca(vaques.get(2)));
        assertEquals(truck.getPesActual(),
                vaques.get(2).getPes());

        assertTrue(truck.entraVaca(vaques.get(2)));
        assertEquals(truck.getPesActual(),
                vaques.get(2).getPes() * 2);
    }

    /**
     * Comprova que les vaques que s'entren conserven el nom.
     */
    @Test
    public final void testGetNomsDeVaques() {
        truck = new Camio(PESVACA1 + PESVACA2);
        truck.entraVaca(vaques.get(0));
        assertEquals(vaques.get(0).toString(), truck.toString().trim());

        truck.entraVaca(vaques.get(1));
        assertEquals(vaques.get(0).toString() + " " + vaques.get(1).toString(),
                truck.toString().trim());

        // Aquesta no hi cap
        truck.entraVaca(vaques.get(2));
        assertEquals(vaques.get(0).toString() + " " + vaques.get(1).toString(),
                truck.toString().trim());

        // Treure la primera
        truck.treuVaca(0);
        assertEquals(vaques.get(1).toString() + " ", truck.toString());

    }

}
