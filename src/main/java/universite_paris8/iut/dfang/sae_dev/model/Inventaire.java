package universite_paris8.iut.dfang.sae_dev.model;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;

import java.util.ArrayList;

import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Divers.*;

public class Inventaire implements EventHandler<MouseEvent> {

    private Item[] inv ;
    private int[] quantite ;
    private int caseSelectionnee ;
    private TilePane items , caseInv ;
    private Personnages joueur ;


    public Inventaire(int  tailleInv , TilePane items , TilePane caseInv) {
        this.caseSelectionnee = 1;
        this.inv = new Item[tailleInv];
        this.quantite = new int[tailleInv];
        this.items = items;
        this.caseInv = caseInv;
    }

    public int getTailleInv(){
        return this.inv.length;
    }

    public Item[] getInvTab() {
        return inv;
    }

    public void ajouteAInventaire(Item item){
        if (getItem() == vide){
            this.inv[caseSelectionnee] = item ;
        }
        else {
            for (int i = 0; i < inv.length; i++) {
                if (inv[i] == item)
                    quantite[i] += 1 ;
                else if (inv[i] == null) {
                    inv[i] = item;
                    quantite[i] = 1 ;
                }
            }
        }
    }

    public Item getItem(){
        return this.inv[caseSelectionnee];
    }

    public boolean inventairePlen(){
        for (int i = 0 ; i < inv.length ; i ++ ){
            if(inv[i] == null ){
                return false ;
            }
        }
        return true ;
    }

    public void remplireInventaire(Item i){
        while (!inventairePlen()){
            ajouteAInventaire(i);
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        double cliqueX , cliqueY ;

        cliqueX = mouseEvent.getSceneX();
        cliqueY = mouseEvent.getSceneY();
        System.out.println(cliqueX + "\n" + cliqueY);
    }

    public int getCaseSelectionnee() {
        return caseSelectionnee;
    }

    public void aff(){
        for (int i = 0 ; i < inv.length ; i++ ){
            System.out.println(inv[i].getId() + "\n" + quantite[i] + "\n");
        }
    }
}
