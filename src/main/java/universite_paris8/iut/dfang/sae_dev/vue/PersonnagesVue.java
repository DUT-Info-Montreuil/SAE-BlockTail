package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

public class PersonnagesVue {


    public void afficherpersonnage(Joueur joueur, Pane pane) {
        Image personnageImg = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/personnage.png").toExternalForm());
        ImageView perso = new ImageView(personnageImg);
        perso.translateXProperty().bind(joueur.xPosProperty());
        perso.translateYProperty().bind(joueur.yPosProperty());
        pane.getChildren().add(perso);
    }




}
