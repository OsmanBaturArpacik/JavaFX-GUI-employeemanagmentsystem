package com.mycompany.employeemanagementsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {
    
    @FXML
    private Button close;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    //DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    @FXML
    public void loginAdmin() throws IOException, SQLException {
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
        
        connect = Database.connectDb();
        try{
            prepare = connect.prepareStatement(sql);
            prepare.setString(1,username.getText());
            prepare.setString(2, password.getText());
            
            result = prepare.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        Alert alert;
        
        if (username.getText().isEmpty()|| password.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all necessary fields.");
            alert.showAndWait();
        }
        else if (result.next()){
            GetData.username = username.getText();
            App.setRoot("dashboard");
        }
        else {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Wrong username or password");
            alert.showAndWait();
        }
    }

    public void close() {
        System.exit(0);
    }

}