package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Ennemis;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

import java.util.ArrayList;

public class EnnemisVue extends ImageView{
    private Image personnageImg = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/Ennemis.png").toExternalForm());
    private ArrayList<Image> images = new ArrayList<Image>();
    public EnnemisVue(Ennemis ennemis, Pane pane , Timeline gameLoop) {
        super();
        this.setImage(personnageImg);
    }
    public void affichage(Ennemis ennemis , Pane pane){
        this.translateXProperty().bind(ennemis.xProperty());
        this.translateYProperty().bind(ennemis.yProperty());
        pane.getChildren().add(this);
    }
}
