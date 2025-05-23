package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;

import static java.lang.Math.round;

public class Personnages {

    private int largeur, hauteur;

    private IntegerProperty xPos , yPos ;
    private Environnement environnement ;

    private boolean aDroite , aGauche ,enHaut;

    private int vitesse ;
    private double velocityY ;
    private double gravity = 0.5 ;
    private int jumpStrength = -5 ;

    private int GROUND_LEVEL ;

    public Personnages(int x , int y , Environnement environnement , int vitesse){
        this.xPos = new SimpleIntegerProperty(x);
        this.yPos = new SimpleIntegerProperty(y);
        this.environnement = environnement;
        this.vitesse = vitesse ;
    }

    public void direction() {
        if (aDroite && collisionDroite()) {
            this.setxPos(this.getxPos() + this.vitesse);
        }
        if (aGauche && collisionGauche()) {
            this.setxPos(this.getxPos() - this.vitesse);
        }
        if (enHaut) {
            this.handleJump();
        }
    }



    public boolean collisionDroite() {
        if(collisionBas()){
            if (collisionDroiteHaut()){
                return true ;
            }
        }else if(collisionDroiteBas() || collisionDroiteHaut()){
            return true ;
        }
        return false ;
    }
    public boolean collisionGauche(){
        if(collisionBas()){
            if (collisionGaucheHaut()){
                return true ;
            }
        }else if(collisionGaucheBas() || collisionGaucheHaut()){
            return true ;
        }
        return false ;
    }
    public boolean collisionBas(){
        return this.collisionDroiteBas() || this.collisionGaucheBas();
    }

    public boolean collisionGaucheHaut(){
        return !(this.environnement.getTerrain().estSolide(round((float) (this.getyPos()+this.vitesse)/16)  ,round((float) ((this.getxPos()-this.vitesse)/16))));
    }
    public boolean collisionGaucheBas(){
        return !(this.environnement.getTerrain().estSolide(round((float) (this.getyPos()+16+this.vitesse)/16) ,round((float) ((this.getxPos()-this.vitesse)/16))));
    }
    public boolean collisionDroiteBas(){
        return !(this.environnement.getTerrain().estSolide(round((float) (this.getyPos()+16+this.vitesse)/16) ,round((float) ((this.getxPos()+15+this.vitesse)/16))));
    }
    public boolean collisionDroiteHaut(){
        return !(this.environnement.getTerrain().estSolide(round((float) (this.getyPos()+this.vitesse)/16)  ,round((float) ((this.getxPos()+15+this.vitesse)/16))));
    }



    public void updateGround(){
        if(collisionBas()){
            GROUND_LEVEL = Terrain.TAILLE_TUILES * ((this.getyPos()/16)+1);
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



    public IntegerProperty yPosProperty(){
        return this.yPos ;
    }

    public IntegerProperty xPosProperty() {
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

    public int getGROUND_LEVEL() {
        return GROUND_LEVEL;
    }
}
