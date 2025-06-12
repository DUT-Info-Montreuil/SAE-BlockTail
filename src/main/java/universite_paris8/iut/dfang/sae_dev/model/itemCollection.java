package universite_paris8.iut.dfang.sae_dev.model;

import javafx.scene.image.Image;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jdk.jshell.ImportSnippet;

public class itemCollection {


    public enum Block implements Item{




        terre(        "Block de terre"     , 1 , "/universite_paris8/iut/dfang/sae_dev/item/terreItem.png"       ),
        herbe(        "Block d'herbe "     , 2 , "/universite_paris8/iut/dfang/sae_dev/item/herbeItem.png"       ),
        pierre(       "Block de pierre"    , 3 , "/universite_paris8/iut/dfang/sae_dev/item/pierreItem.png"      ),
        charbon(      "minerai de charbon" , 4 , "/universite_paris8/iut/dfang/sae_dev/item/charbonItem.png"     ),
        fer(          "minerai de fer"     , 5 , "/universite_paris8/iut/dfang/sae_dev/item/ferItem.png"         ),
        bois(         "Block de bois"      , 6 , "/universite_paris8/iut/dfang/sae_dev/item/boisItem.png"        ),
        planche(      "Block de planche"   , 7 , "/universite_paris8/iut/dfang/sae_dev/item/plancheItem.png"     ),
        feuille(      "Block de feuille"   , 8 , "/universite_paris8/iut/dfang/sae_dev/item/feuilleItem.png"     ),
        brique_pierre("brique de pierre "  , 9 , "/universite_paris8/iut/dfang/sae_dev/item/briquePierreItem.png"),
        ;


        private final String nom;
        private final int id;
        private final String texture;


        Block(String nom, int id , String texture){
            this.nom = nom;
            this.id = id;
            this.texture = texture;
        }

        @Override
        public int getId() {
            return this.id;
        }


        @Override
        public String getTexture() {
            return this.texture;
        }
    }

    public enum Arme implements Item{
        epee_bois(    "épée en bois"     , 10 , 1),
        epee_pierre(  "épée en pierre"   , 11 , 2),
        epee_fer(     "épée en fer"      , 12 , 3),
        hache_bois(   "hache en bois"    , 13 , 2),
        hache_pierre( "épée en pierre"   , 14 , 3),
        hache_fer(    "épée en fer"      , 15 , 4),
        pioche_bois(  "pioche en bois"   , 16 , 1),
        pioche_pierre("pioche en pierre" , 17 , 2),
        pioche_fer(   "pioche en fer"    , 18 , 3),
        ;


        private final String nom;
        private final int id;
        private final int degat;


        Arme(String nom, int id, int degat){
            this.nom = nom;
            this.id = id;
            this.degat = degat;
        }

        @Override
        public int getId() {
            return this.id;
        }


        @Override
        public String getTexture() {
            return null;
        }
    }


    public enum Divers implements Item{
        baton(  "bâton"   , 19 ,"/universite_paris8/iut/dfang/sae_dev/item/batonItem.png"),
        pomme(  "pomme"   , 20 ,"/universite_paris8/iut/dfang/sae_dev/item/pommeItem.png"),
        vide (  "vide"    , 999,"/universite_paris8/iut/dfang/sae_dev/item/vide.png"     ),
        ;


        private final String nom;
        private final int id;
        private final String texture;

        Divers(String nom, int id , String texture){
            this.nom = nom;
            this.id = id;
            this.texture = texture;
        }

        @Override
        public int getId() {
            return this.id;
        }

        @Override
        public String getTexture() {
            return this.texture;
        }
    }
}
