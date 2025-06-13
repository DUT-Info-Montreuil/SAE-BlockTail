package universite_paris8.iut.dfang.sae_dev.controller;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

public class KeyPressed implements EventHandler<KeyEvent> {

    private Joueur faust;
    private Timeline gameLoop;

    public KeyPressed(Environnement environnement, Timeline gameLoop){
        this.faust = environnement.getFaust() ;
        this.gameLoop = gameLoop ;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case Z :
                faust.setEnHaut(true);
                break;
            case Q :
                faust.setaGauche(true);
                break;
            case D :
                faust.setaDroite(true);
                break;
        }
    }
}
