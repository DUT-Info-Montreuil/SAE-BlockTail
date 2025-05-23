package universite_paris8.iut.dfang.sae_dev.model;

import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;

import java.util.ArrayList;

public class Environnement {
    private Terrain terrain ;
    private int width, height ; // TODO à mettre dans Terrain
    private Joueur faust ;
    private ArrayList<Personnages> personnages ;


    public Environnement(){
        this.terrain = new Terrain();
        this.width = Terrain.TAILLE_TUILES * terrain.hauteur();
        this.height = Terrain.TAILLE_TUILES * terrain.largeur();
        this.faust = new Joueur(this);
        this.personnages = new ArrayList<>() ;
        this.personnages.add(faust);
    }

    public Joueur getFaust() {
        return faust;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<Personnages> getPersonnages() {
        return personnages;
    }
}
