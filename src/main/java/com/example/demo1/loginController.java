package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class loginController {
    private static final String url = "jdbc:mysql://localhost:3308/jdbcdemo";
    private static final String user = "root";
    private static final String pass = "";

    @FXML
    private Label wronglogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginbutton;

    @FXML
    private Button resetbutton;
    @FXML
    public static Pane loginform;
    @FXML
    public void user_login(ActionEvent event) throws IOException {
        checklogin();
    }

    public void checklogin() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(username.getText().equals("") || password.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Fill all the fields");
                return;
            }
            String sql = "SELECT * FROM admin WHERE id=? AND pass = SHA2(?, 256)";
            PreparedStatement statement = conn.prepareStatement(sql);
            int userId = Integer.parseInt(username.getText()); // Assuming username field contains id
            statement.setInt(1, userId);
            statement.setString(2, password.getText());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null,"Success");
                firstpage.changeScene("welcome-page.fxml","Welcome",700,530);
            } else {
                JOptionPane.showMessageDialog(null,"Fail");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Problem");
        }
    }
    @FXML
    public void return_signup(ActionEvent event) throws IOException{
        firstpage.changeScene("sign-up.fxml","Signup",700,530);
    }
    @FXML
    public void user_reset() {
        username.setText("");
        password.setText("");
        wronglogin.setText("");
    }

}
