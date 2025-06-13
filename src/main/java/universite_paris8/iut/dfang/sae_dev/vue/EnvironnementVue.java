package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Ennemis;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;

import java.util.ArrayList;

public class EnvironnementVue {
    private Environnement environnement ;
    private TerrainVue terrainVue ;
    private JoueurVue faustVue ;
    private ArrayList<Ennemis> Ennemis;
    private PointvieVue pv ;

    public EnvironnementVue(Environnement environnement , TilePane tilepane){
        this.environnement = environnement ;
        terrainVue = new TerrainVue(environnement.getTerrain(), tilepane);
        this.Ennemis = environnement.getEnnemis() ;
    }

    public void initializeVue(Pane PanePrincipal){
        pv = new PointvieVue(environnement.getFaust() , PanePrincipal);
        pv.afficheVie(environnement.getFaust(),PanePrincipal);
        faustVue = new JoueurVue(environnement.getFaust(),PanePrincipal );
        faustVue.affichage(environnement.getFaust(), PanePrincipal);
        for(int i = 0 ; i < Ennemis.size() ; i ++){
            EnnemisVue EnnemisVue = new EnnemisVue(Ennemis.get(i), PanePrincipal);
            EnnemisVue.affichage(Ennemis.get(i) , PanePrincipal);
        }
    }

    public void unTourVue(){
        pv.nbrDeVie(environnement.getFaust());
    }

}
