package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class modifierclient extends Application{
    private static Stage stg;
    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modifier-client.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 530);
        String css = getClass().getResource("design.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Modifier-client");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void changeScene(String fxmlFileName, String title,int width,int height) {
        try {
            FXMLLoader loader = new FXMLLoader(modifierclient.class.getResource(fxmlFileName));
            Parent root = loader.load();
            stg.setScene(new Scene(root,width,height));
            stg.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
