package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Joueur {
    private IntegerProperty xPos , yPos ;
    private int ID ;
    private ImageView joueur ;


    public Joueur(int x , int y){
        this.xPos = new SimpleIntegerProperty(x);
        this.yPos = new SimpleIntegerProperty(y);
    }

    public void actualisationDuPersonnage(Pane pane){
        Image personnageImg = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/personnage.png").toExternalForm());
        joueur = new ImageView(personnageImg);
        joueur.translateXProperty().bind(xPosProperty());
        joueur.translateYProperty().bind(yPosProperty());
        pane.getChildren().add(joueur);
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
