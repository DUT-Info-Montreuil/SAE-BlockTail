package universite_paris8.iut.dfang.sae_dev.model.Personnage;
import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;


public class Ennemis extends Personnages{

    private int ID = 0;
    private Environnement environnement ;
    private int compteur = 0 , mouvementAleatoire = 0 ;

    public Ennemis (Environnement environnement){
        super (100 ,500 , 100 , environnement , 1);
        this.environnement = environnement ;
        ID ++ ;
    }

    public void deplacement(){
        int distanceX = this.getxPos() - environnement.getFaust().getxPos() ;
        int distanceY = this.getyPos() - environnement.getFaust().getyPos() ;

        if(Math.abs(distanceX) < 100 && Math.abs(distanceY) < 100){
            if(distanceX < 0 ){ // D
                this.deplacerDroite();
                if(!environnement.getTerrain().estAccessible(this.getxPos() + 31 , this.getyPos()) && distanceY + Terrain.TAILLE_TUILES - 1 >= 0){
                    this.sauter();
                }
            }
            else if(distanceX > 0){ //G
                this.deplacerGauche();
                if(!environnement.getTerrain().estAccessible(this.getxPos() - 16 , this.getyPos()) && distanceY + Terrain.TAILLE_TUILES - 1 >= 0){
                    this.sauter();
                }
            }
        }
        else if(compteur < 10){
            if(mouvementAleatoire == 1){
                deplacerDroite();
                if(!environnement.getTerrain().estAccessible(this.getxPos() + 16 , this.getyPos()) && distanceY + Terrain.TAILLE_TUILES - 1 >= 0){
                    this.sauter();
                }
            }else if (mouvementAleatoire == 2) {
                deplacerGauche();
                if(!environnement.getTerrain().estAccessible(this.getxPos() - 1 , this.getyPos()) && distanceY + Terrain.TAILLE_TUILES - 1 >= 0){
                    this.sauter();
                }
            }
            compteur ++;
        }else {
            compteur = 0;
            mouvementAleatoire = (int)(Math.random() * 30);
        }
    }

    public void toucher(){
        int distanceX = this.getxPos() - environnement.getFaust().getxPos() ;
        int distanceY = this.getyPos() - environnement.getFaust().getyPos() ;

        if (distanceX == 0 && distanceY == 0){
            environnement.getFaust().setPv(environnement.getFaust().getPv() - 5);
        }
    }

    public int getID() {
        return ID;
    }





//    public class BFS {
//
//        public static class Position {
//            public final int x, y;
//
//            public Position(int x, int y) {
//                this.x = x;
//                this.y = y;
//            }
//
//            @Override
//            public String toString() {
//                return "(" + x + ", " + y + ")";
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                if (this == obj) return true;
//                if (obj == null || getClass() != obj.getClass()) return false;
//                Position position = (Position) obj;
//                return x == position.x && y == position.y;
//            }
//        }
//
//        public static Position calculerCheminBFS(Terrain terrain, int startX, int startY, int targetX, int targetY) {
//
//            int largeurTerrain = terrain.hauteur();
//            int hauteurTerrain = terrain.largeur();
//
//            ArrayList<Position> queue = new ArrayList<>();
//            boolean[][] visite = new boolean[hauteurTerrain][largeurTerrain];
//            Position[][] parent = new Position[hauteurTerrain][largeurTerrain];
//
//            Position[] directions = {
//                    new Position(1, 0),   // droite
//                    new Position(-1, 0),  // gauche
//                    new Position(0, 1),   // bas
//                    new Position(0, -1)   // haut
//            };
//
//            queue.add(new Position(startX, startY));
//            visite[startY][startX] = true;
//            parent[startY][startX] = new Position(-1, -1);
//
//            int maxIterations = 100;
//            int iterations = 0;
//
//            while (!queue.isEmpty() && iterations < maxIterations) {
//                iterations++;
//
//                Position positionActuelle = queue.remove(0);
//                int x = positionActuelle.x;
//                int y = positionActuelle.y;
//
//                if (x == targetX && y == targetY) {
//                    return reconstruirePremierMouvement(startX, startY, targetX, targetY, parent);
//                }
//
//                for (Position direction : directions) {
//                    int nouveauX = x + direction.x;
//                    int nouveauY = y + direction.y;
//
//                    if (coordonneesValides(terrain, nouveauX, nouveauY) &&
//                            !visite[nouveauY][nouveauX] &&
//                            positionAccessible(terrain, nouveauX, nouveauY)) {
//
//                        visite[nouveauY][nouveauX] = true;
//                        parent[nouveauY][nouveauX] = new Position(x, y);
//                        queue.add(new Position(nouveauX, nouveauY));
//                    }
//                }
//            }
//
//            return null; // Pas de chemin trouvé
//        }
//
//
//        private static Position reconstruirePremierMouvement(int startX, int startY, int targetX, int targetY, Position[][] parent) {
//            ArrayList<Position> chemin = new ArrayList<>();
//            int x = targetX;
//            int y = targetY;
//
//            while (x != startX || y != startY) {
//                chemin.add(0, new Position(x, y));
//                Position parentPos = parent[y][x];
//
//                if (parentPos.x == -1 && parentPos.y == -1) {
//                    break;
//                }
//
//                x = parentPos.x;
//                y = parentPos.y;
//            }
//
//            if (chemin.size() > 0) {
//                Position premiereCaseDeplacee = chemin.get(0);
//                int deltaX = premiereCaseDeplacee.x - startX;
//                int deltaY = premiereCaseDeplacee.y - startY;
//                return new Position(deltaX, deltaY);
//            }
//
//            return null;
//        }
//
//        private static boolean coordonneesValides(Terrain terrain, int x, int y) {
//            return x >= 0 && x < terrain.hauteur() && y >= 0 && y < terrain.largeur();
//        }
//
//        private static boolean positionAccessible(Terrain terrain, int x, int y) {
//            int pixelX = x * Terrain.TAILLE_TUILES;
//            int pixelY = y * Terrain.TAILLE_TUILES;
//            return terrain.estAccessible(pixelX, pixelY);
//        }
//    }
}
