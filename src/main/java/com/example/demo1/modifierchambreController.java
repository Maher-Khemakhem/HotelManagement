package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.io.IOException;
import java.sql.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class modifierchambreController {
    private static final String url = "jdbc:mysql://localhost:3308/jdbcdemo";
    private static final String user = "root";
    private static final String pass = "";
    @FXML
    private MenuButton menu;
    @FXML
    private DatePicker check_in;
    @FXML
    private DatePicker check_out;
    @FXML
    private TextField num_cham;
    @FXML
    private TextField type;
    @FXML
    private TextField capacite;
    @FXML
    private Label result;
    @FXML
    private TextField num_cham1;
    @FXML
    private TextField type1;
    @FXML
    private TextField num_cham2;
    @FXML
    private TableView<Chambre> tableView;
    @FXML
    private TableView<Chambre> tableView1;
    @FXML
    private TableView<Chambre> tableView2;

    public void return_page(ActionEvent event) throws IOException {
        firstpage.changeScene("welcome-page.fxml","WELCOME",700,530);
    }
    public static class Chambre {
        private String num_chambre;
        private String type;
        private int capacite;

        public Chambre(String num_chambre, String type,int capacite) {
            this.num_chambre = num_chambre;
            this.type = type;
            this.capacite = capacite;
        }

        public String getNum_chambre() {
            return num_chambre;
        }

        public String gettype() {
            return type;
        }
        public int getcapacite() {
            return capacite;
        }
    }

    public void initialize() {
        initializeTableView();
        initializeTableView1();
        initializeTableView2();
    }
    public void initializeTableView(){
        ObservableList<Chambre> data = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM chambre";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String num_chambre = resultSet.getString("num_chambre");
                String typ = resultSet.getString("type_chambre");
                int cap = Integer.parseInt(resultSet.getString("capacite"));
                data.add(new Chambre(num_chambre, typ, cap));
            }
            tableView.getColumns().clear();
            // Create columns
            TableColumn<Chambre, String> numCol = new TableColumn<>("Numéro Chambre");
            numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_chambre()));

            TableColumn<Chambre, String> typeCol = new TableColumn<>("Type");
            typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettype()));

            TableColumn<Chambre, String> capCol = new TableColumn<>("Capacité");
            capCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getcapacite())));

            // Add columns to table
            tableView.getColumns().addAll(numCol, typeCol, capCol);



            double tableViewWidth = tableView.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            numCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
            typeCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.35));
            capCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.35));

            // Set data to table
            tableView.setItems(data);
            tableView.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        num_cham.setText("");
        type.setText("");
        capacite.setText("");
    }
    public void initializeTableView1(){
        ObservableList<Chambre> data = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM chambre";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String num_chambre = resultSet.getString("num_chambre");
                String typ = resultSet.getString("type_chambre");
                int cap = Integer.parseInt(resultSet.getString("capacite"));
                data.add(new Chambre(num_chambre, typ, cap));
            }
            tableView1.getColumns().clear();
            // Create columns
            TableColumn<Chambre, String> numCol = new TableColumn<>("Numéro Chambre");
            numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_chambre()));

            TableColumn<Chambre, String> typeCol = new TableColumn<>("Type");
            typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettype()));

            TableColumn<Chambre, String> capCol = new TableColumn<>("Capacité");
            capCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getcapacite())));

            // Add columns to table
            tableView1.getColumns().addAll(numCol, typeCol, capCol);



            double tableViewWidth = tableView1.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            numCol.prefWidthProperty().bind(tableView1.widthProperty().multiply(0.3));
            typeCol.prefWidthProperty().bind(tableView1.widthProperty().multiply(0.35));
            capCol.prefWidthProperty().bind(tableView1.widthProperty().multiply(0.35));

            // Set data to table
            tableView1.setItems(data);
            tableView1.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        num_cham1.setText("");
        type1.setText("");

    }
    public void initializeTableView2(){
        ObservableList<Chambre> data = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM chambre";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String num_chambre = resultSet.getString("num_chambre");
                String typ = resultSet.getString("type_chambre");
                int cap = Integer.parseInt(resultSet.getString("capacite"));
                data.add(new Chambre(num_chambre, typ, cap));
            }
            tableView2.getColumns().clear();
            // Create columns
            TableColumn<Chambre, String> numCol = new TableColumn<>("Numéro Chambre");
            numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_chambre()));

            TableColumn<Chambre, String> typeCol = new TableColumn<>("Type");
            typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettype()));

            TableColumn<Chambre, String> capCol = new TableColumn<>("Capacité");
            capCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getcapacite())));

            // Add columns to table
            tableView2.getColumns().addAll(numCol, typeCol, capCol);



            double tableViewWidth = tableView2.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            numCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.3));
            typeCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.35));
            capCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.35));

            // Set data to table
            tableView2.setItems(data);
            tableView2.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    @FXML
    public void create_cham(ActionEvent event) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(num_cham.getText().equals("")||type.getText().equals("")||capacite.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"You have some missing inputs");
                return;
            }
            String sql = "INSERT INTO chambre(num_chambre, type_chambre, capacite) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, num_cham.getText());
            statement.setString(2, type.getText());
            statement.setString(3, capacite.getText());
            int cap = Integer.parseInt(capacite.getText());
            String ty = type.getText();
            if(!ty.equals("Single")&&!ty.equals("Double")&&!ty.equals("Suite")) {
                JOptionPane.showMessageDialog(null,"type inexistant");
            }else {
                if (cap > 10) {
                    JOptionPane.showMessageDialog(null,"capcite tres eleve");
                } else {
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Insertion réussie");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Impossible d'insérer la chambre");
            ex.printStackTrace();
        }
        num_cham.setText("");
        type.setText("");
        capacite.setText("");
        initializeTableView();
        initializeTableView1();
        initializeTableView2();
    }


    @FXML
    public void update_cham(ActionEvent event) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(num_cham.getText().equals("")||type.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"You have some missing inputs");
                return;
            }
            String sql = "UPDATE chambre SET type_chambre = ? WHERE num_chambre = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            String sql1 = "SELECT * FROM chambre";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            ResultSet resultSet = statement1.executeQuery();
            boolean found = false;
            while(resultSet.next()) {
                int num = resultSet.getInt("num_chambre");
                if(num==Integer.parseInt(num_cham1.getText())) {
                    statement.setString(1, type1.getText());
                    statement.setString(2, num_cham1.getText());
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record updated successfully!");
                    found = true;
                    break;
                }
            }
            if(!found) {
                JOptionPane.showMessageDialog(null,"Le numéro de chambre n'existe pas");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: Failed to update record");

        }
        num_cham1.setText("");
        type1.setText("");

        initializeTableView();
        initializeTableView1();
        initializeTableView2();
    }


    @FXML
    public void non_reserver(ActionEvent event) throws IOException {
        ObservableList<modifierchambreController.Chambre> availableChambres = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if (check_in.getValue() == null || check_out.getValue() == null){
                JOptionPane.showMessageDialog(null,"You have some missing inputs");
                return;
            }
            String sql = "SELECT num_chambre AS num, type_chambre AS typ, capacite AS cap" +
                    " FROM chambre" +
                    " WHERE num_chambre NOT IN (" +
                    "    SELECT num_chambre" +
                    "    FROM reservation" +
                    "    WHERE (? BETWEEN check_in_date AND check_out_date) OR (? BETWEEN check_in_date AND check_out_date)" +
                    ")";

            PreparedStatement statement = conn.prepareStatement(sql);


            statement.setDate(1, java.sql.Date.valueOf(check_in.getValue()));
            statement.setDate(2,  java.sql.Date.valueOf(check_out.getValue()) );




            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String num_chambre = resultSet.getString("num");
                String type_chambre = resultSet.getString("typ");
                int capacite = resultSet.getInt("cap");

                availableChambres.add(new modifierchambreController.Chambre(num_chambre, type_chambre, capacite));
            }





            tableView2.getColumns().clear();
            // Create columns
            TableColumn<modifierchambreController.Chambre, String> numCol = new TableColumn<>("Numéro Chambre");
            numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_chambre()));

            TableColumn<modifierchambreController.Chambre, String> typeCol = new TableColumn<>("Type");
            typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettype()));

            TableColumn<modifierchambreController.Chambre, String> capCol = new TableColumn<>("Capacité");
            capCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getcapacite())));

            // Add columns to table
            tableView2.getColumns().addAll(numCol, typeCol, capCol);



            double tableViewWidth = tableView2.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            numCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.3));
            typeCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.35));
            capCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.35));

            // Set data to table
            tableView2.setItems(availableChambres);
            tableView2.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());
        }
        menu.setText("Non_Reserver");
    }
    @FXML
    public void reserver(ActionEvent event) throws IOException {
        ObservableList<modifierchambreController.Chambre> availableChambres = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if (check_in.getValue() == null || check_out.getValue() == null){
                JOptionPane.showMessageDialog(null,"You have some missing inputs");
                return;
            }
            String sql = "SELECT num_chambre AS num, type_chambre AS typ, capacite AS cap" +
                    " FROM chambre" +
                    " WHERE num_chambre IN (" +
                    "    SELECT num_chambre" +
                    "    FROM reservation" +
                    "    WHERE (? BETWEEN check_in_date AND check_out_date) OR (? BETWEEN check_in_date AND check_out_date)" +
                    ")";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(check_in.getValue()));
            statement.setDate(2,  java.sql.Date.valueOf(check_out.getValue()) );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String num_chambre = resultSet.getString("num");
                String type_chambre = resultSet.getString("typ");
                int capacite = resultSet.getInt("cap");

                availableChambres.add(new modifierchambreController.Chambre(num_chambre, type_chambre, capacite));
            }
            tableView2.getColumns().clear();
            // Create columns
            TableColumn<modifierchambreController.Chambre, String> numCol = new TableColumn<>("Numéro Chambre");
            numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_chambre()));
            TableColumn<modifierchambreController.Chambre, String> typeCol = new TableColumn<>("Type");
            typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettype()));
            TableColumn<modifierchambreController.Chambre, String> capCol = new TableColumn<>("Capacité");
            capCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getcapacite())));
            // Add columns to table
            tableView2.getColumns().addAll(numCol, typeCol, capCol);
            double tableViewWidth = tableView2.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            numCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.3));
            typeCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.35));
            capCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.35));
            // Set data to table
            tableView2.setItems(availableChambres);
            tableView2.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());
        }
        menu.setText("Reserver");
    }
    @FXML
    public void modifier_tab1(MouseEvent event) {
        if (event.getClickCount() == 1) {
            Chambre selectedItem = tableView1.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                num_cham1.setText(String.valueOf(selectedItem.getNum_chambre()));
                type1.setText(String.valueOf(selectedItem.gettype()));
            }
        }
    }
}
