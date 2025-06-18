package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;


public class Joueur extends Personnages{
    private int ID ;


    public Joueur(Environnement environnement){
        super(100,100 ,environnement, 2) ;
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
