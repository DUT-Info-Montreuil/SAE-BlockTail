package universite_paris8.iut.dfang.sae_dev.model;

import javafx.animation.Timeline;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.controller.KeyPressed;
import universite_paris8.iut.dfang.sae_dev.controller.KeyReleased;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Ennemis;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

import java.util.*;

public class Environnement {
    private Terrain terrain ;
    private Joueur faust ;
    private ArrayList<Ennemis> ennemis ;
    private int temps = 0 ;



    public Environnement(){
        this.terrain = new Terrain();
        this.faust = new Joueur(this);
        this.ennemis = new ArrayList<Ennemis>();
        ennemis.add(new Ennemis(this));
    }

    public void unTour(){
        this.getFaust().direction();
        this.getFaust().appliquerPhysique();

        for (Ennemis ennemi : ennemis) {
            ennemi.direction();
            ennemi.appliquerPhysique();
            ennemi.deplacement();
        }
        if(temps >= 60){
            temps = 0;
//            ennemis.add(new Ennemis(this));
            for (Ennemis ennemi : ennemis) {
                ennemi.toucher();
            }
            System.out.println("POP");
        }else temps++ ;
    }


    public void initialize(Pane PanePrincipal , Timeline gameLoop){
        PanePrincipal.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed( faust ));
        PanePrincipal.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased( faust));
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

    public ArrayList<Ennemis> getEnnemis() {
        return ennemis;
    }

    public int getTemps() {
        return temps;
    }
}