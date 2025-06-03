package universite_paris8.iut.dfang.sae_dev.controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;
import universite_paris8.iut.dfang.sae_dev.vue.TerrainVue;


public class Controleur implements Initializable {


    private Timeline gameLoop;
    private int temps;
    private Environnement environnement ;
    private Joueur faust ;
    private PersonnagesVue faustVue ;

    @FXML
    public BorderPane BorderPanePrincipal;

    @FXML
    public TilePane tilepane;

    @FXML
    public Pane PanePrincipal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initAnimation();


        environnement = new Environnement();

        Terrain terrain = new Terrain();
        TerrainVue terrrainVue = new TerrainVue(terrain, tilepane);

        faustVue = new PersonnagesVue(environnement.getFaust(),PanePrincipal , gameLoop);
        faustVue.affichage(environnement.getFaust(), PanePrincipal);

        PanePrincipal.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(environnement.getFaust(), gameLoop));
        PanePrincipal.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased(environnement.getFaust(), gameLoop));
        PanePrincipal.setFocusTraversable(true);
        PanePrincipal.requestFocus();

        gameLoop.play();
    }

    private void initAnimation(){
        gameLoop = new Timeline();
        temps = 0 ;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(Duration.seconds(0.017),(ev ->{

            environnement.unTour();
            System.out.println("---------------");
        }));
        gameLoop.getKeyFrames().add(kf);
    }
}
