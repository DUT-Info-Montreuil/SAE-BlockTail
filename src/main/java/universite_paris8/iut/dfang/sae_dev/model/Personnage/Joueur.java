package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;


public class Joueur extends Personnages{
    private int ID ;


    public Joueur(Environnement environnement , TilePane Items , TilePane caseInv){
        super(100,100 ,environnement, 2 , Items , caseInv   ) ;
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
        return super.xProperty();
    }

    public int getyPos() {
        return super.getyPos();
    }

    public IntegerProperty yPosProperty() {
        return super.yProperty();
    }

    public int getID() {
        return ID;
    }
}
