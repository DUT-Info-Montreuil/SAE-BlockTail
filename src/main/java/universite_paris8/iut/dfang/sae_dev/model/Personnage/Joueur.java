package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;


public class Joueur extends Personnages{
    private int ID ;


    public Joueur(Environnement environnement){
        super(100,10 ,environnement, 1) ;
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

    public int getID() {
        return ID;
    }
}
