package universite_paris8.iut.dfang.sae_dev.model;

import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;

import java.util.ArrayList;

public class Environnement {
    private Terrain terrain ;
    private Joueur faust ;
    private ArrayList<Personnages> personnages ;


    public Environnement(){
        this.terrain = new Terrain();
        this.faust = new Joueur(this);
        this.personnages = new ArrayList<>() ;
        this.personnages.add(faust);
    }

    public void unTour(){
        this.getFaust().direction();
        this.getFaust().appliquerPhysique();
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
