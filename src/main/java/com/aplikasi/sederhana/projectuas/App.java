package com.aplikasi.sederhana.projectuas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    double x,y;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();;
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getSceneX()-x);
            primaryStage.setY(event.getSceneY()-y);
        });
        primaryStage.setScene(new Scene(root,700,550));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}