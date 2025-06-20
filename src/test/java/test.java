import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;

class test {

    private Personnages perso;
    private Environnement environnement;

    // Stub minimal de Terrain pour les tests (accessible partout)
    private static class TestTerrain extends Terrain {


        @Override
        public boolean estAccessible(int x, int y) {
            // Limites simples, tout accessible dans les bornes
            return x >= 0 && x < largeurMax() && y >= 0 && y < hauteurMax();
        }
    }

    // Stub minimal de Environnement
    private static class TestEnvironnement extends Environnement {
        private Terrain terrain;

        public TestEnvironnement() {
            this.terrain = new TestTerrain();
        }

        @Override
        public Terrain getTerrain() {
            return terrain;
        }
    }

    @BeforeEach
    void setUp() {
        environnement = new TestEnvironnement();
        perso = new Personnages(100, 10, 10, environnement, 5);
    }

    @Test
    void testConstructeur() {
        assertEquals(10, perso.getxPos());
        assertEquals(10, perso.getyPos());
        assertEquals(100, perso.getPv());
        assertNotNull(perso.getInv());
        assertEquals(0, perso.getEtat());
    }

    @Test
    void testDeplacerDroiteSansCollision() {
        perso.setaDroite(true);
        perso.direction();
        assertEquals(15, perso.getxPos()); // 10 + 5
    }

    @Test
    void testDeplacerGaucheSansCollision() {
        perso.setaGauche(true);
        perso.direction();
        assertEquals(5, perso.getxPos()); // 10 - 5
    }

    @Test
    void testDeplacerDroiteAvecLimite() {
        perso.setxPos(environnement.getTerrain().largeurMax() - perso.LARGEUR_COLLISION);
        perso.setaDroite(true);
        perso.direction();
        // Ne doit pas dépasser la limite droite
        assertEquals(environnement.getTerrain().largeurMax() - perso.LARGEUR_COLLISION, perso.getxPos());
    }

    @Test
    void testSaut() {
        perso.setEnHaut(true);
        perso.appliquerPhysique();  // met velocityY à 0 + gravity
        perso.direction();          // déclenche le saut si auSol
        perso.appliquerPhysique();
        assertTrue(perso.velocityY < 0 || !perso.auSol); // Le perso doit être en mouvement vertical ascendant
    }

    @Test
    void testAppliquerGraviteEtCollisionSol() {
        // Positionner le perso un peu en l'air
        perso.setyPos(0);
        perso.auSol = false;
        perso.velocityY = 0;
        for (int i = 0; i < 20; i++) {
            perso.appliquerPhysique();
        }
        // Le perso doit toucher le sol (y ne dépasse pas la hauteur max)
        assertTrue(perso.getyPos() <= environnement.getTerrain().hauteurMax());
        assertTrue(perso.auSol);
    }

    @Test
    void testEtatProperty() {
        perso.setEtat(5);
        assertEquals(5, perso.getEtat());
        perso.etatProperty().set(7);
        assertEquals(7, perso.getEtat());
    }

    @Test
    void testSettersEtGettersPosition() {
        perso.setxPos(20);
        perso.setyPos(30);
        assertEquals(20, perso.getxPos());
        assertEquals(30, perso.getyPos());
    }

    @Test
    void testInventaireNonNull() {
        assertNotNull(perso.getInv());
    }

    @Test
    void testPvSetAndGet() {
        perso.setPv(50);
        assertEquals(50, perso.getPv());
    }
}

// j'ai eu un soucis de Bibliothèque , et de module ce qui ne permettais pas de tester ce que je faisais, excusez nous pour cette gêne occasionée
