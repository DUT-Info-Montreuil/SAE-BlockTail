package universite_paris8.iut.dfang.sae_dev.controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import org.controlsfx.control.PropertySheet;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.vue.InventaireVue;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;
import universite_paris8.iut.dfang.sae_dev.vue.TerrainVue;
import universite_paris8.iut.dfang.sae_dev.model.itemCollection;

import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Block.*;
import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Divers.*;
import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Arme.*;


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

    @FXML
    public TilePane caseInventaire;

    @FXML
    public TilePane items;

    @FXML
    public Pane contienInventaire ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initAnimation();


        environnement = new Environnement( items , caseInventaire , new Terrain());

        TerrainVue terrrainVue = new TerrainVue(environnement.getTerrain(), tilepane);

        faustVue = new PersonnagesVue(environnement.getFaust(),PanePrincipal);
        faustVue.affichage(environnement.getFaust(), PanePrincipal);

        caseInventaire.setPrefSize(10 * 16, 2 * 16);
        items.setPrefSize(10 * 16, 2 * 16);

        environnement.getFaust().getInv().remplireInventaire(terre);

        InventaireVue inv = new InventaireVue(caseInventaire  , environnement.getFaust() , items);

        PanePrincipal.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(environnement.getFaust()));
        PanePrincipal.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased(environnement.getFaust()));
        PanePrincipal.setFocusTraversable(true);
        PanePrincipal.requestFocus();

        contienInventaire.addEventHandler(MouseEvent.MOUSE_CLICKED , new MouseClickInv());

        environnement.getFaust().getInv().aff();

        tilepane.addEventHandler(MouseEvent.MOUSE_CLICKED , new MouseClickBlock(environnement.getTerrain() ,environnement.getFaust() , terrrainVue));

        gameLoop.play();
    }

    private void initAnimation(){
        gameLoop = new Timeline();
        temps = 0 ;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(Duration.seconds(0.017),(ev ->{

            environnement.unTour();


        }));
        gameLoop.getKeyFrames().add(kf);
    }
}
