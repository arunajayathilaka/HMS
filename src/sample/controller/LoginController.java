/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import java.net.URL;
import java.sql.SQLException;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.model.UserDAO;


/**
 * FXML Controller class
 *
 * @author aruna
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField txtUsername;
    
    @FXML 
    private PasswordField txtPassword;
    
    @FXML
    private Label lblMessage;
    
    @FXML
    private void btnLoginAction(ActionEvent event) throws SQLException, ClassNotFoundException{
        if(userLogin(txtUsername.getText(),txtPassword.getText())){
           lblMessage.setText("welcome : "+txtUsername.getText());
        }
        else{
            lblMessage.setText("username or password invalid!!");
            
        }
    }
    
    @FXML
    public boolean userLogin(String userId, String password) throws SQLException, ClassNotFoundException{
        return UserDAO.validate(userId, password); //loggedUser = User.of(userId);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
