package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;


public class Joueur extends Personnages{
    private IntegerProperty xPos , yPos ;
    private int ID ;
    private boolean aDroite , aGauche , enHaut;
    private int vitesse = 2;
    private int GROUND_LEVEL = 150;
    private double velocityY ;
    private double gravity = 0.5 ;
    private int jumpStrength = -5 ;


    public Joueur(Environnement environnement){
        super(100,100 ,environnement) ;
        this.vitesse = 1 ;
    }


    public void direction() {
        if (aDroite) {
            this.xPos.set(this.xPos.get() + this.vitesse);
        }
        if (aGauche) {
            this.xPos.set(this.xPos.get() - this.vitesse);
        }
        if (enHaut) {
            this.handleJump();
        }
    }



    public void handleJump() {
        if (this.getyPos() == GROUND_LEVEL) {
            this.velocityY = jumpStrength;
        }
    }

    public void applyGravity() {
        this.velocityY += gravity;
        this.setyPos((int) (this.getyPos() + this.velocityY));

        if (this.getyPos() > GROUND_LEVEL) {
            this.setyPos(GROUND_LEVEL);
            this.velocityY = 0;
        }
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

    public void setyPos(int yPos) {
        this.yPos.set(yPos);
    }

    public void setxPos(int xPos) {
        this.xPos.set(xPos);
    }

    public int getxPos() {
        return xPos.get();
    }

    public IntegerProperty xPosProperty() {
        return xPos;
    }

    public int getyPos() {
        return yPos.get();
    }

    public IntegerProperty yPosProperty() {
        return yPos;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getID() {
        return ID;
    }
}
