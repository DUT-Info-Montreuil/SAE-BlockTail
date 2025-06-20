module universite_paris.iut.dfang.sae_dev {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires eu.hansolo.tilesfx;
    requires jdk.jdi;
    requires jdk.jshell;
    requires org.junit.jupiter.api;
    requires junit;


    opens universite_paris8.iut.dfang.sae_dev to javafx.fxml;
    exports universite_paris8.iut.dfang.sae_dev;
    exports universite_paris8.iut.dfang.sae_dev.controller;
    opens universite_paris8.iut.dfang.sae_dev.controller to javafx.fxml;


}