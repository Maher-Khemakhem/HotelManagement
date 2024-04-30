package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.*;

public class welcomepageController {
    private static final String url = "jdbc:mysql://localhost:3308/jdbcdemo";
    private static final String user = "root";
    private static final String pass = "";

    @FXML
    private Button chambreid;
    @FXML
    private Button clientid;
    @FXML
    private Button reservatinid;
    public void modifier_chambre(ActionEvent event) throws IOException {
        firstpage.changeScene("modifier-chambre.fxml","Modifier chambre",700,530);
    }
    public void modifier_client(ActionEvent event) throws IOException {
        firstpage.changeScene("modifier-client.fxml","Modifier client",700,530);
    }
    public void modifier_reservation(ActionEvent event) throws IOException {
        firstpage.changeScene("modifier-reservation.fxml","Modifier reservation",700,530);
    }
    public void analyse_page(ActionEvent event) throws IOException {
        firstpage.changeScene("best-page.fxml","Analyse page",700,530);
    }
    public void logout(ActionEvent event) throws IOException{
        firstpage.changeScene("login-view.fxml","Login",700,530);
    }

}
