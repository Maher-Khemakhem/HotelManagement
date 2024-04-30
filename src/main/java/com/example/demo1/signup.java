package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class signup extends Application {
    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 530);
        stage.setTitle("SIGN UP");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void changeScene(String fxml,String title,int width,int height){
        try {
            FXMLLoader loader = new FXMLLoader(signup.class.getResource(fxml));
            Parent root = loader.load();
            stg.setScene(new Scene(root, width, height));
            stg.setTitle(title);
            stg.show();
        } catch (IOException e) {
            System.out.println(15);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
