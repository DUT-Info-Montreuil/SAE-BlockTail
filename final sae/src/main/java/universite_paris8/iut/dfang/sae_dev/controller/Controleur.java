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
import universite_paris8.iut.dfang.sae_dev.vue.JoueurVue;
import universite_paris8.iut.dfang.sae_dev.vue.MenuDemarrage;
import universite_paris8.iut.dfang.sae_dev.vue.TerrainVue;


public class Controleur implements Initializable {


    private MenuDemarrage menuDemarrage;
    private Timeline gameLoop;
    private int temps;
    private Environnement environnement ;
    private Joueur faust ;
    private JoueurVue faustVue ;
    @FXML
    private Pane rootPane;  // Ce pane est celui qui contiendra tout (défini dans ton FXML)

    private MenuDemarrage menuDemarrage;
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
        environnement.initialize(PanePrincipal , gameLoop);
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




private MenuDemarrage menuDemarrage;

@FXML
public void initialize() {
    menuDemarrage = new MenuDemarrage();

    // Affiche le menu de démarrage avec une action de démarrage
    menuDemarrage.afficherMenuDemarrage(rootPane, () -> {
        // Code à exécuter quand on clique sur Start
        demarrerPartie();
    });
}

private void demarrerPartie() {
    System.out.println("Le jeu démarre !");
    // Ici tu peux lancer la boucle du jeu, initialiser l’environnement, etc.
}
}