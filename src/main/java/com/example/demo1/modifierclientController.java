package com.example.demo1;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
public class modifierclientController {
    private static final String url = "jdbc:mysql://localhost:3308/jdbcdemo";
    private static final String user = "root";
    private static final String pass = "";
    @FXML
    private TextField cin;
    @FXML
    private TextField nom;
    @FXML
    private TextField ville;
    @FXML
    private TextField tel;
    @FXML
    private Label result;
    @FXML
    private TextField cin1;
    @FXML
    private TextField ville1;
    @FXML
    private TextField tel1;
    @FXML
    private TextField cin2;
    @FXML
    private TableView<clien> tableView;
    @FXML
    private TableView<clien> tableView1;
    @FXML
    private TableView<clien> tableView2;
    public void return_page(ActionEvent event) throws IOException {
        firstpage.changeScene("welcome-page.fxml","WELCOME",700,530);
    }

    public static class clien {
        private String cin;
        private String nom;
        private String ville;
        private String tel;

        public clien(String cin, String nom,String ville,String tel) {
            this.cin = cin;
            this.nom = nom;
            this.ville = ville;
            this.tel = tel;

        }

        public String getcin() {
            return cin;
        }

        public String getnom() {
            return nom;
        }
        public String getville() {
            return ville;
        }
        public String gettel() {
            return tel;
        }
    }

    public void initialize() {
        initializeTableView();
        initializeTableView1();
        initializeTableView2();
    }

    public void initializeTableView() {
        ObservableList<clien> data = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM client";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String ci = resultSet.getString("cin_client");
                String nm = resultSet.getString("nom_client");
                String vl = resultSet.getString("ville_client");
                String tell = resultSet.getString("telephone_client");
                data.add(new clien(ci, nm, vl, tell));
            }


            // Clear previous columns
            tableView.getColumns().clear();

            // Create columns
            TableColumn<clien, String> cincol = new TableColumn<>("CIN");
            cincol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getcin()));

            TableColumn<clien, String> nomcol = new TableColumn<>("Nom");
            nomcol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getnom()));

            TableColumn<clien, String> villecol = new TableColumn<>("Ville");
            villecol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getville()));

            TableColumn<clien, String> telcol = new TableColumn<>("TEL");
            telcol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettel()));

            double tableViewWidth = tableView.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            cincol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
            nomcol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
            villecol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
            telcol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
            // Add columns to table
            tableView.getColumns().addAll(cincol, nomcol, villecol, telcol);

            // Set data to table
            tableView.setItems(data);
            tableView.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void initializeTableView1() {
        ObservableList<clien> data = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM client";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String ci = resultSet.getString("cin_client");
                String nm = resultSet.getString("nom_client");
                String vl = resultSet.getString("ville_client");
                String tell = resultSet.getString("telephone_client");
                data.add(new clien(ci, nm, vl, tell));
            }


            // Clear previous columns
            tableView1.getColumns().clear();

            // Create columns
            TableColumn<clien, String> cincol = new TableColumn<>("CIN");
            cincol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getcin()));

            TableColumn<clien, String> nomcol = new TableColumn<>("Nom");
            nomcol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getnom()));

            TableColumn<clien, String> villecol = new TableColumn<>("Ville");
            villecol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getville()));

            TableColumn<clien, String> telcol = new TableColumn<>("TEL");
            telcol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettel()));

            double tableViewWidth = tableView1.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            cincol.prefWidthProperty().bind(tableView1.widthProperty().multiply(0.25));
            nomcol.prefWidthProperty().bind(tableView1.widthProperty().multiply(0.25));
            villecol.prefWidthProperty().bind(tableView1.widthProperty().multiply(0.25));
            telcol.prefWidthProperty().bind(tableView1.widthProperty().multiply(0.25));
            // Add columns to table
            tableView1.getColumns().addAll(cincol, nomcol, villecol, telcol);

            // Set data to table
            tableView1.setItems(data);
            tableView1.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void initializeTableView2() {
        ObservableList<clien> data = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM client";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String ci = resultSet.getString("cin_client");
                String nm = resultSet.getString("nom_client");
                String vl = resultSet.getString("ville_client");
                String tell = resultSet.getString("telephone_client");
                data.add(new clien(ci, nm, vl, tell));
            }


            // Clear previous columns
            tableView2.getColumns().clear();

            // Create columns
            TableColumn<clien, String> cincol = new TableColumn<>("CIN");
            cincol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getcin()));

            TableColumn<clien, String> nomcol = new TableColumn<>("Nom");
            nomcol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getnom()));

            TableColumn<clien, String> villecol = new TableColumn<>("Ville");
            villecol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getville()));

            TableColumn<clien, String> telcol = new TableColumn<>("TEL");
            telcol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettel()));

            double tableViewWidth = tableView2.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            cincol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.25));
            nomcol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.25));
            villecol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.25));
            telcol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.25));
            // Add columns to table
            tableView2.getColumns().addAll(cincol, nomcol, villecol, telcol);

            // Set data to table
            tableView2.setItems(data);
            tableView2.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    public void create_client(ActionEvent event) throws IOException {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(cin.getText().equals("")||ville.getText().equals("")||tel.getText().equals("")||nom.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Please fill all fields!");
                return;
            }

            String sqlInsert = "INSERT INTO client(cin_client, nom_client, ville_client, telephone_client) VALUES (?, ?, ?, ?)";
            PreparedStatement statementInsert = conn.prepareStatement(sqlInsert);
            statementInsert.setInt(1, Integer.parseInt(cin.getText()));

            statementInsert.setString(2, nom.getText());
            statementInsert.setString(3, ville.getText());
            statementInsert.setInt(4, Integer.parseInt(tel.getText()));

            statementInsert.executeUpdate();
            JOptionPane.showMessageDialog(null,"Record created successfully!");
            //result.setText("Record created successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());

        }
        cin.setText(null);
        nom.setText(null);
        ville.setText(null);
        tel.setText(null);
        initializeTableView();
        initializeTableView1();
        initializeTableView2();
    }


    @FXML
    public void update_client(ActionEvent event) throws IOException {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(cin.getText().equals("")||ville.getText().equals("")||tel.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Please fill all fields!");
                return;
            }
            String sql = "UPDATE client SET ville_client = ?,telephone_client=? WHERE cin_client=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ville1.getText());
            statement.setInt(2, Integer.parseInt(tel1.getText()));
            statement.setString(3, cin1.getText());
            statement.executeUpdate();
            //result.setText("Record updated successfully!");
            JOptionPane.showMessageDialog(null,"Record updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            //result.setText("Error: Failed to update record - " + ex.getMessage());
            JOptionPane.showMessageDialog(null,"Error: Failed to update record - " + ex.getMessage());
        }
        cin1.setText(null);
        ville1.setText(null);
        tel1.setText(null);
        initializeTableView();
        initializeTableView1();
        initializeTableView2();
    }
    @FXML
    public void delete_client(ActionEvent event) throws IOException {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(cin.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please enter cin");
                return;
            }
            String sql1 = "DELETE FROM reservation WHERE cin_client=?";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setInt(1, Integer.parseInt(cin2.getText()));
            statement1.executeUpdate();
            String sql = "DELETE FROM client WHERE cin_client = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(cin2.getText()));
            int deletedRows = statement.executeUpdate();
            if (deletedRows > 0) {
                JOptionPane.showMessageDialog(null,"Record deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null,"Record deleted successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to delete record - " + ex.getMessage());
        }
        cin2.setText(null);
        initializeTableView();
        initializeTableView1();
        initializeTableView2();
    }
    public void modifier_tab1(MouseEvent event) {
        if (event.getClickCount() == 1) {
            clien selectedItem = tableView1.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                cin1.setText(String.valueOf(selectedItem.getcin()));
                ville1.setText(String.valueOf(selectedItem.getville()));
                tel1.setText(String.valueOf(selectedItem.gettel()));
            }
        }
    }
    public void modifier_tab2(MouseEvent event) {
        if (event.getClickCount() == 1) {
            clien selectedItem = tableView2.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                cin2.setText(String.valueOf(selectedItem.getcin()));
            }
        }
    }



}
