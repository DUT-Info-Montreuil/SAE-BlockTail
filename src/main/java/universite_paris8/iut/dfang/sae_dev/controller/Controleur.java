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
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.vue.EnvironnementVue;
import universite_paris8.iut.dfang.sae_dev.vue.InventaireVue;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;
import universite_paris8.iut.dfang.sae_dev.vue.TerrainVue;

import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Block.*;


public class Controleur implements Initializable {


    private Timeline gameLoop;
    private Environnement environnement ;
    private EnvironnementVue environnementVue ;

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


    /**
     * initialise tout ce qui est utiliser au lancement du jeux
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initTimeline();

        environnement = new Environnement(  );
        environnementVue = new EnvironnementVue(environnement, tilepane, PanePrincipal , items , caseInventaire);
        environnementVue.initializeVue(PanePrincipal);

        TerrainVue terrrainVue = new TerrainVue(environnement.getTerrain(), tilepane);



        caseInventaire.setPrefSize(10 * 16, 2 * 16);
        items.setPrefSize(10 * 16, 2 * 16);

        environnement.getFaust().getInv().remplireInventaire(terre);

        InventaireVue inv = new InventaireVue(caseInventaire  , environnement.getFaust() , items);

        PanePrincipal.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(environnement.getFaust()));
        PanePrincipal.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased(environnement.getFaust()));
        PanePrincipal.setFocusTraversable(true);
        PanePrincipal.requestFocus();

        contienInventaire.addEventHandler(MouseEvent.MOUSE_CLICKED , new MouseClickInv( environnement.getFaust().getInv() , inv));

        environnement.getFaust().getInv().aff();

        tilepane.addEventHandler(MouseEvent.MOUSE_CLICKED , new MouseClickBlock(environnement.getTerrain() ,environnement.getFaust() , terrrainVue));

        gameLoop.play();
    }

    /**
     * initaialise la time loop
     */
    private void initTimeline(){
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(Duration.seconds(0.017),(ev ->{

            environnement.unTour();
            environnementVue.unTourVue();


        }));
        gameLoop.getKeyFrames().add(kf);
    }
}
