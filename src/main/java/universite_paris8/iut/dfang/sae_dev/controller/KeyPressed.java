package universite_paris8.iut.dfang.sae_dev.controller;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

public class KeyPressed implements EventHandler<KeyEvent> {

    private Joueur faust;

    public KeyPressed(Joueur joueur){
        this.faust = joueur ;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case Z :
                faust.setEnHaut(true);//fait sauter le personage
                break;
            case Q :
                faust.setaGauche(true);//fait bouger le personage a gauche
                break;
            case D :
                faust.setaDroite(true);//fait bouger le personage a droite
                break;
        }
    }
}
