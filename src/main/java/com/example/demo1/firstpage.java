package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import javafx.scene.image.Image;
public class firstpage extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("first-page.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 530);
        String css = getClass().getResource("firstpage.css").toExternalForm();
        scene.getStylesheets().add(css);
        Image image = new Image("C:\\Users\\MSI\\Desktop\\projet eng\\log.png");
        stage.getIcons().add(image);

        stage.setTitle("WELCOME");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void changeScene(String fxml, String title, int width, int height) {
        try {
            FXMLLoader loader = new FXMLLoader(firstpage.class.getResource(fxml));
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