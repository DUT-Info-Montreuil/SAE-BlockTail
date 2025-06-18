package universite_paris8.iut.dfang.sae_dev.model;

public class itemCollection {


    public enum Block implements Item{




        terre(        "Block de terre"     , 1 , "/universite_paris8/iut/dfang/sae_dev/item/terreItem.png"        , 3 ),
        herbe(        "Block d'herbe "     , 2 , "/universite_paris8/iut/dfang/sae_dev/item/herbeItem.png"        , 2 ),
        pierre(       "Block de pierre"    , 3 , "/universite_paris8/iut/dfang/sae_dev/item/pierreItem.png"       , 6 ),
        charbon(      "minerai de charbon" , 4 , "/universite_paris8/iut/dfang/sae_dev/item/charbonItem.png"      , 8 ),
        fer(          "minerai de fer"     , 5 , "/universite_paris8/iut/dfang/sae_dev/item/ferItem.png"          , 7 ),
        bois(         "Block de bois"      , 6 , "/universite_paris8/iut/dfang/sae_dev/item/boisItem.png"         , 5 ),
        planche(      "Block de planche"   , 7 , "/universite_paris8/iut/dfang/sae_dev/item/plancheItem.png"      , 9 ),
        feuille(      "Block de feuille"   , 8 , "/universite_paris8/iut/dfang/sae_dev/item/feuilleItem.png"      , 4 ),
        brique_pierre("brique de pierre "  , 9 , "/universite_paris8/iut/dfang/sae_dev/item/briquePierreItem.png" , 10),
        ;


        private final String nom;
        private final int id;
        private final String texture;
        private final int codeBlock ;


        Block(String nom, int id , String texture , int codeBlock){
            this.nom = nom;
            this.id = id;
            this.texture = texture;
            this.codeBlock = codeBlock ;
        }

        @Override
        public int getId() {
            return this.id;
        }


        @Override
        public String getTexture() {
            return this.texture;
        }

        public int getCodeBlock() {
            return this.codeBlock;
        }

        @Override
        public int getType() {
            return 0;
        }

        public Block getThis(){
            return this;
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

        @Override
        public int getType() {
            return 1;
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

        @Override
        public int getType() {
            return 2;
        }
    }
}
