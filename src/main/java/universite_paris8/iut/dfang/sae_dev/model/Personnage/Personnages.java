package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;

public class Personnages {
    private int vitesse ;
    private IntegerProperty xPos , yPos ;
    private Environnement environnement ;

    public Personnages(int x , int y , Environnement environnement){
        this.xPos = new SimpleIntegerProperty(x);
        this.yPos = new SimpleIntegerProperty(y);
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

    public void setyPos(int yPos) {
        this.yPos.set(yPos);
    }

    public void setxPos(int xPos) {
        this.xPos.set(xPos);
    }
}
