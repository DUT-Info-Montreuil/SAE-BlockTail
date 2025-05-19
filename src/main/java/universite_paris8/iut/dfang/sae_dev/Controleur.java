package universite_paris8.iut.dfang.sae_dev;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;
import org.w3c.dom.ls.LSOutput;
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



        joueur = new Joueur(100, 100); // Position initiale
        joueur.actualisationDuPersonnage(PanePrincipal);

        PanePrincipal.setFocusTraversable(true);
        PanePrincipal.requestFocus();
        PanePrincipal.setOnKeyPressed(this::gererToucheClavier);


        gameLoop.play();
    }
    //geeihihiugufjhgfrg

    private void gererToucheClavier(KeyEvent event) {
        if (event.getCode() == KeyCode.Z) {
            joueur.deplacerHaut();     // Haut
        } else if (event.getCode() == KeyCode.S) {
            joueur.deplacerBas(); // Bas
        } else if (event.getCode() == KeyCode.Q) {
            joueur.deplacerGauche(); // Gauche
        } else if (event.getCode() == KeyCode.D) {
            joueur.deplacerDroite(); // Droite
        }
    }

    private void initAnimation(){
        Joueur joueur = new Joueur(0,0);
        gameLoop = new Timeline();
        temps = 0 ;
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(Duration.seconds(0.017),(ev ->{
            joueur.actualisationDuPersonnage(PanePrincipal);
            gererToucheClavier();
        }));
        gameLoop.getKeyFrames().add(kf);
    }
}
