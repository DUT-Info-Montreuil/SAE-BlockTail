package universite_paris8.iut.dfang.sae_dev.controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;
import universite_paris8.iut.dfang.sae_dev.vue.TerrrainVue;


public class Controleur implements Initializable {

    private Timeline gameLoop;
    private int temps;
    private Environnement environnement ;
    private Joueur faust ;
    private PersonnagesVue faustVue ;

    @FXML
    public TilePane tilepane;

    @FXML
    public Pane PanePrincipal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initAnimation();


        environnement = new Environnement();

        Terrain terrain = new Terrain();
        TerrrainVue terrrainVue = new TerrrainVue(terrain, tilepane);

        faust = new Joueur(environnement);
        faustVue = new PersonnagesVue(environnement.getFaust(),PanePrincipal , gameLoop);
        this.PanePrincipal.getChildren().add(faustVue);

        PanePrincipal.setFocusTraversable(true);
        PanePrincipal.requestFocus();
        PanePrincipal.setOnKeyPressed(this::gererToucheClavier);
        PanePrincipal.setOnKeyReleased(this::resetDirection);
        gameLoop.play();
    }

    private void gererToucheClavier(KeyEvent event) {
        switch (event.getCode()){
            case Z :
                faust.setEnHaut(true);
                break;
            case Q :
                faust.setaGauche(true);
                break;
            case D :
                faust.setaDroite(true);
                break;

        }
    }

    private void collision(){

    }


    private void resetDirection(KeyEvent event) {
        switch (event.getCode()){
            case Z :
                faust.setEnHaut(false);
                break;
            case Q :
                faust.setaGauche(false);
                break;
            case D :
                faust.setaDroite(false);
                break;

        }
    }

    private void initAnimation(){
        gameLoop = new Timeline();
        temps = 0 ;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(Duration.seconds(0.017),(ev ->{
            environnement.getFaust().direction();
            collision();
            environnement.getFaust().applyGravity();

        }));
        gameLoop.getKeyFrames().add(kf);
    }
}
