package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class welcomepage extends Application {
    private static Stage stg;
    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("welcome-page.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 530);
        stage.setTitle("WELCOME");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
