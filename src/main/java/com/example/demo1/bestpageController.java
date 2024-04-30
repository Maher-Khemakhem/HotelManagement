package com.example.demo1;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date; // Add import for Date class
import javafx.scene.control.DatePicker; // Add import for DatePicker class
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class bestpageController {
    private static final String url = "jdbc:mysql://localhost:3308/jdbcdemo";
    private static final String user = "root";
    private static final String pass = "";

    @FXML
    private TextField cin;
    @FXML
    private TableView<modifiereservationController.reserv> tableView;
    @FXML
    private Label result;
    @FXML
    private Label best_client;
    @FXML
    public void initialize() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)){

            String sql = "SELECT cin_client ,COUNT(*) AS nb FROM reservation GROUP BY cin_client ORDER BY nb Desc ";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            int cinn=0;
            while(resultSet.next()){
                cinn = resultSet.getInt("cin_client");
                break;
            }

            String sql1 = "SELECT nom_client FROM client WHERE cin_client=?";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setInt(1, cinn);
            ResultSet res = statement1.executeQuery();
            String nom_clientt = "";
            while(res.next()){
                nom_clientt= res.getString("nom_client") + " porteur de cin : " + cinn;
            }
            best_client.setText(nom_clientt);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void return_page(ActionEvent event) throws IOException {
        firstpage.changeScene("welcome-page.fxml","WELCOME",700,530);
    }


    @FXML
    public void show_reserv(ActionEvent event) throws IOException {
        ObservableList<modifiereservationController.reserv> data = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(cin.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Veuillez entrer le cin!");
                return;
            }
            String sql = "SELECT cin_client FROM client WHERE (?)=cin_client";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(cin.getText()));
            ResultSet resultSet = statement.executeQuery();

            int i=0;
            int cinn=0;
            while (resultSet.next()) {
                cinn = resultSet.getInt("cin_client");
                i++;
            }
            if(i==0){
                JOptionPane.showMessageDialog(null,"Client non existant");
                tableView.setVisible(false);
                return;
            }
            String sql1 = "SELECT * FROM reservation WHERE cin_client=?";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setInt(1, Integer.parseInt(cin.getText()));
            ResultSet res = statement1.executeQuery();
            while (res.next()) {
                int resnumm = Integer.parseInt(res.getString("reservation_id"));
                int num_chambree = Integer.parseInt(res.getString("num_chambre"));
                int cinclii = Integer.parseInt(res.getString("cin_client"));
                Date check_inn = res.getDate("check_in_date");
                Date check_outt = res.getDate("check_out_date");

                data.add(new modifiereservationController.reserv(resnumm, num_chambree, cinclii,check_inn,check_outt));
            }
            tableView.getColumns().clear();
            // Create columns
            TableColumn<modifiereservationController.reserv, String> reservIdCol = new TableColumn<>("Numéro reservation");
            reservIdCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNum_reserv())));

            TableColumn<modifiereservationController.reserv, String> numcham = new TableColumn<>("Numéro chambre");
            numcham.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNum_cham())));

            TableColumn<modifiereservationController.reserv, String> cin_cli = new TableColumn<>("CIN");
            cin_cli.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCin())));

            TableColumn<modifiereservationController.reserv, String> checkin = new TableColumn<>("Date check in");
            checkin.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCheck_in())));

            TableColumn<modifiereservationController.reserv, String> checkout = new TableColumn<>("Date check out");
            checkout.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCheck_out())));

            double tableViewWidth = tableView.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            reservIdCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
            numcham.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
            cin_cli.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
            checkin.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
            checkout.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
            tableView.getColumns().addAll(reservIdCol, numcham, cin_cli, checkin,checkout);
            // Set data to table
            tableView.setItems(data);
            tableView.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());
        }
        cin.setText("");

    }

}
