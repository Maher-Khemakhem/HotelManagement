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


public class modifiereservationController {
    private static final String url = "jdbc:mysql://localhost:3308/jdbcdemo";
    private static final String user = "root";
    private static final String pass = "";
    @FXML
    private MenuButton menu;
    @FXML
    private TextField num_reserv;
    @FXML
    private TextField num_cham;
    @FXML
    private TextField cin;
    @FXML
    private DatePicker check_in;
    @FXML
    private DatePicker check_out;
    @FXML
    private TableView<reserv> tableView;
    @FXML
    private TableView<modifierchambreController.Chambre> tableView1;
    @FXML
    private TextField num_reserv2;
    @FXML
    private TextField num_cham2;
    @FXML
    private TextField cin2;
    @FXML
    private DatePicker check_in2;
    @FXML
    private DatePicker check_out2;
    @FXML
    private TableView<reserv> tableView2;
    @FXML
    private TextField num_reserv3;
    @FXML
    private TableView<reserv> tableView3;
    @FXML
    private Label result;
    @FXML
    private Label result2;
    @FXML
    private Label result3;

    public static class reserv {
        private int num_reserv;
        private int num_cham;
        private int cin;
        private Date check_in;
        private Date check_out;
        reserv(int num_reserv,int num_chambre,  int cin, Date check_in, Date check_out) {
            this.num_reserv = num_reserv;
            this.num_cham = num_chambre;
            this.cin = cin;
            this.check_in = check_in;
            this.check_out = check_out;
        }

        public int getNum_reserv() {
            return num_reserv;
        }

        public int getNum_cham() {
            return num_cham;
        }

        public int getCin() {
            return cin;
        }

        public Date getCheck_in() {
            return check_in;
        }

        public Date getCheck_out() {
            return check_out;
        }
    }
    public void return_page(ActionEvent event) throws IOException {
        firstpage.changeScene("welcome-page.fxml","WELCOME",700,530);
    }
    public void initialize() {
        initializeTableView();
        initializeTableView2();
        initializeTableView3();
    }
    public void initializeTableView(){
        ObservableList<reserv> data = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM reservation";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int resnum = Integer.parseInt(resultSet.getString("reservation_id"));
                int num_chambre = Integer.parseInt(resultSet.getString("num_chambre"));
                int cincli = Integer.parseInt(resultSet.getString("cin_client"));
                Date check_in = resultSet.getDate("check_in_date");
                Date check_out = resultSet.getDate("check_out_date");

                data.add(new reserv(resnum, num_chambre, cincli,check_in,check_out));
            }
            tableView.getColumns().clear();
            // Create columns
            TableColumn<reserv, String> reservIdCol = new TableColumn<>("N° reservation");
            reservIdCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNum_reserv())));

            TableColumn<reserv, String> numcham = new TableColumn<>("N° chambre");
            numcham.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNum_cham())));

            TableColumn<reserv, String> cin_cli = new TableColumn<>("CIN");
            cin_cli.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCin())));

            TableColumn<reserv, String> checkin = new TableColumn<>("check in");
            checkin.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCheck_in())));

            TableColumn<reserv, String> checkout = new TableColumn<>("check out");
            checkout.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCheck_out())));

            double tableViewWidth = tableView.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            reservIdCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.2));
            numcham.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.2));
            cin_cli.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.1));
            checkin.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.25));
            checkout.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.25));
            tableView.getColumns().addAll(reservIdCol, numcham, cin_cli, checkin,checkout);
            // Set data to table
            tableView.setItems(data);
            tableView.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        num_cham.setText("");


    }
    public void initializeTableView2(){
        ObservableList<reserv> data = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM reservation";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int resnum = Integer.parseInt(resultSet.getString("reservation_id"));
                int num_chambre = Integer.parseInt(resultSet.getString("num_chambre"));
                int cincli = Integer.parseInt(resultSet.getString("cin_client"));
                Date check_in = resultSet.getDate("check_in_date");
                Date check_out = resultSet.getDate("check_out_date");

                data.add(new reserv(resnum, num_chambre, cincli,check_in,check_out));
            }
            tableView2.getColumns().clear();
            // Create columns
            TableColumn<reserv, String> reservIdCol = new TableColumn<>("N° reservation");
            reservIdCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNum_reserv())));

            TableColumn<reserv, String> numcham = new TableColumn<>("N° chambre");
            numcham.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNum_cham())));

            TableColumn<reserv, String> cin_cli = new TableColumn<>("CIN");
            cin_cli.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCin())));

            TableColumn<reserv, String> checkin = new TableColumn<>("check in");
            checkin.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCheck_in())));

            TableColumn<reserv, String> checkout = new TableColumn<>("check out");
            checkout.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCheck_out())));

            double tableViewWidth = tableView2.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            reservIdCol.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.2));
            numcham.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.2));
            cin_cli.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.1));
            checkin.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.25));
            checkout.prefWidthProperty().bind(tableView2.widthProperty().multiply(0.25));
            tableView2.getColumns().addAll(reservIdCol, numcham, cin_cli, checkin,checkout);
            // Set data to table
            tableView2.setItems(data);
            tableView2.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        num_cham.setText("");


    }
    public void initializeTableView3(){
        ObservableList<reserv> data = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM reservation";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int resnum = Integer.parseInt(resultSet.getString("reservation_id"));
                int num_chambre = Integer.parseInt(resultSet.getString("num_chambre"));
                int cincli = Integer.parseInt(resultSet.getString("cin_client"));
                Date check_in = resultSet.getDate("check_in_date");
                Date check_out = resultSet.getDate("check_out_date");

                data.add(new reserv(resnum, num_chambre, cincli,check_in,check_out));
            }
            tableView3.getColumns().clear();
            // Create columns
            TableColumn<reserv, String> reservIdCol = new TableColumn<>("N° reservation");
            reservIdCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNum_reserv())));

            TableColumn<reserv, String> numcham = new TableColumn<>("N° chambre");
            numcham.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNum_cham())));

            TableColumn<reserv, String> cin_cli = new TableColumn<>("CIN");
            cin_cli.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCin())));

            TableColumn<reserv, String> checkin = new TableColumn<>("check in");
            checkin.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCheck_in())));

            TableColumn<reserv, String> checkout = new TableColumn<>("check out");
            checkout.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCheck_out())));

            double tableViewWidth = tableView3.getWidth(); // Get the width of the TableView
            double columnWidth = tableViewWidth * 0.25; // Calculate 25% of the TableView width

            // Set the preferred width for each column
            reservIdCol.prefWidthProperty().bind(tableView3.widthProperty().multiply(0.2));
            numcham.prefWidthProperty().bind(tableView3.widthProperty().multiply(0.2));
            cin_cli.prefWidthProperty().bind(tableView3.widthProperty().multiply(0.2));
            checkin.prefWidthProperty().bind(tableView3.widthProperty().multiply(0.2));
            checkout.prefWidthProperty().bind(tableView3.widthProperty().multiply(0.2));
            tableView3.getColumns().addAll(reservIdCol, numcham, cin_cli, checkin,checkout);
            // Set data to table
            tableView3.setItems(data);
            tableView3.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        num_cham.setText("");


    }
    @FXML
    public void create_reserv(ActionEvent event) throws IOException {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(num_reserv.getText().equals("")||num_cham.getText().equals("")||cin.getText().equals("")||
                    check_in.getValue()==null||check_out.getValue()==null){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
                return;
            }
            String sqlInsert = "INSERT INTO reservation(reservation_id, num_chambre, cin_client, check_in_date, check_out_date)" +
                    " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statementInsert = conn.prepareStatement(sqlInsert);
            statementInsert.setInt(1, Integer.parseInt(num_reserv.getText()));
            statementInsert.setInt(2, Integer.parseInt(num_cham.getText()));
            statementInsert.setInt(3, Integer.parseInt(cin.getText()));

            // Convert DatePicker values to java.sql.Date
            java.sql.Date checkInDate = java.sql.Date.valueOf(check_in.getValue());
            java.sql.Date checkOutDate = java.sql.Date.valueOf(check_out.getValue());
            statementInsert.setDate(4, checkInDate);
            statementInsert.setDate(5, checkOutDate);
            String sql = "SELECT COUNT(*) AS nb FROM reservation WHERE num_chambre = (?) AND " +
                    "((? < check_in_date AND ? < check_out_date) OR (? > check_in_date AND ? > check_out_date))";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,Integer.parseInt(num_cham.getText()));
            stmt.setDate(2,checkOutDate);
            stmt.setDate(3,checkOutDate);
            stmt.setDate(4,checkInDate);
            stmt.setDate(5,checkInDate);
            ResultSet rs = stmt.executeQuery();
            String sql1 = "SELECT COUNT(*) AS nomb FROM chambre WHERE num_chambre = (?)";
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setInt(1,Integer.parseInt(num_cham.getText()));
            ResultSet rss = stmt1.executeQuery();
            int res=-1;
            while(rs.next()) {
                res = rs.getInt("nb");
            }
            int ress=-1;
            while(rss.next()){
                ress = rss.getInt("nomb");
            }
            if(res==0&&ress==1){
                statementInsert.executeUpdate();
                JOptionPane.showMessageDialog(null,"Record created successfully!");

                num_reserv.setText(null);
                num_cham.setText(null);
                cin.setText(null);
                check_in.setValue(null);
                check_out.setValue(null);
            }else if (res!=0){
                JOptionPane.showMessageDialog(null,"La chambre n'est pas vide!");
            }
            else{
                JOptionPane.showMessageDialog(null,"La chambre n'existe pas !");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());
        }
        initializeTableView();
        initializeTableView2();
        initializeTableView3();
    }
    @FXML
    public void update_reserv(ActionEvent event) throws IOException {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(num_reserv2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Il faut entrer le numéro de reservation");
                return;
            }
            if(check_in.getValue()==null||check_out.getValue()==null){
                JOptionPane.showMessageDialog(null,"Please fill all the fields!");
                return;
            }
            String sqlUpdate = "UPDATE reservation SET num_chambre=?, check_in_date=?, check_out_date=? WHERE reservation_id=?";
            PreparedStatement updateStatement = conn.prepareStatement(sqlUpdate);
            String sql2 = "SELECT * FROM chambre JOIN reservation ON chambre.num_chambre = reservation.num_chambre " +
                    "WHERE reservation_id=(?)";
            PreparedStatement selectStatement2 = conn.prepareStatement(sql2);
            selectStatement2.setInt(1, Integer.parseInt(num_reserv2.getText()));
            ResultSet resultSet1 = selectStatement2.executeQuery();
            int chambreNumber=0;
            java.sql.Date checkInDatee = null;
            java.sql.Date checkOutDatee = null;
            while (resultSet1.next()) {
                chambreNumber = resultSet1.getInt("num_chambre");
                checkInDatee = resultSet1.getDate("check_in_date");
                checkOutDatee = resultSet1.getDate("check_out_date");
            }
            if(num_cham2.getText().isEmpty()){
                updateStatement.setInt(1, chambreNumber);
            }
            else{
                updateStatement.setInt(1, Integer.parseInt(num_cham2.getText()));
            }
            java.sql.Date checkInDate = (check_in2.getValue() != null) ? java.sql.Date.valueOf(check_in2.getValue()) : null;
            java.sql.Date checkOutDate = (check_out2.getValue() != null) ? java.sql.Date.valueOf(check_out2.getValue()) : null;
            java.sql.Date checkindateee=null;
            java.sql.Date checkoutdateee=null;
            if (checkInDate != null) {
                updateStatement.setDate(2, checkInDate);
                checkindateee=checkInDate;
            } else {
                updateStatement.setDate(2, checkInDatee);
                checkindateee=checkInDatee;
            }
            if (checkOutDate != null) {
                updateStatement.setDate(3, checkOutDate);
                checkoutdateee=checkOutDate;
            } else {
                updateStatement.setDate(3, checkOutDatee);
                checkoutdateee=checkOutDatee;
            }
            updateStatement.setInt(4, Integer.parseInt(num_reserv2.getText()));
            // Prepare the SELECT statement to check for room availability
            String sqlSelect = "SELECT COUNT(*) AS nb FROM chambre " +
                    "JOIN reservation ON chambre.num_chambre = reservation.num_chambre " +
                    "WHERE ((? < check_in_date AND ? < check_out_date) OR (? > check_in_date AND ? > check_out_date)) " +
                    "AND reservation.num_chambre=?";
            PreparedStatement selectStatement = conn.prepareStatement(sqlSelect);

            selectStatement.setDate(1, checkindateee);
            selectStatement.setDate(2, checkoutdateee);
            selectStatement.setDate(3, checkindateee);
            selectStatement.setDate(4, checkoutdateee);
            selectStatement.setInt(5, Integer.parseInt(num_cham2.getText()));
            // Execute the SELECT statement
            ResultSet resultSet = selectStatement.executeQuery();
            int availableRooms = 0;
            while (resultSet.next()) {
                availableRooms = resultSet.getInt("nb");
            }
            if (availableRooms > 0) {

                updateStatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Record updated successfully!");

                num_reserv2.setText(null);
                num_cham2.setText(null);
                cin2.setText(null);
                check_in2.setValue(null);
                check_out2.setValue(null);
            } else {
                JOptionPane.showMessageDialog(null,"Update impossible: No available rooms for the specified dates.");

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());
        }
        initializeTableView();
        initializeTableView2();
        initializeTableView3();
    }


    @FXML
    public void delete_reserv(ActionEvent event) throws IOException {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(num_reserv.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please enter a reservation number!");
                return;
            }
            String sql = "DELETE FROM reservation WHERE reservation_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, num_reserv3.getText());
            int deletedRows = statement.executeUpdate();
            if (deletedRows > 0) {
                JOptionPane.showMessageDialog(null,"Record deleted successfully!");

            } else {
                JOptionPane.showMessageDialog(null,"Error: Record not found or failed to delete.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to delete record - " + ex.getMessage());
        }
        initializeTableView();
        initializeTableView2();
        initializeTableView3();
    }
    @FXML
    public void Select(ActionEvent event) throws IOException {
        ObservableList<modifierchambreController.Chambre> availableChambres = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            if(check_in.getValue()==null||check_out.getValue()==null){
                JOptionPane.showMessageDialog(null,"Please enter all the fiels!");
                return;
            }
            String sql = "SELECT num_chambre AS num, type_chambre AS typ, capacite AS cap" +
                    " FROM chambre" +
                    " WHERE num_chambre NOT IN(" +
                    "    SELECT num_chambre" +
                    "    FROM reservation" +
                    "    WHERE (? BETWEEN check_in_date AND check_out_date) OR (? BETWEEN check_in_date AND check_out_date)" +
                    ")";

            PreparedStatement statement = conn.prepareStatement(sql);


            statement.setDate(1, java.sql.Date.valueOf(check_in2.getValue()));
            statement.setDate(2,  java.sql.Date.valueOf(check_out2.getValue()) );




            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String num_chambre = resultSet.getString("num");
                String type_chambre = resultSet.getString("typ");
                int capacite = resultSet.getInt("cap");

                availableChambres.add(new modifierchambreController.Chambre(num_chambre, type_chambre, capacite));
            }





            tableView1.getColumns().clear();
            // Create columns
            TableColumn<modifierchambreController.Chambre, String> numCol = new TableColumn<>("Numéro Chambre");
            numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_chambre()));

            TableColumn<modifierchambreController.Chambre, String> typeCol = new TableColumn<>("Type");
            typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettype()));

            TableColumn<modifierchambreController.Chambre, String> capCol = new TableColumn<>("Capacité");
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
            tableView1.setItems(availableChambres);
            tableView1.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());
        }
    }
    @FXML
    public void Single(ActionEvent event) throws IOException {
        ObservableList<modifierchambreController.Chambre> availableChambres = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            menu.setText("Single");
            if(check_in.getValue()==null||check_out.getValue()==null){
                JOptionPane.showMessageDialog(null,"Please enter all the fiels!");
                return;
            }
            String sql = "SELECT num_chambre AS num, type_chambre AS typ, capacite AS cap" +
                    " FROM chambre" +
                    " WHERE type_chambre='Single' AND num_chambre NOT IN(" +
                    "    SELECT num_chambre" +
                    "    FROM reservation" +
                    "    WHERE (? BETWEEN check_in_date AND check_out_date) OR (? BETWEEN check_in_date AND check_out_date)" +
                    ")";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(check_in2.getValue()));
            statement.setDate(2, java.sql.Date.valueOf(check_out2.getValue()));



            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String num_chambre = resultSet.getString("num");
                String type_chambre = resultSet.getString("typ");
                int capacite = resultSet.getInt("cap");

                availableChambres.add(new modifierchambreController.Chambre(num_chambre, type_chambre, capacite));
            }


            tableView1.getColumns().clear();
            // Create columns
            TableColumn<modifierchambreController.Chambre, String> numCol = new TableColumn<>("Numéro Chambre");
            numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_chambre()));

            TableColumn<modifierchambreController.Chambre, String> typeCol = new TableColumn<>("Type");
            typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettype()));

            TableColumn<modifierchambreController.Chambre, String> capCol = new TableColumn<>("Capacité");
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
            tableView1.setItems(availableChambres);
            tableView1.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());

        }
    }
    @FXML
    public void Double(ActionEvent event) throws IOException {
        ObservableList<modifierchambreController.Chambre> availableChambres = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            menu.setText("Double");
            if(check_in.getValue()==null||check_out.getValue()==null){
                JOptionPane.showMessageDialog(null,"Please enter all the fiels!");
                return;
            }
            String sql = "SELECT num_chambre AS num, type_chambre AS typ, capacite AS cap" +
                    " FROM chambre" +
                    " WHERE type_chambre='Double' AND num_chambre NOT IN(" +
                    "    SELECT num_chambre" +
                    "    FROM reservation" +
                    "    WHERE (? BETWEEN check_in_date AND check_out_date) OR (? BETWEEN check_in_date AND check_out_date)" +
                    ")";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(check_in2.getValue()));
            statement.setDate(2, java.sql.Date.valueOf(check_out2.getValue()));



            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String num_chambre = resultSet.getString("num");
                String type_chambre = resultSet.getString("typ");
                int capacite = resultSet.getInt("cap");

                availableChambres.add(new modifierchambreController.Chambre(num_chambre, type_chambre, capacite));
            }


            tableView1.getColumns().clear();
            // Create columns
            TableColumn<modifierchambreController.Chambre, String> numCol = new TableColumn<>("Numéro Chambre");
            numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_chambre()));

            TableColumn<modifierchambreController.Chambre, String> typeCol = new TableColumn<>("Type");
            typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettype()));

            TableColumn<modifierchambreController.Chambre, String> capCol = new TableColumn<>("Capacité");
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
            tableView1.setItems(availableChambres);
            tableView1.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());
        }
    }
    @FXML
    public void Suite(ActionEvent event) throws IOException {
        ObservableList<modifierchambreController.Chambre> availableChambres = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            menu.setText("Suite");
            if(check_in.getValue()==null||check_out.getValue()==null){
                JOptionPane.showMessageDialog(null,"Please enter all the fiels!");
                return;
            }
            String sql = "SELECT num_chambre AS num, type_chambre AS typ, capacite AS cap" +
                    " FROM chambre" +
                    " WHERE type_chambre='Suite' AND num_chambre NOT IN(" +
                    "    SELECT num_chambre" +
                    "    FROM reservation" +
                    "    WHERE (? BETWEEN check_in_date AND check_out_date) OR (? BETWEEN check_in_date AND check_out_date)" +
                    ")";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(check_in2.getValue()));
            statement.setDate(2, java.sql.Date.valueOf(check_out2.getValue()));



            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String num_chambre = resultSet.getString("num");
                String type_chambre = resultSet.getString("typ");
                int capacite = resultSet.getInt("cap");

                availableChambres.add(new modifierchambreController.Chambre(num_chambre, type_chambre, capacite));
            }


            tableView1.getColumns().clear();
            // Create columns
            TableColumn<modifierchambreController.Chambre, String> numCol = new TableColumn<>("Numéro Chambre");
            numCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNum_chambre()));

            TableColumn<modifierchambreController.Chambre, String> typeCol = new TableColumn<>("Type");
            typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().gettype()));

            TableColumn<modifierchambreController.Chambre, String> capCol = new TableColumn<>("Capacité");
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
            tableView1.setItems(availableChambres);
            tableView1.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: Failed to create record - " + ex.getMessage());
        }

    }
    @FXML
    public void modifier_tab(MouseEvent event) {
        if (event.getClickCount() == 1) {
            reserv selectedItem = tableView2.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                num_reserv2.setText(String.valueOf(selectedItem.getNum_reserv()));
                num_cham2.setText(String.valueOf(selectedItem.getNum_cham()));
                cin2.setText(String.valueOf(selectedItem.getCin())); // Assuming cin is a String, no need for String.valueOf()

                // Handling null values for check-in and check-out dates

            }
        }
    }
    @FXML
    public void modifier_tab2(MouseEvent event) {
        if (event.getClickCount() == 1) {
            reserv selectedItem = tableView3.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                num_reserv3.setText(String.valueOf(selectedItem.getNum_reserv()));

            }
        }
    }

}
