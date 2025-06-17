package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

import java.util.ArrayList;

public class PersonnagesVue extends ImageView{
    private Image personnageImg = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/personnage.png").toExternalForm());
    private ArrayList<Image> images = new ArrayList<Image>();


    public PersonnagesVue(Joueur joueur, Pane pane ) {
        super();
        this.setImage(personnageImg);
    }
    public void affichage(Joueur joueur , Pane pane){
        this.translateXProperty().bind(joueur.xPosProperty());
        this.translateYProperty().bind(joueur.yPosProperty());
        pane.getChildren().add(this);
    }

}
