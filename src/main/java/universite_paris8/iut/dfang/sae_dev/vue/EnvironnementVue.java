package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.beans.value.ObservableFloatValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Ennemis;

import java.util.ArrayList;

public class EnvironnementVue {
    private Environnement environnement ;
    private TerrainVue terrainVue ;
    private JoueurVue faustVue ;
    private ArrayList<Ennemis> ennemis;
    private PointvieVue pv ;
    private EnnemisVue ennemisVue ;


    public EnvironnementVue(Environnement environnement , TilePane tilepane,Pane pane){
        this.environnement = environnement ;
        terrainVue = new TerrainVue(environnement.getTerrain(), tilepane);
        this.ennemis = environnement.getEnnemis() ;
        ObservableList<Ennemis> observableList = FXCollections.observableArrayList();
        observableList.addAll(ennemis);
        observableList.addListener((ListChangeListener<? super Ennemis>) c -> {
            while (c.next()){
                if (c.wasAdded()){
                    System.out.println((Ennemis) c.getAddedSubList());
                    ennemisVue.affichage((Ennemis) c.getAddedSubList(),pane );
                }
            }
        });


    }

    public void changed(ObservableValue<? extends Ennemis> ennemis , Ennemis oldValue , Ennemis newValue){

    }



    public void initializeVue(Pane PanePrincipal){
        pv = new PointvieVue(environnement.getFaust() , PanePrincipal);
        pv.afficheVie(environnement.getFaust(),PanePrincipal);
        faustVue = new JoueurVue(environnement.getFaust(),PanePrincipal );
        faustVue.affichage(environnement.getFaust(), PanePrincipal);
        for (Ennemis value : ennemis) {
            EnnemisVue EnnemisVue = new EnnemisVue(value, PanePrincipal);
            EnnemisVue.affichage(value, PanePrincipal);
        }
    }

    public void unTourVue(){
        pv.nbrDeVie(environnement.getFaust());
        System.out.println(ennemis);
    }

}
