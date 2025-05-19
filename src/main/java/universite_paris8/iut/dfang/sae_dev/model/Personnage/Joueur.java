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
    private String direction ;

    public Joueur(int x , int y){
        this.xPos = new SimpleIntegerProperty(x);
        this.yPos = new SimpleIntegerProperty(y);
    }

    public void actualisationDuPersonnage(Pane pane){
        PersonnagesVue perso= new PersonnagesVue();
        perso.afficherpersonnage(this,pane);
    }

    public void deplacerHaut() {
        yPosProperty().setValue(yPosProperty().getValue() - 10);
    }

    public void deplacerBas() {yPosProperty().setValue(yPosProperty().getValue() + 10);}

    public void deplacerDroite() {
        xPosProperty().setValue(xPosProperty().getValue() + 10);
    }

    public void deplacerGauche() {
        xPosProperty().setValue(xPosProperty().getValue() - 10);
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

    public int getID() {
        return ID;
    }
}
