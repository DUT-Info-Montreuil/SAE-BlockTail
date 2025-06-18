package universite_paris8.iut.dfang.sae_dev.model;

import javafx.animation.Timeline;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.controller.KeyPressed;
import universite_paris8.iut.dfang.sae_dev.controller.KeyReleased;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Ennemis;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;
import universite_paris8.iut.dfang.sae_dev.vue.EnnemisVue;
import universite_paris8.iut.dfang.sae_dev.vue.JoueurVue;
import java.util.ArrayList;

public class Environnement {
    private Terrain terrain ;
    private Joueur faust ;
    private JoueurVue faustVue ;
    private EnnemisVue Bobvue ;
    private Ennemis Bob ;
    private ArrayList<Personnages> personnages ;


    public Environnement(){
        this.terrain = new Terrain();
        this.faust = new Joueur(this);
        this.personnages = new ArrayList<>() ;
        this.personnages.add(faust);
        this.personnages.add(Bob);
    }

    public void unTour(){
        this.getFaust().direction();
        this.getFaust().appliquerPhysique();
    }

    public void initialize(Pane PanePrincipal , Timeline gameLoop){
        faustVue = new JoueurVue(this.getFaust(),PanePrincipal , gameLoop);
        faustVue.affichage(this.getFaust(), PanePrincipal);

        PanePrincipal.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(this.getFaust(), gameLoop));
        PanePrincipal.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased(this.getFaust(), gameLoop));
        PanePrincipal.setFocusTraversable(true);
        PanePrincipal.requestFocus();
        gameLoop.play();
    }

    public Joueur getFaust() {
        return faust;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public ArrayList<Personnages> getPersonnages() {
        return personnages;
    }
}
