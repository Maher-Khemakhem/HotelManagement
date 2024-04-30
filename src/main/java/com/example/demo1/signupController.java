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



public class signupController {
    private static final String url = "jdbc:mysql://localhost:3308/jdbcdemo";
    private static final String user = "root";
    private static final String pass = "";

    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmpassword;
    @FXML
    private TextField num_tel;
    @FXML
    private TextField mail;

    @FXML
    public Pane signupform;

    @FXML
    public void returnlogin(ActionEvent event) throws IOException{
        firstpage.changeScene("login-view.fxml","LOGIN",700,530);
    }
    public void signup(ActionEvent event) throws IOException {
        if (!password.getText().equals(confirmpassword.getText())) {
            JOptionPane.showMessageDialog(null,"Password don't match");
            return;
        }
        if(id.getText().equals("")||nom.getText().equals("")||num_tel.getText().equals("")||mail.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please fill all the fields");
            return;
        }
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO admin VALUES (?, ?, SHA2(?, 256), ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id.getText()));
            statement.setString(2, nom.getText());
            statement.setString(3, password.getText()); // Wrong: Should pass hashed password
            statement.setString(4, num_tel.getText());
            statement.setString(5, mail.getText());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null,"Data Registered Successfully");

                firstpage.changeScene("login-view.fxml","LOGIN",700,530);
            } else {
                JOptionPane.showMessageDialog(null,"FAIL");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ID already used!");
            reset(event);
        }
    }

    public void reset(ActionEvent event) throws IOException {
        id.setText("");
        nom.setText("");
        password.setText("");
        confirmpassword.setText("");
        num_tel.setText("");
        mail.setText("");
    }

}
