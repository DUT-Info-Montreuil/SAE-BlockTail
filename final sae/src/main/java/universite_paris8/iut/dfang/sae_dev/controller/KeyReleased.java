package universite_paris8.iut.dfang.sae_dev.controller;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;



import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

public class KeyReleased implements EventHandler<KeyEvent> {

    private Joueur faust;
    private Timeline gameLoop;

    public KeyReleased(Joueur joueur , Timeline gameLoop){
        this.faust = joueur ;
        this.gameLoop = gameLoop ;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case Z:
                faust.setEnHaut(false);
                faust.setEtat(0); // Revenir à l'immobile
                break;
            case Q:
                faust.setaGauche(false);
                faust.setEtat(0);
                break;
            case D:
                faust.setaDroite(false);
                faust.setEtat(0);
                break;
        }
    }
}
