package universite_paris8.iut.dfang.sae_dev;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;
import org.w3c.dom.ls.LSOutput;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.vue.TerrrainVue;


public class Controleur implements Initializable {

    @FXML
    public TilePane tilepane;

    @FXML
    public Pane PanePrincipal;


    private Joueur joueur;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Terrain terrain = new Terrain();
        TerrrainVue terrrainVue = new TerrrainVue(terrain, tilepane);



        joueur = new Joueur(100, 100); // Position initiale
        joueur.actualisationDuPersonnage(PanePrincipal);

        PanePrincipal.setFocusTraversable(true);
        PanePrincipal.requestFocus();
        PanePrincipal.setOnKeyPressed(this::gererToucheClavier);
    }
    //geeihihiugufjhgfrg

    private void gererToucheClavier(KeyEvent event) {
        if (event.getCode() == KeyCode.Z) {
            joueur.yPosProperty().set(joueur.getyPos() - 10); // Haut
        } else if (event.getCode() == KeyCode.S) {
            joueur.yPosProperty().set(joueur.getyPos() + 10); // Bas
        } else if (event.getCode() == KeyCode.Q) {
            joueur.xPosProperty().set(joueur.getxPos() - 10); // Gauche
        } else if (event.getCode() == KeyCode.D) {
            joueur.xPosProperty().set(joueur.getxPos() + 10); // Droite
        }
    }


}
