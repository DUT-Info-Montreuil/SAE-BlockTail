package universite_paris8.iut.dfang.sae_dev.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import universite_paris8.iut.dfang.sae_dev.model.Item;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Joueur;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;
import universite_paris8.iut.dfang.sae_dev.model.itemCollection;
import universite_paris8.iut.dfang.sae_dev.vue.TerrainVue;

import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Block.*;
import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Divers.*;
import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Arme.*;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

public class MouseClickBlock implements EventHandler<MouseEvent> {

    private Terrain terrain;
    private Personnages p;
    private TerrainVue terrainVue ;


    public MouseClickBlock(Terrain ter , Personnages p , TerrainVue terVue) {
        this.terrain = ter ;
        this.p = p ;
        this.terrainVue = terVue ;
    }

    @Override
    public void handle(MouseEvent mouseEvent ) {


        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            System.out.println(mouseEvent.getSceneX() + "  " + mouseEvent.getSceneY() + "\n");
            System.out.println((int) ceil(mouseEvent.getSceneX() / 16) + "  " + (int) ceil(mouseEvent.getSceneY() / 16) + "\n");
            System.out.println(terrain.codeTuile((int) ceil(mouseEvent.getSceneY() / 16) - 1, (int) ceil(mouseEvent.getSceneX() / 16) - 1));
            terrain.casseBlock((int) ceil(mouseEvent.getSceneY() / 16) - 1 , (int) ceil(mouseEvent.getSceneX() / 16) - 1);
            System.out.println("done");
            System.out.println(terrain.codeTuile((int) ceil(mouseEvent.getSceneY() / 16) - 1, (int) ceil(mouseEvent.getSceneX() / 16) - 1));
            terrainVue.updateBlockTexture(((int) ceil(mouseEvent.getSceneY() / 16) - 1) , (int) ceil(mouseEvent.getSceneX() / 16) - 1 , 1 );

        }
        else if (mouseEvent.getButton() == MouseButton.SECONDARY){
            itemCollection.Block i ;
            if (p.getInv().getInvTab()[p.getInv().getCaseSelectionnee()].getType() == 0){
                i = (itemCollection.Block) p.getInv().getInvTab()[p.getInv().getCaseSelectionnee()];
                System.out.println(terrain.codeTuile((int) ceil(mouseEvent.getSceneY() / 16) - 1, (int) ceil(mouseEvent.getSceneX() / 16) - 1));
                terrain.placeBlock((int) ceil(mouseEvent.getSceneY() / 16) - 1 , (int) ceil(mouseEvent.getSceneX() / 16) - 1 , i.getCodeBlock() );
                System.out.println(terrain.codeTuile((int) ceil(mouseEvent.getSceneY() / 16) - 1, (int) ceil(mouseEvent.getSceneX() / 16) - 1));
                terrainVue.updateBlockTexture(((int) ceil(mouseEvent.getSceneY() / 16) - 1) , (int) ceil(mouseEvent.getSceneX() / 16) - 1 , i.getCodeBlock() );


            }
        }
    }
}
