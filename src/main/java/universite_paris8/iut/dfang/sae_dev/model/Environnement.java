package universite_paris8.iut.dfang.sae_dev.model;

import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;

import java.util.ArrayList;

public class Environnement {
    private Terrain terrain ;
    private int width, height ;
    private Joueur faust ;


    public Environnement(){
        this.terrain = new Terrain();
        this.width = 1280 ;
        this.height = 720 ;
    }
}
