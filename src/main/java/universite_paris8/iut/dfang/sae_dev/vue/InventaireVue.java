package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Personnage.Personnages;
import universite_paris8.iut.dfang.sae_dev.model.itemCollection;

public class InventaireVue {

    private TilePane tile ;
    private TilePane items ;
    private Personnages perso ;

    public InventaireVue(TilePane tile, Personnages faust, TilePane items) {

        this.tile = tile;
        this.items = items;
        this.perso = faust;

        affichItem();
        affichCase();

    }

    /**
     * affiche les 20 case de l'inventaire
     */
    public void affichCase(){
        Image inv = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/inventaireSlot.png").toExternalForm());

        for (int i = 0; i < 20; i++) {
            ImageView Case = new ImageView(inv);

            tile.getChildren().add(Case);
        }

    }

    /**
     * affiche les items contenue dans l'inventaire
     */
    public void affichItem(){

        for (int i = 0; i < 20; i++) {


            Image item = new Image(getClass().getResource(perso.getInv().getItem().getTexture()).toExternalForm());
            ImageView itemImage = new ImageView(item);

            items.getChildren().add(itemImage);

        }

    }
}
