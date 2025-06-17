package universite_paris8.iut.dfang.sae_dev.vue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;

public class TerrainVue {

    private Terrain terrain;
    private TilePane tilePane;

    final Image ciel = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/ciel.png").toExternalForm());
    final Image herbe = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/herbe.png").toExternalForm());
    final Image terre = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/terre.png").toExternalForm());
    final Image feuille = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/feuille.png").toExternalForm());
    final Image fer = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/fer.png").toExternalForm());
    final Image charbon = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/charbon.png").toExternalForm());
    final Image bois = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/bois.png").toExternalForm());
    final Image pierre = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/pierre.png").toExternalForm());
    final Image Dcoin = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/Dcoin.png").toExternalForm());
    final Image Gcoin = new Image(getClass().getResource("/universite_paris8/iut/dfang/sae_dev/block/Gcoin.png").toExternalForm());

    public TerrainVue(Terrain terrain, TilePane tilePane) {
        this.terrain = terrain;
        this.tilePane = tilePane;
        this.createTerrain();


    }

    public void createTerrain(){

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

    public void updateBlockTexture(int x , int y ,  int codeBlock){
         tilePane.getChildren().remove((x * terrain.largeur()) + y);
        switch (terrain.codeTuile(x,y)){
            case 1 :
                tilePane.getChildren().add( x * terrain.largeur() + y ,  new ImageView(ciel)  );
                break ;
            case 2 :

                tilePane.getChildren().add(x * terrain.largeur() + y ,new ImageView(herbe));

                break;
            case 3 :
                tilePane.getChildren().add(x * terrain.largeur() + y ,new ImageView(terre));
                break;
            case 4 :
                tilePane.getChildren().add(x * terrain.largeur() + y ,new ImageView(feuille));
                break ;
            case 5 :
                tilePane.getChildren().add(x * terrain.largeur() + y ,new ImageView(bois));
                break ;
            case 6 :
                tilePane.getChildren().add(x * terrain.largeur() + y ,new ImageView(pierre));
                break ;
            case 7 :
                tilePane.getChildren().add(x * terrain.largeur() + y ,new ImageView(charbon));
                break ;
            case 8 :
                tilePane.getChildren().add(x * terrain.largeur() + y ,new ImageView(fer));
                break ;
        }
//         tilePane.getChildren().add(tile , codeBlock );
    }

}
