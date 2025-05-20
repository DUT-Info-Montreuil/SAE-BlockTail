package universite_paris8.iut.dfang.sae_dev;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.vue.TerrrainVue;


public class Controleur implements Initializable {

    private Timeline gameLoop;

    private int temps;

    @FXML
    public TilePane tilepane;

    @FXML
    public Pane PanePrincipal;


    private Joueur joueur;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initAnimation();


        Terrain terrain = new Terrain();
        TerrrainVue terrrainVue = new TerrrainVue(terrain, tilepane);

        joueur = new Joueur(100, 100 , 1); // Position initiale
        joueur.actualisationDuPersonnage(PanePrincipal);

        PanePrincipal.setFocusTraversable(true);
        PanePrincipal.requestFocus();
        PanePrincipal.setOnKeyPressed(this::gererToucheClavier);
        PanePrincipal.setOnKeyReleased(this::resetDirection);
        gameLoop.play();
    }

    private void gererToucheClavier(KeyEvent event) {
        switch (event.getCode()){
            case Z :
                joueur.setEnHaut(true);
                break;
            case Q :
                joueur.setaGauche(true);
                break;
            case D :
                joueur.setaDroite(true);
                break;

        }
    }

    private void collision(){

    }


    private void resetDirection(KeyEvent event) {
        switch (event.getCode()){
            case Z :
                joueur.setEnHaut(false);
                break;
            case Q :
                joueur.setaGauche(false);
                break;
            case D :
                joueur.setaDroite(false);
                break;

        }
    }

    private void initAnimation(){
        gameLoop = new Timeline();
        temps = 0 ;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(Duration.seconds(0.017),(ev ->{
            joueur.direction();
            collision();
            joueur.applyGravity();

        }));
        gameLoop.getKeyFrames().add(kf);
    }
}
