package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;


public class Joueur extends Personnages{
    private int ID ;
    private boolean aDroite , aGauche ,enHaut;
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
            super.setxPos(super.getxPos() + this.vitesse);
            System.out.println(super.getxPos());
        }
        if (aGauche) {
            super.setxPos(super.getxPos() - this.vitesse);
            System.out.println(super.getxPos());
        }
        if (enHaut) {
            this.handleJump();
            System.out.println("Jump");
            System.out.println("y" + super.getyPos());
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
        super.setyPos(yPos);
    }

    public void setxPos(int xPos) {
        super.setxPos(xPos);
    }

    public int getxPos() {
        return super.getxPos();
    }

    public IntegerProperty xPosProperty() {
        return super.xPosProperty();
    }

    public int getyPos() {
        return super.getyPos();
    }

    public IntegerProperty yPosProperty() {
        return super.yPosProperty();
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getID() {
        return ID;
    }
}
