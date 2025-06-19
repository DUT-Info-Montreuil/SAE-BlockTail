package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

import java.util.ArrayList;

public class JoueurVue extends ImageView{
    private Image personnageDroite = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/luffydroite.gif").toExternalForm());
    private Image personnageGauche = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/luffygauche.gif").toExternalForm());
    private Image personnageSaut = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/immobile2.png").toExternalForm());
    private Image personnageImmobile = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/immobile2.png").toExternalForm());
    public JoueurVue(Joueur joueur, Pane pane) {
        super();
        this.setImage(personnageImmobile);

        joueur.etatProperty().addListener((obs, oldVal, newVal) -> {
            switch (newVal.intValue()) {
                case 0 -> setImage(personnageImmobile);
                case 1 -> setImage(personnageDroite);
                case 2 -> setImage(personnageGauche);
                case 3 -> setImage(personnageSaut);
            }
        });
    }
    public void affichage(Joueur joueur , Pane pane){
        this.translateXProperty().bind(joueur.xProperty());
        this.translateYProperty().bind(joueur.yProperty());
        pane.getChildren().add(this);
    }
}
