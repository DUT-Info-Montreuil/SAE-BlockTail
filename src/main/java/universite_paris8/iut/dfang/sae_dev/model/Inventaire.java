package universite_paris8.iut.dfang.sae_dev.model;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;

import java.util.ArrayList;

import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Divers.*;

public class Inventaire implements EventHandler<MouseEvent> {

    private Item[] inv;
    private int[] quantite;
    private int caseSelectionnee;
    private Personnages joueur;
    private final int QUANTITE_MAX = 64 ;


    public Inventaire(int tailleInv) {
        this.caseSelectionnee = 0;
        this.inv = new Item[tailleInv];
        this.quantite = new int[tailleInv];
        for (int i = 0; i < inv.length; i++)
            inv[i] = vide;
    }

    public Item[] getInvTab() {
        return inv;
    }

    /**
     *si la case selectione est vide ajoute l'item dans la case
     * si la case est plene ajoute l'item a la premiere case libre
     *
     */
    public void ajouteAInventaire(Item item) {
        if (getItem() == vide) {
            this.inv[caseSelectionnee] = item;
        } else {
            for (int i = 0; i < inv.length; i++) {
                if (inv[i] == vide) {
                    inv[i] = item;
                    i = inv.length ;
                }
            }
        }
    }

    public Item getItem() {
        return this.inv[caseSelectionnee];
    }

    /**
     * rempli l'inventaire d'un item passer en parametre
     *
     */
    public void remplireInventaire(Item i) {
        for (int index = 0 ; index < inv.length ; index ++ ){
            if (inv[index] == vide){
                ajouteAInventaire(i);
                for (int indexQuantite = quantite[index] ; indexQuantite < QUANTITE_MAX ; indexQuantite ++  ){
                    quantite[index] += 1 ;
                }
            }
        }
    }

    public int getCaseSelectionnee() {
        return caseSelectionnee;
    }

    /**
     * affiche l'inventaire dans la console
     */
    public void aff() {
        for (int i = 0; i < inv.length; i++) {
            System.out.println(inv[i].getId() + "\n" + quantite[i] + "\n");
        }
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
