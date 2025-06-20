package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonnagesTest {

    @Test
    void testConstructeurEtPositions() {
        Personnages p = new Personnages(10, 1, 2, null, 3);
        assertEquals(1, p.getxPos());
        assertEquals(2, p.getyPos());
        assertEquals(10, p.getPv());
    }

    @Test
    void testSetGetPositions() {
        Personnages p = new Personnages(5, 0, 0, null, 1);
        p.setxPos(42);
        p.setyPos(24);
        assertEquals(42, p.getxPos());
        assertEquals(24, p.getyPos());
    }

    @Test
    void testSetGetPv() {
        Personnages p = new Personnages(8, 0, 0, null, 1);
        p.setPv(4);
        assertEquals(4, p.getPv());
    }

    @Test
    void testEtat() {
        Personnages p = new Personnages(1, 0, 0, null, 1);
        p.setEtat(7);
        assertEquals(7, p.getEtat());
    }

    @Test
    void testInventaire() {
        Personnages p = new Personnages(1, 0, 0, null, 1);
        assertNotNull(p.getInv());
    }
}