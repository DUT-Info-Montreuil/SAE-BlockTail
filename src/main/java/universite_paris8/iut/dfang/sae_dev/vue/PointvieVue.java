package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

public class PointvieVue extends ImageView {
    private Image point_vie = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/point_vie.png").toExternalForm());
    Text point = new Text();
    public PointvieVue(Joueur joueur , Pane pane){
        super();
        this.setImage(point_vie);
    }
    public void afficheVie(Joueur joueur ,Pane pane){
        pane.getChildren().add(this);
        point.setText(joueur.getPv()+"");
        point.setScaleX(1);
        point.setScaleY(1);
        point.setY(17);
        point.setX(3);
        pane.getChildren().add(point);

    }

    public void nbrDeVie(Joueur joueur){
        point.setText(joueur.getPv()+"");
    }

}
