package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;

public class TerrainVue {

    private Terrain terrain;
    private TilePane tilePane;

    public TerrainVue(Terrain terrain, TilePane tilePane) {
        this.terrain = terrain;
        this.tilePane = tilePane;
        this.createTerrain();
    }

    public void createTerrain(){


        Image ciel = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/ciel.png").toExternalForm());
        Image herbe = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/herbe.png").toExternalForm());
        Image terre = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/terre.png").toExternalForm());
        Image feuille = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/feuille.png").toExternalForm());
        Image fer = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/fer.png").toExternalForm());
        Image charbon = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/charbon.png").toExternalForm());
        Image bois = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/bois.png").toExternalForm());
        Image pierre = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/pierre.png").toExternalForm());


        tilePane.setPrefSize(terrain.largeur() * Terrain.TAILLE_TUILES , terrain.hauteur() * Terrain.TAILLE_TUILES);


        for (int i = 0; i < terrain.hauteur() ; i++){
            for(int j = 0; j < terrain.largeur() ; j ++ ){
                switch (terrain.codeTuile(i,j)){
                    case 1 :
                        tilePane.getChildren().add(new ImageView(ciel));
                        break ;
                    case 2 :
                        tilePane.getChildren().add(new ImageView(herbe));
                        break;
                    case 3 :
                        tilePane.getChildren().add(new ImageView(terre));
                        break;
                    case 4 :
                        tilePane.getChildren().add(new ImageView(feuille));
                        break ;
                    case 5 :
                        tilePane.getChildren().add(new ImageView(bois));
                        break ;
                    case 6 :
                        tilePane.getChildren().add(new ImageView(pierre));
                        break ;
                    case 7 :
                        tilePane.getChildren().add(new ImageView(charbon));
                        break ;
                    case 8 :
                        tilePane.getChildren().add(new ImageView(fer));
                        break ;
                }
            }
        }
    }

}
