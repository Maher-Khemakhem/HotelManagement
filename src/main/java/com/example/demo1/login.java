package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class login extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 530);
        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void changeScene(String fxml, String title, int width, int height) {
        try {
            FXMLLoader loader = new FXMLLoader(login.class.getResource(fxml));
            Parent root = loader.load();
            stg.setScene(new Scene(root, width, height));
            stg.setTitle(title);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }


}