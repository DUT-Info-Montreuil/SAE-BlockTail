package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;


public class Joueur {
    private IntegerProperty xPos , yPos ;
    private int ID ;
    private int direction ;
    private int vitesse = 1;

    public Joueur(int x , int y , int vitesse){
        this.xPos = new SimpleIntegerProperty(x);
        this.yPos = new SimpleIntegerProperty(y);
        this.vitesse = 1 ;
    }

    public void actualisationDuPersonnage(Pane pane) {
        PersonnagesVue perso = new PersonnagesVue();
        perso.afficherpersonnage(this, pane);
    }

    public void setDirection(int direction){
        this.direction = direction ;
        System.out.println("joueur " + this.direction);
    }


    public void Direction() {
        if(this.direction == 1){//Droite
            xPosProperty().setValue(xPosProperty().getValue() + this.vitesse);
        } else if (this.direction == 2) {//Gauche
            xPosProperty().setValue(xPosProperty().getValue() - this.vitesse);
        } else if (this.direction == 3) {//Haut
            yPosProperty().setValue(yPosProperty().getValue() - this.vitesse);
        } else if(this.direction == 4){//Bas
            yPosProperty().setValue(yPosProperty().getValue() + this.vitesse);
        }
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

    public int getDirection() {
        return direction;
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
