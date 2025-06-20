package universite_paris8.iut.dfang.sae_dev.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import universite_paris8.iut.dfang.sae_dev.model.Inventaire;
import universite_paris8.iut.dfang.sae_dev.vue.InventaireVue;

import static java.lang.Math.ceil;

public class MouseClickInv implements EventHandler<MouseEvent> {

    private Inventaire inv ;
    private InventaireVue invVue ;

    public MouseClickInv(Inventaire inv, InventaireVue invVue) {
        this.inv = inv;
        this.invVue = invVue;
    }

    /**
     * selectione la case cliquer comme case selectione
     *
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
//        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
//            System.out.println( (mouseEvent.getY() - 0) + 30  + "\n" +  ((mouseEvent.getX() - 0)+ 158) + "\n");
//            System.out.println((int) ceil(mouseEvent.getY() / 48) + "\n" + (int) ceil(mouseEvent.getX() / 48)  + "\n");
//            inv.changeCaseSelect((int) ceil(mouseEvent.getSceneY() / 16) - 1 , (int) ceil(mouseEvent.getSceneX() / 16) - 39);
//            System.out.println(inv.getCaseSelectionnee());
//        }
   }
}


