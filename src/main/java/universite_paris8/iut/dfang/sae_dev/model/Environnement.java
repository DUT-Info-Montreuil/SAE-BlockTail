package universite_paris8.iut.dfang.sae_dev.model;

import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;
import universite_paris8.iut.dfang.sae_dev.vue.PersonnagesVue;

import java.util.ArrayList;

public class Environnement {
    private Terrain terrain ;
    private Joueur faust ;
    private ArrayList<Personnages> personnages ;


    public Environnement(TilePane items , TilePane caseInv , Terrain terrain){
        this.terrain = terrain ;
        this.faust = new Joueur(this , items , caseInv );
        this.personnages = new ArrayList<>() ;
        this.personnages.add(faust);
    }

    public void unTour(){
        this.getFaust().direction();
        this.getFaust().appliquerPhysique();
    }

    public Joueur getFaust() {
        return this.faust;
    }

    public Terrain getTerrain() {
        return this.terrain;
    }

    public ArrayList<Personnages> getPersonnages() {
        return personnages;
    }
}
