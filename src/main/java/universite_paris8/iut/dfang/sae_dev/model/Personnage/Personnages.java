package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Inventaire;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;


public class Personnages {

    public final int HAUTEUR_COLLISION = 16 ,LARGEUR_COLLISION = 16;

    private IntegerProperty xPos , yPos ;
    private Environnement environnement ;

    public boolean aDroite , aGauche , enHaut , auSol;

    private int vitesse ;
    public double velocityY ;
    private double gravity = 0.5 ;
    private int saut = -5 ;
    private Inventaire inv ;

    private IntegerProperty etat = new SimpleIntegerProperty(0);

    private int pv ;

    public Personnages( int pv ,int x , int y , Environnement environnement , int vitesse ){
        this.xPos = new SimpleIntegerProperty(x);
        this.yPos = new SimpleIntegerProperty(y);
        this.environnement = environnement;
        this.vitesse = vitesse ;
        this.pv = pv ;
        this.inv = new Inventaire( 20 );
    }



    /**
     * fait se deplacer le personage dans les diection selectione
     */
    public void direction() {
        if (aDroite) {
            deplacerDroite();
        }
        if (aGauche) {
            deplacerGauche();
        }
        if (enHaut) {
            sauter();
        }
    }


    /**
     * fait bouger le joueur a droite
     */
    public void deplacerDroite() {
        int nouveauX = xProperty().get() + vitesse;
        int actuelY = yProperty().get();

        // Vérification des collisions horizontales (limite droite)
        if (nouveauX + LARGEUR_COLLISION <= this.environnement.getTerrain().largeurMax() &&
                this.environnement.getTerrain().estAccessible(nouveauX + LARGEUR_COLLISION - 1, actuelY) &&
                this.environnement.getTerrain().estAccessible(nouveauX + LARGEUR_COLLISION - 1, actuelY + HAUTEUR_COLLISION - 1)) {
            xProperty().set(nouveauX);
        }
    }

    /**
     * fait bouger le joueur a gauche
     */
    public void deplacerGauche() {
        int nouveauX = xProperty().get() - vitesse;
        int currentY = yProperty().get();

        // Vérification des collisions horizontales (limite gauche)
        if (nouveauX >= 0 &&
                this.environnement.getTerrain().estAccessible(nouveauX, currentY) &&
                this.environnement.getTerrain().estAccessible(nouveauX, currentY + HAUTEUR_COLLISION - 1 )) {
            xProperty().set(nouveauX);
        }
    }


    /**
     * fait sauter le joueur
     */
    void sauter() {
        if (auSol) {
            velocityY = saut;
            auSol = false;
        }
    }


    /**
     * fait tomber le joueur quand il ne touche pas le sol
     *
     * empeche le joueur de macher dans les murs (colision)
     */
    public void appliquerPhysique() {
        velocityY += gravity;

        int nouveauY = yProperty().get() + (int)velocityY;
        int currentX = xProperty().get();

        if (nouveauY <= 0) {
            nouveauY = 0;
            velocityY = 0;
            auSol = true;
            yProperty().set(nouveauY);
            return;
        }

        if (nouveauY >= this.environnement.getTerrain().hauteurMax()) {
            nouveauY = this.environnement.getTerrain().hauteurMax();
            velocityY = 0;
            yProperty().set(nouveauY);
            return;
        }

        boolean collision = false;

        if (velocityY > 0) {
            int basPersonnage = nouveauY + HAUTEUR_COLLISION;

            boolean solGauche = !this.environnement.getTerrain().estAccessible(currentX, basPersonnage);
            boolean solDroite = !this.environnement.getTerrain().estAccessible(currentX + LARGEUR_COLLISION - 1, basPersonnage);


            if (solGauche || solDroite) {
                int ligneSol = basPersonnage / Terrain.TAILLE_TUILES;
                nouveauY = (ligneSol * Terrain.TAILLE_TUILES) - HAUTEUR_COLLISION;
                velocityY = 0;
                auSol = true;
                collision = true;
            }
        } else if (velocityY < 0) {
            boolean plafondGauche = !this.environnement.getTerrain().estAccessible(currentX, nouveauY);
            boolean plafondDroite = !this.environnement.getTerrain().estAccessible(currentX + LARGEUR_COLLISION - 1, nouveauY);


            if (plafondGauche || plafondDroite) {
                int lignePlafond = nouveauY / Terrain.TAILLE_TUILES;
                nouveauY = (lignePlafond + 1) * Terrain.TAILLE_TUILES;
                velocityY = 0;
                collision = true;
            }
        }

        if (!collision && auSol) {
            int basPersonnage = yProperty().get() - HAUTEUR_COLLISION - 1;
            boolean solGauche = !this.environnement.getTerrain().estAccessible(currentX, basPersonnage);
            boolean solDroite = !this.environnement.getTerrain().estAccessible(currentX + LARGEUR_COLLISION - 1, basPersonnage);
            if (!solGauche && !solDroite) {
                auSol = false;
            }
        }
        yProperty().set(nouveauY);
    }

    public Inventaire getInv(){
        return this.inv;
    }


    public void setaDroite(boolean aDroite) {
        this.aDroite = aDroite;
    }

    public void setaGauche(boolean aGauche) {
        this.aGauche = aGauche;
    }

    public void setEnHaut(boolean enHaut) {
        this.enHaut = enHaut;
    }

    public IntegerProperty yProperty(){
        return this.yPos ;
    }

    public IntegerProperty xProperty() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos.get();
    }

    public int getxPos() {
        return this.xPos.get();
    }

    public void setyPos(int yPos) {
        this.yPos.set(yPos);
    }

    public void setxPos(int xPos) {
        this.xPos.set(xPos);
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public IntegerProperty etatProperty() {
        return etat;
    }

    public int getEtat() {
        return etat.get();
    }

    public void setEtat(int nouvelEtat) {
        etat.set(nouvelEtat);
    }

    public int getPv() {
        return pv;
    }
}
