package universite_paris8.iut.dfang.sae_dev.model.Personnage;

import universite_paris8.iut.dfang.sae_dev.model.Environnement;
import universite_paris8.iut.dfang.sae_dev.model.Terrain;

public class Ennemis extends Personnages{

    private int ID = 0;
    private Environnement environnement ;

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
    }

    public void toucher(){
        int distanceX = this.getxPos() - environnement.getFaust().getxPos() ;
        int distanceY = this.getyPos() - environnement.getFaust().getyPos() ;

        if (distanceX == 0 && distanceY == 0){
            environnement.getFaust().setPv(environnement.getFaust().getPv() - 1);
        }
    }

    public int getID() {
        return ID;
    }
}
