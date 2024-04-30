package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;


public class firstpageController {
    @FXML
    public void login(ActionEvent event){
        firstpage.changeScene("login-view.fxml","Login",700,530);
    }
    @FXML
    public void signup(ActionEvent event) throws IOException{
        firstpage.changeScene("sign-up.fxml","Sign up",700,530);
    }
}
