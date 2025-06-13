package universite_paris8.iut.dfang.sae_dev.model;

import static universite_paris8.iut.dfang.sae_dev.model.itemCollection.Divers.*;

public class Inventaire {

    private Item[] inv ;
    private int caseSelectionnee ;

    public Inventaire( int  tailleInv ) {
        this.caseSelectionnee = 1;
        this.inv = new Item[tailleInv];
    }

    public int getTailleInv(){
        return this.inv.length;
    }

    public Item[] getInv() {
        return inv;
    }

    public void ajouteAInventaire(Item item){
        if (getItem() == vide){
            this.inv[caseSelectionnee] = item ;
        }
        else {
            for (int i = 0; i < inv.length; i++) {
                if (inv[i] == null) {
                    inv[i] = item;
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

}
