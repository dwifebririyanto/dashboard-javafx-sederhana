package com.aplikasi.sederhana.projectuas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashboardController implements Initializable {

    @FXML
    private Label exit;
    @FXML
    private StackPane contentArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exit.setOnMouseClicked(e -> {
            System.exit(0);
        });


            try {
                Parent fxml = FXMLLoader.load(getClass().getResource("menu.fxml"));
                contentArea.getChildren().removeAll();
                contentArea.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE,null,ex);
            }


    }

    public void menu(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("menu.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void editbuku(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("editbuku.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
    public void anggota(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("anggota.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
}